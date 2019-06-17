package classiModels.beans;

public class LiensImages {

    private int    customerNumber, employeeNumber, ImageId;
    private String productCode;

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber( int customerNumber ) {
        this.customerNumber = customerNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber( int employeeNumber ) {
        this.employeeNumber = employeeNumber;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId( int imageId ) {
        ImageId = imageId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode( String productCode ) {
        this.productCode = productCode;
    }

}
