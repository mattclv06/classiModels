package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiModels.BDD.DAOFactory;
import classiModels.beans.Orders;
import classiModels.beans.OrdersDetails;

public class OrdersDAO extends AbstractDAO<Orders> {

    // REQUETE
    // Création d'un order ( Customers )
    private static final String CREATE_ORDER = "INSERT INTO Orders (orderNumber, orderDate , requiredDate, shippedDate , status , comments , customerNumber ) VALUES ( ? , ? ,  NOW() + INTERVAL 7 DAY , NOW() + INTERVAL 5 DAY  , 'In process' , ? ,  ? )";
    // Search dernier order number
    private static final String SEARCH_LAST_ORDER = "SELECT orderNumber FROM Orders ORDER BY orderNumber DESC limit 1";
    // Trouver tout les orders ( Employees )
    private static final String FIND_ALL_ORDERS = "SELECT * FROM Orders";
    // Trouver orders by filters
    private static final String FIND_ALL_ORDERS_BY_FILTERS = "SELECT * FROM Orders AS o"
            + " INNER JOIN ( SELECT * FROM Customers WHERE customerName LIKE ? ) AS c"
            + " ON o.customerNumber = c.customerNumber "
            + " INNER JOIN ( SELECT * FROM Payments WHERE paymentDate LIKE ? "
            + " AND paymentDate BETWEEN ? AND ? ) AS p"
            + " ON o.customerNumber = p.customerNumber"
            + " INNER JOIN orderdetails as od ON o.orderNumber = od.orderNumber"
            + " INNER JOIN products as pdt ON od.productCode = pdt.productCode"
            + " WHERE o.status LIKE ? AND pdt.productName LIKE  ? "
            + " AND o.orderDate LIKE ? AND o.shippedDate LIKE ? "
            + " AND o.orderDate BETWEEN ? AND ? "
            + " AND o.shippedDate BETWEEN ? AND ? "
            + " GROUP BY o.orderNumber";

    // CONSTRUCTEUR
    public OrdersDAO( DAOFactory daoFactory ) {
        super( daoFactory );
    }

    // CREATION DE L'ORDER et de ses Orders details
    public boolean create( Orders order ) {
        Connection connexion = null;
        PreparedStatement state = null, stateCreate = null;
        ResultSet result = null;
        try {

            connexion = daofactory.getConnection();

            state = initialisationRequetePreparee( connexion, SEARCH_LAST_ORDER, false );
            result = state.executeQuery();

            // TROUVER LE DERNIER ORDER NUMBER
            if ( result.first() ) {
                order.setOrderNumber( result.getInt( 1 ) + 1 );
            }

            // CREATION DE L'ORDER
            stateCreate = initialisationRequetePreparee( connexion, CREATE_ORDER, false,
                    order.getOrderNumber(), order.getOrderDate(),
                    order.getComments(), order.getCustomerNumber() );
            stateCreate.executeUpdate();

            // RECUPERER LE DAO OrderDetailsDAO
            OrdersDetailsDAO orderDetailsDAO = daofactory.getOrdersDetailsDAO();

            boolean b2 = true;
            // PARCOURIR ET CREER CHAQUE ORDRE DETAILS
            for ( OrdersDetails orderDetails : order.getListOrderDetails() ) {
                orderDetails.setOrderNumber( order.getOrderNumber() );
                boolean b = orderDetailsDAO.create( orderDetails, connexion );
                if ( !b ) {
                    b2 = false;
                }
            }

            if ( b2 ) {

                return true;
            } else {
                return false;
            }

        } catch ( SQLException e ) {
            e.printStackTrace();
            return false;
        } finally {
            fermeturesSilencieuses( result, state, connexion );
            fermetureSilencieuse( stateCreate );
        }
    }

    // Méthode permettant de récupérer les Orders sans caractéristique et avec
    // un index limit a 20
    public ArrayList<Orders> findAllOrders() {
        ArrayList<Orders> listOrders = new ArrayList<Orders>();
        Connection connexion = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            connexion = daofactory.getConnection();
            state = initialisationRequetePreparee( connexion, FIND_ALL_ORDERS, false );
            result = state.executeQuery();

            // RECUPERER LE DAO OrderDetailsDAO
            OrdersDetailsDAO orderDetailsDAO = daofactory.getOrdersDetailsDAO();
            CustomersDAO customDAO = daofactory.getCustomersDAO();

            while ( result.next() ) {
                Orders orders = map( result );
                orders.setListOrderDetails( orderDetailsDAO.findByOrderNumber( orders.getOrderNumber(), connexion ) );
                orders.setCustomers( customDAO.find( orders.getCustomerNumber(), connexion ) );
                listOrders.add( orders );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state, connexion );
        }
        return listOrders;
    }

    // Méthode permettant de récupérer les Orders avec filtre et avec
    // un index limit a 20
    public ArrayList<Orders> findAllOrdersByFilters( String customerName, String paymentDate, String status,
            String prodName, String paymentStart, String paymentEnd, String orderDate, String orderDateStart,
            String orderDateEnd, String shippedDate, String shippedDateStart, String shippedDateEnd ) {
        ArrayList<Orders> listOrders = new ArrayList<Orders>();
        Connection connexion = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            connexion = daofactory.getConnection();
            state = initialisationRequetePreparee( connexion, FIND_ALL_ORDERS_BY_FILTERS, false, customerName,
                    paymentDate, paymentStart, paymentEnd, status, prodName, orderDate, shippedDate,
                    orderDateStart, orderDateEnd, shippedDateStart, shippedDateEnd );
            result = state.executeQuery();

            // RECUPERER LE DAO OrderDetailsDAO
            OrdersDetailsDAO orderDetailsDAO = daofactory.getOrdersDetailsDAO();
            CustomersDAO customDAO = daofactory.getCustomersDAO();

            while ( result.next() ) {
                Orders orders = map( result );
                orders.setListOrderDetails( orderDetailsDAO.findByOrderNumber( orders.getOrderNumber(), connexion ) );
                orders.setCustomers( customDAO.find( orders.getCustomerNumber(), connexion ) );
                listOrders.add( orders );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state, connexion );
        }
        return listOrders;
    }

    // METHODE DE CREATION / RECUPERATION DE L'OBJET ORDERS
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
