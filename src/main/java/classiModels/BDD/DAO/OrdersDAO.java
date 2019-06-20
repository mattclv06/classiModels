package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiModels.BDD.DAOFactory;
import classiModels.beans.Orders;

public class OrdersDAO extends AbstractDAO<Orders> {

    // REQUETE

    // Trouver orders by filters
    private static final String ToutLaListe = "SELECT * FROM Orders AS o"
            + " INNER JOIN Customers AS c"
            + " ON o.customerNumber = c.customerNumber "
            + " INNER JOIN Payments AS p"
            + " ON o.customerNumber = p.customerNumber"
            + " INNER JOIN orderdetails as od ON o.orderNumber = od.orderNumber"
            + " INNER JOIN products as pdt ON od.productCode = pdt.productCode"
            + " WHERE c.customerName LIKE ? AND p.paymentDate LIKE ? AND o.orderDate LIKE ? AND o.shippedDate LIKE ? "
            + " AND pdt.productName LIKE ? AND o.status LIKE ? "
            + " GROUP BY o.orderNumber";

    // CONSTRUCTEUR
    public OrdersDAO( DAOFactory daoFactory ) {
        super( daoFactory );
    }

    public ArrayList<Orders> Recuperer( String customerName, String paymentDate, String orderDate,
            String productName,
            String shippedDate, String status ) {
        ArrayList<Orders> listOrders = new ArrayList<Orders>();
        Connection connexion = null;
        PreparedStatement state = null;
        ResultSet result = null;

        try {
            connexion = daofactory.getConnection();
            state = initialisationRequetePreparee( connexion, ToutLaListe, false, customerName,
                    paymentDate, orderDate, productName, shippedDate, status );
            result = state.executeQuery();

            // RECUPERER LE DAO OrderDetailsDAO
            OrdersDetailsDAO orderDetailsDAO = daofactory.getOrdersDetailsDAO();

            while ( result.next() ) {
                Orders orders = map( result );
                orders.setListOrderDetails( orderDetailsDAO.findByOrderNumber( orders.getOrderNumber(), connexion ) );
                listOrders.add( orders );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state, connexion );
        }
        return listOrders;
    }

    @Override
    public Orders map( ResultSet result ) throws SQLException {
        Orders order = new Orders();
        order.setOrderNumber( result.getInt( 1 ) );
        order.setOrderDate( result.getDate( 2 ) );
        order.setRequiredDate( result.getDate( 3 ) );
        order.setShippedDate( result.getDate( 4 ) );
        order.setStatus( result.getString( 5 ) );
        order.setComments( result.getString( 6 ) );
        order.setCustomerNumber( result.getInt( 7 ) );
        return order;
    }

}
