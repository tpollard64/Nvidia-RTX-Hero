import java.io.CharArrayReader;
import java.util.ArrayList;

public class Card {
    private String series;
    private String brand;
    private String model;
    private String sku;
    private String url;
    private String price;


    public Card(){

    }

    public Card(String inputSeries, String inputBrand, String inputModel, String inputSku, String inputURL, String inputPrice){
        this.series = inputSeries;
        this.brand = inputBrand;
        this.model = inputModel;
        this.sku = inputSku;
        this.url = inputURL;
        this.price = inputPrice;
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

    public void buildCards(String inputSeries, String inputStore){
        if (inputSeries.equals("3090") && inputStore.equals("Newegg")){

        }
        else if (inputSeries.equals("3080")){
            //do this
        }
        else if (inputSeries.endsWith("3070")){
            //do this
        }
        else {
            System.out.println("Enter 3090, 3080, or 3070");
        }
    }

}
