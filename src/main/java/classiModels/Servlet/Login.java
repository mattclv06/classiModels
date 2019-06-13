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
    private static final String VUECLIENT        = "/WEB-INF/LogClient.jsp";
    private static final String VUEEPLOYEE       = "/WEB-INF/LogEmployee.jsp";
    private static final String VUEINDEX         = "index.html";

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
        HttpSession session = request.getSession( true );

        if ( connectCustom.getResultat() == 1 ) {
            session.setAttribute( "login", userCustom );
            session.setAttribute( "isConnected", true );
            System.out.println( "ok" );
            request.getRequestDispatcher( VUECLIENT ).forward( request, response );
        } else if ( connectEmplo.getResultat() == 1 ) {
            session.setAttribute( "login", userEmploy );
            session.setAttribute( "isConnected", true );
            request.getRequestDispatcher( VUEEPLOYEE ).forward( request, response );
        } else {
            session.setAttribute( "isConnected", false );
            request.getRequestDispatcher( VUEINDEX ).forward( request, response );
        }

    }

}
