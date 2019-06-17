package classiModels.beans;

public class ProductLines {

    private String productLine, textDescription, htmlDescription;
    private String image;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine( String productLine ) {
        this.productLine = productLine;
    }

    public String getImage() {
        return image;
    }

    public void setImage( String image ) {
        this.image = image;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription( String textDescription ) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription( String htmlDescription ) {
        this.htmlDescription = htmlDescription;
    }

}
