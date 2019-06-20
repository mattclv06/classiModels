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
import classiModels.BDD.DAO.OrdersDAO;
import classiModels.beans.Orders;

/**
 * Servlet implementation class Find
 */
@WebServlet( "/Find" )
public class Find extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrdersDAO         orderDAO;

    @Override
    public void init() throws ServletException {
        this.orderDAO = DAOFactory.getInstance().getOrdersDAO();
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        ArrayList<Orders> listCommande = null;

        System.out.println( "coucou" );
        // recupere param requete
        String customerName = "%" + request.getParameter( "CustoName" ) + "%";
        String paymentDate = request.getParameter( "PayDate" ) + "%";
        String orderDate = request.getParameter( "OrdDate" ) + "%";
        String shippedDate = request.getParameter( "DateEnvFin" ) + "%";
        String productName = "%" + request.getParameter( "ProductsName" ) + "%";
        String status = "%" + request.getParameter( "Status" ) + "%";

        listCommande = orderDAO.Recuperer( customerName, paymentDate, orderDate, shippedDate, productName, status );

        HttpSession session = request.getSession();

        session.setAttribute( "listeOrders", listCommande );
        if ( listCommande != null ) {
            request.getRequestDispatcher( "/WEB-INF/ConnectClientOrEmploy/resultatRecherche.jsp" ).forward( request,
                    response );

        }

    }

}
