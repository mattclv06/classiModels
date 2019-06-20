package classiModels.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classiModels.beans.Products;

/**
 * Servlet implementation class SupPanier
 */
public class SupPanier extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String NOM_DU_PANIER    = "listProductInPanier";

    private ArrayList<Products> listProduit;

    public SupPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        System.out.println( "oui oui oui " );
        // recupere param requete
        String id = request.getParameter( "id" );
        int quantity = Integer.parseInt( request.getParameter( "quantite" ) );

        HttpSession session = request.getSession();
        ArrayList<Products> listProduit = (ArrayList<Products>) session.getAttribute( NOM_DU_PANIER );

        if ( request.getParameter( "plus" ) != null ) {
            for ( Products p : listProduit ) {
                if ( p.getProductCode().equals( id ) ) {
                    p.setQuProduit( p.getQuProduit() + quantity );
                    System.out.println( p.getQuProduit() );

                }
            }
        } else if ( request.getParameter( "moins" ) != null ) {
            Products produitASupprimer = null;
            for ( Products p : listProduit ) {
                if ( p.getProductCode().equals( id ) ) {
                    p.setQuProduit( p.getQuProduit() - quantity );
                    if ( p.getQuProduit() <= 0 ) {
                        produitASupprimer = p;
                    }
                    System.out.println( p.getQuProduit() );
                }

            }

            listProduit.remove( produitASupprimer );
        }
        request.getRequestDispatcher( "/WEB-INF/ConnectClientOrEmploy/panier.jsp" ).forward( request, response );
    }

}
