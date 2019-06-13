package classiModels.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classiModels.BDD.DAOFactory;
import classiModels.BDD.DAO.UserConnectDAOImpl;
import classiModels.beans.UserConnect;
import classiModels.tools.Forms;

/**
 * Servlet implementation class Login
 */
@WebServlet( "/Login" )
public class Login extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String VUE              = "/WEB-INF/login.jsp";

    private UserConnectDAOImpl  userconnectDAO;

    @Override
    public void init() throws ServletException {
        this.userconnectDAO = DAOFactory.getInstance().getUserConnectDAO();
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        Forms connectCustom = new Forms( userconnectDAO );
        Forms connectEmplo = new Forms( userconnectDAO );
        UserConnect userCustom = connectCustom.ConnectionCustom( request );
        UserConnect userEmploy = connectEmplo.ConnectionEmploy( request );

        // pour la deconnexion faire la methode
        /*
         * session.invalidate();
         */
        System.out.println( "in the dooPost" );
        HttpSession session = request.getSession( true );

        if ( connectCustom.getResultat() == 1 ) {
            session.setAttribute( "login", userCustom );
            System.out.println( "ok" );
            request.getRequestDispatcher( "/WEB-INF/login2.jsp" ).forward( request, response );
        } else if ( connectEmplo.getResultat() == 1 ) {
            request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
        } else {
            session.setAttribute( "isConnected", false );
            request.getRequestDispatcher( "index.html" ).forward( request, response );

        }
    }

}
