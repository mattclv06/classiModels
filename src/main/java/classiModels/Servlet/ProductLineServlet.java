package classiModels.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classiModels.BDD.DAOFactory;
import classiModels.BDD.DAO.ProductsDAO;
import classiModels.beans.Products;

public class ProductLineServlet extends HttpServlet {

    private static final long   serialVersionUID = 1L;
    private static final String maListe          = "ListProduct";
    private ProductsDAO         productDAO;
    private String              At_Index         = "index";

    @Override
    public void init() throws ServletException {
        this.productDAO = DAOFactory.getInstance().getProductsDAO();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        System.out.println( "Dans ton GET " );
        response.getWriter().write( "Dans ton GET" );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        String productLine = request.getParameter( "modele" );

        int index = 0;

        if ( request.getParameter( "suivant" ) != null ) {
            index = Integer.parseInt( request.getParameter( "index" ) ) + 5;
        } else if ( request.getParameter( "precedent" ) != null ) {
            index = Integer.parseInt( request.getParameter( "index" ) ) - 5;
        }

        ArrayList<Products> listProduct = productDAO.trouver( productLine, index );
        request.setAttribute( maListe, listProduct );
        request.setAttribute( At_Index, index );
        request.getRequestDispatcher( "/WEB-INF/ConnectClientOrEmploy/MorceauModele.jsp" ).forward( request, response );
    }

}
