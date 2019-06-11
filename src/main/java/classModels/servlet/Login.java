package classModels.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classiModels.DAOFactory.ConnectionLog;
import classiModels.DAOFactory.DAOFactory;
import classiModels.UserConnect.UserConnect;
import classiModels.UserConnectDAO.UserConnectDAO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
    private static final String CONF_DAO_FACTORY = "daofactory";
    private static final String VUE              = "/WEB-INF/login.jsp";

    private UserConnectDAO      userconnectDAO;

    private static final long   serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        this.userconnectDAO = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserConnectDAO();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        ConnectionLog connect = new ConnectionLog( userconnectDAO );
        UserConnect user = connect.Connection( request );

        // pour la deconnexion faire la methode
        /*
         * session.invalidate();
         */
        System.out.println( "in the doPost" );
        HttpSession session = request.getSession( true );

        if ( connect.getResultat() == 1 ) {
            session.setAttribute( "login", user );
            session.setAttribute( "isConnected", true );
            request.getRequestDispatcher( "/WEB-INF/Connected.jsp" ).forward( request, response );
        } else {
            session.setAttribute( "isConnected", false );
            request.getRequestDispatcher( VUE ).forward( request, response );
        }

    }

}
