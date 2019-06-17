package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiModels.BDD.DAOFactory;
import classiModels.beans.OrdersDetails;

public class OrdersDetailsDAO extends AbstractDAO<OrdersDetails> {
    // REQUETES
    private static final String CREATE_ORDER_DETAILS = "INSERT INTO OrderDetails ( orderNumber, productCode, quantityOrdered , priceEach, orderLineNumber) VALUES ( ? , ? , ? , ?  , ? )";
    private static final String FIND_BY_ORDER_NUMBER = "SELECT * FROM OrderDetails WHERE orderNumber = ?";

    // CONSTRUCTEUR
    public OrdersDetailsDAO( DAOFactory daoFactory ) {
        super( daoFactory );
    }

    public boolean create( OrdersDetails orderDetails, Connection connexion ) {
        PreparedStatement state = null;
        try {

            // CREATION DE L'ORDERDetails
            connexion = daofactory.getConnection();
            state = initialisationRequetePreparee( connexion, CREATE_ORDER_DETAILS, false,
                    orderDetails.getOrderNumber(), orderDetails.getProductCode(),
                    orderDetails.getQuantityOrder(), orderDetails.getPriceEach(), orderDetails.getOrderLineNumber() );
            state.executeUpdate();

            return true;
        } catch ( SQLException e ) {
            e.printStackTrace();
            return false;
        } finally {
            fermetureSilencieuse( state );
        }
    }

    public ArrayList<OrdersDetails> findByOrderNumber( int orderNumber, Connection connexion ) {
        ArrayList<OrdersDetails> listOrderDetails = new ArrayList<OrdersDetails>();
        PreparedStatement state = null;
        ResultSet result = null;

        try {
            state = initialisationRequetePreparee( connexion, FIND_BY_ORDER_NUMBER, false, orderNumber );
            result = state.executeQuery();

            while ( result.next() )
                listOrderDetails.add( map( result ) );

        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state );
        }
        return listOrderDetails;
    }

    // METHODE DE CREATION / RECUPERATION DE L'OBJET ORDERDETAILS
    @Override
    public OrdersDetails map( ResultSet result ) throws SQLException {
        OrdersDetails orderDetails = new OrdersDetails();
        orderDetails.setOrderNumber( result.getInt( 1 ) );
        orderDetails.setProductCode( result.getString( 2 ) );
        orderDetails.setQuantityOrder( result.getInt( 3 ) );
        orderDetails.setPriceEach( result.getFloat( 4 ) );
        orderDetails.setOrderLineNumber( result.getInt( 5 ) );
        return orderDetails;
    }

}
