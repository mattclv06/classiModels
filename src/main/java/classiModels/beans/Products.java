package classiModels.beans;

public class Products {
    private String      productCode, productName, productLine, productScale, productVendor, productDescription;
    private int         quantityInStock;
    private float       buyPrice;
    private float       msrp;
    private Images      img;
    private LiensImages liensImages;
    private int         quProduit;
    private double      total;

    public double getTotal() {
        return Math.round( ( buyPrice * quProduit ) * 100.00 ) / 100.00;
    }

    public void setTotal( double total ) {
        this.total = total;
    }

    public int getQuProduit() {
        return quProduit;
    }

    public void setQuProduit( int quProduit ) {
        this.quProduit = quProduit;
    }

    public LiensImages getLiensImages() {
        return liensImages;
    }

    public void setLiensImages( LiensImages liensImages ) {
        this.liensImages = liensImages;
    }

    public Images getImg() {
        return img;
    }

    public void setImg( Images img ) {
        this.img = img;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode( String productCode ) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName( String productName ) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine( String productLine ) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale( String productScale ) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor( String productVendor ) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription( String productDescription ) {
        this.productDescription = productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock( int quantityInStock ) {
        this.quantityInStock = quantityInStock;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice( float buyPrice ) {
        this.buyPrice = buyPrice;
    }

    public float getMsrp() {
        return msrp;
    }

    public void setMsrp( float msrp ) {
        this.msrp = msrp;
    }
}
