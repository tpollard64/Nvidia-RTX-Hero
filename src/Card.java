import java.io.CharArrayReader;
import java.util.ArrayList;

public class Card {
    private String series;
    private String brand;
    private String model;
    private String sku;
    private String url;
    private String price;
    private String addToCartURL;
    private Website website;


    public Card(){

    }

    public Card(String inputSeries, String inputBrand, String inputModel, String inputSku, String inputURL, String inputPrice, Website inputWebsite){
        this.series = inputSeries;
        this.brand = inputBrand;
        this.model = inputModel;
        this.sku = inputSku;
        this.url = inputURL;
        this.price = inputPrice;
        this.addToCartURL = null;
        this.website = inputWebsite;
    }

    @Override
    public String toString() {
        return "Card{" +
                "series='" + series + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", sku='" + sku + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                '}';
    }

    public String getSeries(){
        return series;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSku() {
        return sku;
    }

    public String getUrl() {
        return url;
    }

    public String getPrice() {
        return price;
    }

    public Website getWebsite(){
        return website;
    }

    public String getAddToCartURL() {
        addToCartURL = "https://api.bestbuy.com/click/-/" + sku + "/cart";
        return addToCartURL;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPrice(String inputPrice) {
        this.price = inputPrice;
    }

    public void setAddToCartURL(String inputAddToCartURL){
        this.addToCartURL = inputAddToCartURL;
    }

}
