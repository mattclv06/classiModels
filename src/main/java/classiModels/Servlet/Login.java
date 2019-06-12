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

        String ChampLog = request.getParameter( "log" );
        String ChampPass = request.getParameter( "pass" );
        // String regex = "(!)";
        //
        // ChampLog.matches( regex );

        Forms connect = new Forms( userconnectDAO );
        UserConnect user = connect.Connection( request );

        // pour la deconnexion faire la methode
        /*
         * session.invalidate();
         */
        System.out.println( "in the doPost" );
        HttpSession session = request.getSession( true );

        if ( connect.getResultat() == 1 ) {
            session.setAttribute( "login", user );
            System.out.println( "ok" );
            request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
        } else {
            session.setAttribute( "isConnected", false );
            request.getRequestDispatcher( "index.html" ).forward( request, response );
        }
    }

}
