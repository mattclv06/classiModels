package classiModels.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classiModels.BDD.DAOFactory;
import classiModels.BDD.DAO.ProductLinesDAO;
import classiModels.BDD.DAO.ProductsDAO;
import classiModels.BDD.DAO.UserConnectDAOImpl;
import classiModels.beans.ProductLines;
import classiModels.beans.Products;
import classiModels.beans.UserConnect;
import classiModels.tools.Forms;

/**
 * Servlet implementation class Login
 */
@WebServlet( "/Login" )
public class LoginServlet extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String VUECLIENT        = "/WEB-INF/LogClient.jsp";
    private static final String VUEEPLOYEE       = "/WEB-INF/LogEmployee.jsp";
    private static final String VUEINDEX         = "index.html";

    private static final String maListe          = "ListProduct";

    private UserConnectDAOImpl  userconnectDAO;
    private ProductsDAO         productDAO;
    private ProductLinesDAO     productLineDAO;

    @Override
    public void init() throws ServletException {
        this.userconnectDAO = DAOFactory.getInstance().getUserConnectDAO();
        this.productDAO = DAOFactory.getInstance().getProductsDAO();
        this.productLineDAO = DAOFactory.getInstance().getProductLinesDAO();
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    	Forms connectCustom = new Forms( userconnectDAO );
        Forms connectEmplo = new Forms( userconnectDAO );
        UserConnect userCustom = connectCustom.ConnectionCustom( request );
        UserConnect userEmploy = connectEmplo.ConnectionEmploy( request );

        StringBuilder sb = new StringBuilder();
        String lienImageCustom = "./img/Customers/";
        String lienImageEmploye = "./img/Employees/";

        // pour la deconnexion faire la methode
        /*
         * session.invalidate();
         */
        HttpSession session = request.getSession( true );

        if ( connectCustom.getResultat() == 1 ) {
            session.setAttribute( "login", userCustom );
            session.setAttribute( "isConnected", true );
            System.out.println( "ok" );
            sb.append( lienImageCustom ).append( userconnectDAO.getPhoto() );
            session.setAttribute( "image", sb.toString() );
            /*
             * retourne une liste de produits
             */
            ArrayList<Products> listProduct = productDAO.trouver( "Classic Cars" );
            System.out.println( "je suis la " );
            ArrayList<ProductLines> listLine = productLineDAO.findAll();
            request.setAttribute( "listLine", listLine );
            request.setAttribute( maListe, listProduct );
            /*
             * renvoi vers la vue
             */
            request.getRequestDispatcher( VUECLIENT ).forward( request, response );
            System.out.println( sb );
        } else if ( connectEmplo.getResultat() == 1 ) {
            session.setAttribute( "login", userEmploy );
            session.setAttribute( "isConnected", true );
            sb.append( lienImageEmploye ).append( userconnectDAO.getPhoto() );
            session.setAttribute( "image", sb.toString() );
            request.getRequestDispatcher( VUEEPLOYEE ).forward( request, response );
        } else {
            session.setAttribute( "isConnected", false );
            request.getRequestDispatcher( VUEINDEX ).forward( request, response );
}
    }

}
