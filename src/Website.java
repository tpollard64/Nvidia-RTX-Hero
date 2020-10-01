public class Website {
    private String url;
    private String websiteName;


    public Website(){

    }

    @Override
    public String toString() {
        return "Website{" +
                "url='" + url + '\'' +
                ", websiteName='" + websiteName + '\'' +
                '}';
    }

    public String getUrl(){
        return url;
    }

    public String getWebsiteName(){
        return websiteName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }
}



