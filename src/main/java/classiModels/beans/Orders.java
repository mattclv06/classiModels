package classiModels.beans;

import java.sql.Date;
import java.util.ArrayList;

public class Orders {

    private int                      orderNumber, customerNumber;
    private Date                     orderDate, requiredDate, shippedDate;
    private String                   status, comments;
    private ArrayList<OrdersDetails> listOrderDetails;
    private Customers                customers;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber( int orderNumber ) {
        this.orderNumber = orderNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber( int customerNumber ) {
        this.customerNumber = customerNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate( Date orderDate ) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate( Date requiredDate ) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate( Date shippedDate ) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments( String comments ) {
        this.comments = comments;
    }

    public ArrayList<OrdersDetails> getListOrderDetails() {
        return listOrderDetails;
    }

    public void setListOrderDetails( ArrayList<OrdersDetails> listOrderDetails ) {
        this.listOrderDetails = listOrderDetails;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers( Customers customers ) {
        this.customers = customers;
    }

}
