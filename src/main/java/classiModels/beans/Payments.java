package classiModels.beans;

import java.sql.Date;

public class Payments {

    private int    customerNumber;
    private String checkNumber;
    private Date   paymentsDate;
    private float  amount;

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber( int customerNumber ) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber( String checkNumber ) {
        this.checkNumber = checkNumber;
    }

    public Date getPaymentsDate() {
        return paymentsDate;
    }

    public void setPaymentsDate( Date paymentsDate ) {
        this.paymentsDate = paymentsDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount( float amount ) {
        this.amount = amount;
    }

}
