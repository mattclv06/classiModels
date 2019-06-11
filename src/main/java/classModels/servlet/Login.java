package classModels.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classiModels.DAOFactory.ConnectionLog;
import classiModels.DAOFactory.DAOFactory;
import classiModels.LoginConnect.LoginConnect;
import classiModels.LoginConnectDAO.LoginConnectDAO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
    private static final String CONF_DAO_FACTORY = "daofactory";
    private static final String VUE              = "/WEB-INF/login.jsp";

    private LoginConnectDAO     LoginconnectDAO;

    private static final long   serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        System.out.println( "entrée init" );
        System.out.println( getServletContext() + "" + getServletContext().getAttribute( CONF_DAO_FACTORY ) );
        this.LoginconnectDAO = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) )
                .getLoginConnectDAO();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        ConnectionLog connect = new ConnectionLog( LoginconnectDAO );
        LoginConnect Login = connect.Connection( request );

        // pour la deconnexion faire la methode
        /*
         * session.invalidate();
         */
        System.out.println( "in the doPost" );
        HttpSession session = request.getSession( true );

        if ( connect.getResultat() == 1 ) {
            session.setAttribute( "login", Login );
            session.setAttribute( "isConnected", true );
            request.getRequestDispatcher( "/WEB-INF/Connected.jsp" ).forward( request, response );
        } else {
            session.setAttribute( "isConnected", false );
            request.getRequestDispatcher( VUE ).forward( request, response );
        }

    }

}
