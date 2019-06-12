package classiModels.beans;

public class Customers {

    private String customerName, contactName, contactFirstName, phone, adressLine1, adressLine2, city,
            state, postalCode, country;
    private int    customerNumber, salesRepEmployeeNumber;
    private float  creditLimit;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName( String customerName ) {
        this.customerName = customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName( String contactName ) {
        this.contactName = contactName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName( String contactFirstName ) {
        this.contactFirstName = contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    public String getAdressLine1() {
        return adressLine1;
    }

    public void setAdressLine1( String adressLine1 ) {
        this.adressLine1 = adressLine1;
    }

    public String getAdressLine2() {
        return adressLine2;
    }

    public void setAdressLine2( String adressLine2 ) {
        this.adressLine2 = adressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState( String state ) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode( String postalCode ) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber( int customerNumber ) {
        this.customerNumber = customerNumber;
    }

    public int getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber( int salesRepEmployeeNumber ) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public float getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit( float creditLimit ) {
        this.creditLimit = creditLimit;
    }

}
