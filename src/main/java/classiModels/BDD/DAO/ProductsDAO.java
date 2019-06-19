package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiModels.BDD.DAOFactory;
import classiModels.beans.Products;

public class ProductsDAO extends AbstractDAO<Products> {

    String                      nomPhoto;
    private static final String SQL_Count = "SELECT * from products where productLine = ? limit 20 OFFSET ?";

    public ProductsDAO( DAOFactory daofactory ) {
        super( daofactory );

    }

    public ArrayList<Products> trouver( String productLine, int index ) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Products> products = new ArrayList<Products>();

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daofactory.getConnection();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * dans la DAOFactory (ici, la connexion + la requete SQL + le
             * boolean + les param ) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, SQL_Count, false, productLine, index );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
            while ( resultSet.next() ) {
                Products product = map( resultSet );
                product.setImg( daofactory.getImageDAO().findImage( product.getProductCode(), connexion ) );
                System.out.println( product.getImg().getNom() );
                products.add( product );
            }
        } catch ( SQLException e ) {
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return products;

    }

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    public Products map( ResultSet resultSet ) throws SQLException {
        Products products = new Products();
        products.setProductCode( resultSet.getString( 1 ) );
        products.setProductName( resultSet.getString( 2 ) );
        products.setProductLine( resultSet.getString( 3 ) );
        products.setProductDescription( resultSet.getString( 6 ) );
        products.setBuyPrice( resultSet.getFloat( 8 ) );
        products.setQuantityInStock( resultSet.getInt( 7 ) );
        return products;
    }

    public String getPhoto() {
        String sql = "SELECT nom FROM images inner join  liensimages on imageId = id where productCode = ?";

        try {
            // Crï¿½Ã©tion de la requï¿½te
            PreparedStatement statement = daofactory.getConnection().prepareStatement( sql );
            ResultSet resultat = statement.executeQuery( sql );
            resultat.next();

            nomPhoto = resultat.getString( 1 );

            resultat.close();

            statement.close();
            daofactory.getConnection().close();
        } catch ( SQLException exe ) {
            System.out.println( exe.getMessage() );
        }
        return nomPhoto;
    }

}
