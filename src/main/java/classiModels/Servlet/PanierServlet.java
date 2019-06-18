package classiModels.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classiModels.beans.Images;
import classiModels.beans.Products;

/**
 * Servlet implementation class PanierServlet
 */
public class PanierServlet extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String NOM_DU_PANIER    = "listProductInPanier";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        // recupere param requete
        String id = request.getParameter( "id" );
        int quantity = Integer.parseInt( request.getParameter( "quantite" ) );
        String image = request.getParameter( "img" );
        String pdtName = request.getParameter( "pdtName" );
        float prix = Float.parseFloat( request.getParameter( "price" ) );

        // recupere objet session
        HttpSession session = request.getSession();

        // creer un produit et stocker variable
        Products produit = new Products();
        produit.setProductCode( id );
        produit.setQuProduit( quantity );
        produit.setProductName( pdtName );
        produit.setBuyPrice( prix );
        Images img = new Images();
        img.setNom( image );
        produit.setImg( img );

        ArrayList<Products> listProduit = null;

        // SI listProduit existe en session ne pas la supprimer
        if ( session.getAttribute( NOM_DU_PANIER ) == null ) {
            // création list contenant tout le panier
            listProduit = new ArrayList<Products>();
            listProduit.add( produit );

            // Stock en session la liste de produit(Panier)
            session.setAttribute( NOM_DU_PANIER, listProduit );
        } else {
            listProduit = (ArrayList<Products>) session.getAttribute( NOM_DU_PANIER );
            boolean b = false;
            for ( Products p : listProduit ) {
                if ( p.getProductCode().equals( id ) ) {
                    p.setQuProduit( p.getQuProduit() + quantity );
                    b = true;
                }
            }
            if ( !b )
                listProduit.add( produit );

        }

        request.getRequestDispatcher( "/WEB-INF/ConnectClientOrEmploy/panier.jsp" ).forward( request, response );
    }

}
