public class Billing {
    private String streetAddress, city, state, zipCode, creditCardNumber, expMon, expYear, ccv;

    public Billing(){
    }

    @Override
    public String toString() {
        return "Billing{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", expMon='" + expMon + '\'' +
                ", expYear='" + expYear + '\'' +
                ", ccv='" + ccv + '\'' +
                '}';
    }

    public String getStreetAddress(){
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getExpMon() {
        return expMon;
    }

    public String getExpYear() {
        return expYear;
    }

    public String getCcv() {
        return ccv;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setExpMon(String expMon) {
        this.expMon = expMon;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }
}
