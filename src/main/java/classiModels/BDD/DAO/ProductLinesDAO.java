package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiModels.BDD.DAOFactory;
import classiModels.beans.ProductLines;

public class ProductLinesDAO extends AbstractDAO<ProductLines> {

    // REQUETES
    private static final String FIND_ALL_PRODUCTLINES = "SELECT * FROM ProductLines";

    // CONSTRUCTEUR
    public ProductLinesDAO( DAOFactory daoFactory ) {
        super( daoFactory );
    }

    // Méthode récupérant les productLines en BDD
    public ArrayList<ProductLines> findAll() {
        ArrayList<ProductLines> listProdLines = new ArrayList<ProductLines>();
        Connection connexion = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            connexion = daofactory.getConnection();
            state = initialisationRequetePreparee( connexion, FIND_ALL_PRODUCTLINES, false );
            result = state.executeQuery();

            while ( result.next() )
                listProdLines.add( map( result ) );

        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state, connexion );
        }
        return listProdLines;
    }

    // METHODE DE CREATION / RECUPERATION DE L'OBJET PRODUCTLINES
    @Override
    public ProductLines map( ResultSet result ) throws SQLException {
        ProductLines productLine = new ProductLines();
        productLine.setProductLine( result.getString( 1 ) );
        productLine.setTextDescription( result.getString( 2 ) );
        productLine.setHtmlDescription( result.getString( 3 ) );
        productLine.setImage( result.getString( 4 ) );
        return productLine;
    }

}
