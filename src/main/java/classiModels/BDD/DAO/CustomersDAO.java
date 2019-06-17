package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classiModels.BDD.DAOFactory;
import classiModels.beans.Customers;

public class CustomersDAO extends AbstractDAO<Customers> {

    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM Customers WHERE customerNumber = ?";

    // CONSTRUCTEUR
    public CustomersDAO( DAOFactory daofactory ) {
        super( daofactory );
    }

    // RECHERCHE UN CUSTOMER
    public Customers find( int id ) {
        Customers customer = null;
        Connection connexion = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            connexion = daofactory.getConnection();
            state = initialisationRequetePreparee( connexion, SELECT_CUSTOMER_BY_ID,
                    false, id );
            result = state.executeQuery();
            // Parcours result
            if ( result.first() ) {
                customer = map( result );
            }

            if ( customer != null ) {
                // APPEL AU DAO LiensImagesDAO pour prendre le liens du profile
                customer.setLiensImage(
                        daofactory.getLiensImagesDAO().findLiensCustom( customer.getCustomerNumber(),
                                connexion ) );

                if ( customer.getLiensImage() != null )
                    // Appel du DAO ImageDAO pour recupérer le nom de la photo
                    customer.setImg(
                            daofactory.getImagesDAO().findImage( customer.getLiensImage().getImageId(),
                                    connexion ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state, connexion );
        }
        return customer;
    }

    // RECHERCHE CUSTOMER AVEC CONNECTION
    public Customers find( int id, Connection connexion ) {
        Customers customer = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            connexion = daofactory.getConnection();
            state = initialisationRequetePreparee( connexion, SELECT_CUSTOMER_BY_ID,
                    false, id );
            result = state.executeQuery();
            // Parcours result
            if ( result.first() ) {
                customer = map( result );
            }

            if ( customer != null ) {
                // APPEL AU DAO LiensImagesDAO pour prendre le liens du profile
                customer.setLiensImage(
                        daofactory.getLiensImagesDAO().findLiensCustom( customer.getCustomerNumber(),
                                connexion ) );

                if ( customer.getLiensImage() != null )
                    // Appel du DAO ImageDAO pour recupérer le nom de la photo
                    customer.setImg(
                            daofactory.getImagesDAO().findImage( customer.getLiensImage().getImageId(),
                                    connexion ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state );
        }
        return customer;
    }

    // METHODE DE CREATION D'OBJET CUSTOMERS
    @Override
    public Customers map( ResultSet result ) throws SQLException {
        Customers customer = new Customers();
        customer.setCustomerNumber( result.getInt( 1 ) );
        customer.setCustomerName( result.getString( 2 ) );
        customer.setCustomerName( result.getString( 3 ) );
        customer.setContactFirstName( result.getString( 4 ) );
        customer.setPhone( result.getString( 5 ) );
        customer.setAdressLine1( result.getString( 6 ) );
        customer.setAdressLine2( result.getString( 7 ) );
        customer.setCity( result.getString( 8 ) );
        customer.setState( result.getString( 9 ) );
        customer.setPostalCode( result.getString( 10 ) );
        customer.setCountry( result.getString( 11 ) );
        customer.setSalesRepEmployeeNumber( result.getInt( 12 ) );
        customer.setCreditLimit( result.getFloat( 13 ) );
        return customer;
    }

}
