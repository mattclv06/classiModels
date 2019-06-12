package classiModels.beans;

public class OrderDetails {

    private int    orderNumber, quantityOrder, orderLineNumber;
    private float  priceEach;
    private String productCode;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber( int orderNumber ) {
        this.orderNumber = orderNumber;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder( int quantityOrder ) {
        this.quantityOrder = quantityOrder;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber( int orderLineNumber ) {
        this.orderLineNumber = orderLineNumber;
    }

    public float getPriceEach() {
        return priceEach;
    }

    public void setPriceEach( float priceEach ) {
        this.priceEach = priceEach;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode( String productCode ) {
        this.productCode = productCode;
    }
}
