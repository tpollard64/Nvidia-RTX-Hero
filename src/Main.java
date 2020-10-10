import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    Profile profile = new Profile(); // profile coming soon
    Billing billing = new Billing(); //billing auto fill coming soon
    Scanner scan = new Scanner(System.in); 


    public static final String ACCOUNT_SID = ""; // Your Twilio SID
    public static final String AUTH_TOKEN = ""; // Your Twilio Auto Token
    public static final String PHONE_NUMBER = ""; // Enter your phone number example : +12345678999
    public static final String TWILIO_NUMBER = ""; // Enter your twilio number +12345678999


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("--incognito");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);


        System.out.println("");
        System.out.println(ANSI_GREEN+"");
        System.out.println( "███╗   ██╗██╗   ██╗██╗██████╗ ██╗ █████╗     ██████╗ ████████╗██╗  ██╗    ██╗  ██╗███████╗██████╗  ██████╗ \n" +
                            "████╗  ██║██║   ██║██║██╔══██╗██║██╔══██╗    ██╔══██╗╚══██╔══╝╚██╗██╔╝    ██║  ██║██╔════╝██╔══██╗██╔═══██╗\n" +
                            "██╔██╗ ██║██║   ██║██║██║  ██║██║███████║    ██████╔╝   ██║    ╚███╔╝     ███████║█████╗  ██████╔╝██║   ██║\n" +
                            "██║╚██╗██║╚██╗ ██╔╝██║██║  ██║██║██╔══██║    ██╔══██╗   ██║    ██╔██╗     ██╔══██║██╔══╝  ██╔══██╗██║   ██║\n" +
                            "██║ ╚████║ ╚████╔╝ ██║██████╔╝██║██║  ██║    ██║  ██║   ██║   ██╔╝ ██╗    ██║  ██║███████╗██║  ██║╚██████╔╝\n" +
                            "╚═╝  ╚═══╝  ╚═══╝  ╚═╝╚═════╝ ╚═╝╚═╝  ╚═╝    ╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝    ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ \n" +
                             "                                                                                                           " + ANSI_RESET);

        Website newegg = new Website();
        Website bestbuy = new Website();


        ArrayList<Card> cards = new ArrayList<Card>();


        //for auto checkout function coming soon
        
        //  <<<< use two slashes to comment out the cards you are not interested in buying

        //cards.add(new Card("2060", "GIGABYTE", "GIGABYTE GeForce RTX 2060 DirectX 12 GV-N2060GAMINGOC PRO-6GD Ver 2.0 6GB 192-Bit GDDR6 PCI Express 3.0 x16 ATX Video Card", "N82E16814932225","https://www.newegg.com/gigabyte-geforce-rtx-2060-gv-n2060gamingoc-pro-6gd-ver-2-0/p/N82E16814932225?Description=2060&cm_re=2060-_-14-932-225-_-Product", "359.99", newegg));
        cards.add(new Card("3090","ASUS", "ASUS TUF Gaming GeForce RTX 3090 DirectX 12 TUF-RTX3090-O24G-GAMING 24GB 384-Bit GDDR6X PCI Express 4.0 x16 HDCP Ready SLI Support Video Card", "N82E16814126454", "https://www.newegg.com/asus-geforce-rtx-3090-tuf-rtx3090-o24g-gaming/p/N82E16814126454?Description=3090&cm_re=3090-_-14-126-454-_-Product&quicklink=true", "1599.99", newegg));
        cards.add(new Card("3090","ASUS", "ASUS TUF Gaming GeForce RTX 3090 TUF-RTX3090-24G-GAMING Video Card", "N82E16814126455", "https://www.newegg.com/asus-geforce-rtx-3090-tuf-rtx3090-24g-gaming/p/N82E16814126455?Description=3090&cm_re=3090-_-14-126-455-_-Product", "1499.99", newegg));
        cards.add(new Card("3090","ASUS", "ASUS ROG Strix GeForce RTX 3090 DirectX 12 ROG-STRIX-RTX3090-O24G-GAMING 24GB 384-Bit GDDR6X PCI Express 4.0 x16 HDCP Ready SLI Support Video Card", "N82E16814126456", "https://www.newegg.com/asus-geforce-rtx-3090-rog-strix-rtx3090-o24g-gaming/p/N82E16814126456?Description=3090&cm_re=3090-_-14-126-456-_-Product", "1799.99", newegg));
        cards.add(new Card("3090","EVGA", "EVGA GeForce RTX 3090 FTW3 ULTRA GAMING Video Card, 24G-P5-3987-KR, 24GB GDDR6X, iCX3 Technology, ARGB LED, Metal Backplate", "N82E16814487526", "https://www.newegg.com/evga-geforce-rtx-3090-24g-p5-3987-kr/p/N82E16814487526?Description=3090&cm_re=3090-_-14-487-526-_-Product", "1799.99", newegg));
        cards.add(new Card("3090","EVGA", "EVGA GeForce RTX 3090 FTW3 GAMING Video Card, 24G-P5-3985-KR, 24GB GDDR6X, iCX3 Technology, ARGB LED, Metal Backplate", "N82E16814487525", "https://www.newegg.com/evga-geforce-rtx-3090-24g-p5-3985-kr/p/N82E16814487525?Description=3090&cm_re=3090-_-14-487-525-_-Product", "1729.99",newegg));
        cards.add(new Card("3090","EVGA", "EVGA GeForce RTX 3090 XC3 ULTRA GAMING Video Card, 24G-P5-3975-KR, 24GB GDDR6X, iCX3 Cooling, ARGB LED, Metal Backplate", "N82E16814487524", "https://www.newegg.com/evga-geforce-rtx-3090-24g-p5-3975-kr/p/N82E16814487524?Description=3090&cm_re=3090-_-14-487-524-_-Product&quicklink=true", "1619.99", newegg));
        cards.add(new Card("3090","EVGA", "EVGA GeForce RTX 3090 XC3 GAMING Video Card, 24G-P5-3973-KR, 24GB GDDR6X, iCX3 Cooling, ARGB LED, Metal Backplate", "N82E16814487523", "https://www.newegg.com/evga-geforce-rtx-3090-24g-p5-3973-kr/p/N82E16814487523?Description=3090&cm_re=3090-_-14-487-523-_-Product", "1549.99", newegg));
        cards.add(new Card("3090","EVGA", "EVGA GeForce RTX 3090 XC3 BLACK GAMING Video Card, 24G-P5-3971-KR, 24GB GDDR6X, iCX3 Cooling, ARGB LED", "N82E16814487527", "https://www.newegg.com/evga-geforce-rtx-3090-24g-p5-3971-kr/p/N82E16814487527?Description=3090&cm_re=3090-_-14-487-527-_-Product", "1499.99", newegg));
        cards.add(new Card("3090","MSI", "MSI GeForce RTX 3090 DirectX 12 RTX 3090 GAMING X TRIO 24G 24GB 384-Bit GDDR6X PCI Express 4.0 HDCP Ready SLI Support Video Card", "N82E16814137595", "https://www.newegg.com/msi-geforce-rtx-3090-rtx-3090-gaming-x-trio-24g/p/N82E16814137595?Description=3090&cm_re=3090-_-14-137-595-_-Product&quicklink=true", "1589.99", newegg));
        cards.add(new Card("3090","MSI", "MSI GeForce RTX 3090 DirectX 12 RTX 3090 VENTUS 3X 24G OC 24GB 384-Bit GDDR6X PCI Express 4.0 HDCP Ready SLI Support Video Card", "N82E16814137596", "https://www.newegg.com/msi-geforce-rtx-3090-rtx-3090-ventus-3x-24g-oc/p/N82E16814137596?Description=3090&cm_re=3090-_-14-137-596-_-Product", "1549.99", newegg));
        cards.add(new Card("3090","MSI", "MSI GeForce RTX 3090 DirectX 12 RTX 3090 VENTUS 3X 24G 24GB 384-Bit GDDR6X PCI Express 4.0 HDCP Ready SLI Support Video Card", "N82E16814137599", "https://www.newegg.com/msi-geforce-rtx-3090-rtx-3090-ventus-3x-24g/p/N82E16814137599?Description=3090&cm_re=3090-_-14-137-599-_-Product", "1499.99",newegg));
        cards.add(new Card("3090","GIGABYTE", "GIGABYTE GeForce RTX 3090 DirectX 12 GV-N3090GAMING OC-24GD 24GB 384-Bit GDDR6X PCI Express 4.0 x16 SLI Support ATX Video Card", "N82E16814932327", "https://www.newegg.com/gigabyte-geforce-rtx-3090-gv-n3090gaming-oc-24gd/p/N82E16814932327?Description=3090&cm_re=3090-_-14-932-327-_-Product", "1579.99",newegg));
        cards.add(new Card("3090","GIGABYTE", "GIGABYTE GeForce RTX 3090 DirectX 12 GV-N3090EAGLE OC-24GD 24GB 384-Bit GDDR6X PCI Express 4.0 x16 SLI Support ATX Video Card", "N82E16814932328", "https://www.newegg.com/gigabyte-geforce-rtx-3090-gv-n3090eagle-oc-24gd/p/N82E16814932328?Description=3090&cm_re=3090-_-14-932-328-_-Product", "1499.99",newegg));

        //3090 bestbuy
        //test card >>> cards.add(new Card("2060", "EVGA", "EVGA - KO ULTRA GAMING NVIDIA GeForce RTX 2060 6GB GDDR6 PCI Express 3.0 Graphics Card - Black/Gray", "4758301", "https://api.bestbuy.com/click/-/6403801/pdp", "329.99", bestbuy));
        cards.add(new Card("3090", "ASUS", "ASUS - GeForce RTX 3090 24GB GDDR6X PCI Express 4.0 Strix Graphics Card - Black", "6432447", "https://api.bestbuy.com/click/-/6432447/pdp", "1799.99", bestbuy));
        cards.add(new Card("3090", "EVGA", "EVGA - GeForce RTX 3090 24GB GDDR6X PCI Express 4.0 Graphics Card", "6434363", "https://api.bestbuy.com/click/-/6434363/pdp", "1549.99", bestbuy));
        cards.add(new Card("3090", "EVGA", "EVGA - GeForce RTX 3090 24GB GDDR6X PCI Express 4.0 Graphics Card", "6436192", "https://api.bestbuy.com/click/-/6436192/pdp", "1799.99", bestbuy));
        cards.add(new Card("3090", "EVGA", "EVGA - GeForce RTX 3090 24GB GDDR6X PCI Express 4.0 Graphics Card", "6436193", "https://api.bestbuy.com/click/-/6436193/pdp", "1729.99",bestbuy));
        cards.add(new Card("3090", "GIGABYTE", "GIGABYTE - GeForce RTX 3090 24G GDDR6X PCI Express 4.0 Graphics Card Black", "6430623", "https://api.bestbuy.com/click/-/6430623/pdp", "1579.99",bestbuy));
        cards.add(new Card("3090", "GIGABYTE", "GIGABYTE - GeForce RTX 3090 24G GDDR6X PCI Express 4.0 Graphics Card Black", "6430624", "https://api.bestbuy.com/click/-/6430624/pdp", "1549.99",bestbuy));
        cards.add(new Card("3090", "MSI", "MSI - Geforce RTX 3090 VENTUS 3X 24G OC BV - 24GB GDDR6X - PCI Express 4.0 - Graphics Card - Black/Silver", "6430215", "https://api.bestbuy.com/click/-/6430215/pdp", "1569.99",bestbuy));
        cards.add(new Card("3090", "NVIDIA", "NVIDIA GeForce RTX 3090 24GB GDDR6X  PCI Express 4.0 Graphics Card - Titanium and Black", "6429434", "https://api.bestbuy.com/click/-/6429434/pdp", "1499.99",bestbuy));
        cards.add(new Card("3090", "PNY", "PNY GeForce RTX 3090 24GB XLR8 Gaming EPIC-X RGB Triple Fan Graphics Card", "6432656", "https://api.bestbuy.com/click/-/6432656/pdp", "1599.99",bestbuy));
        cards.add(new Card("3090", "PNY", "PNY GeForce RTX 3090 24GB XLR8 Gaming EPIC-X RGB Triple Fan Graphics Card", "6432657", "https://api.bestbuy.com/click/-/6432657/pdp", "1599.99",bestbuy));
        //3080 newegg
        cards.add(new Card("3080", "EVGA", "EVGA GeForce RTX 3080 FTW3 ULTRA GAMING Video Card, 10G-P5-3897-KR, 10GB GDDR6X, iCX3 Technology, ARGB LED, Metal Backplate", "N82E16814487518", "https://www.newegg.com/evga-geforce-rtx-3080-10g-p5-3897-kr/p/N82E16814487518?Description=3080&cm_re=3080-_-14-487-518-_-Product", "809.99", newegg));
        cards.add(new Card("3080", "EVGA", "EVGA GeForce RTX 3080 FTW3 GAMING Video Card, 10G-P5-3895-KR, 10GB GDDR6X, iCX3 Technology, ARGB LED, Metal Backplate", "N82E16814487519", "https://www.newegg.com/evga-geforce-rtx-3080-10g-p5-3895-kr/p/N82E16814487519?Description=3080&cm_re=3080-_-14-487-519-_-Product", "789.99", newegg));
        cards.add(new Card("3080", "EVGA", "EVGA GeForce RTX 3080 XC3 GAMING Video Card, 10G-P5-3883-KR, 10GB GDDR6X, iCX3 Cooling, ARGB LED, Metal Backplate", "N82E16814487521", "https://www.newegg.com/evga-geforce-rtx-3080-10g-p5-3883-kr/p/N82E16814487521?Description=3080&cm_re=3080-_-14-487-521-_-Product", "749.99", newegg));
        cards.add(new Card("3080", "EVGA", "EVGA GeForce RTX 3080 XC3 BLACK GAMING Video Card, 10G-P5-3881-KR, 10GB GDDR6X, iCX3 Cooling, ARGB LED", "N82E16814487522", "https://www.newegg.com/evga-geforce-rtx-3080-10g-p5-3881-kr/p/N82E16814487522?Description=3080&cm_re=3080-_-14-487-522-_-Product", "729.99", newegg));
        cards.add(new Card("3080", "GIGABYTE", "GIGABYTE AORUS GeForce RTX 3080 DirectX 12 GV-N3080AORUS M-10GD 10GB 320-Bit GDDR6X PCI Express 4.0 x16 ATX Video Card", "N82E16814932336", "https://www.newegg.com/gigabyte-geforce-rtx-3080-gv-n3080aorus-m-10gd/p/N82E16814932336?Description=3080&cm_re=3080-_-14-932-336-_-Product", "849.99", newegg));
        cards.add(new Card("3080", "GIGABYTE", "GIGABYTE GeForce RTX 3080 DirectX 12 GV-N3080VISION OC-10GD 10GB 320-Bit GDDR6X PCI Express 4.0 x16 ATX Video Card", "N82E16814932337", "https://www.newegg.com/gigabyte-geforce-rtx-3080-gv-n3080vision-oc-10gd/p/N82E16814932337?Description=3080&cm_re=3080-_-14-932-337-_-Product", "769.99", newegg));
        cards.add(new Card("3080", "GIGABYTE", "GIGABYTE GeForce RTX 3080 DirectX 12 GV-N3080EAGLE OC-10GD 10GB 320-Bit GDDR6X PCI Express 4.0 x16 ATX Video Card", "N82E16814932330", "https://www.newegg.com/gigabyte-geforce-rtx-3080-gv-n3080eagle-oc-10gd/p/N82E16814932330?Description=3080&cm_re=3080-_-14-932-330-_-Product", "699.99", newegg));
        cards.add(new Card("3080", "ASUS", "ASUS ROG Strix GeForce RTX 3080 DirectX 12 ROG-STRIX-RTX3080-O10G-GAMING 10GB 320-Bit GDDR6X PCI Express 4.0 x16 HDCP Ready Video Card", "N82E16814126457", "https://www.newegg.com/asus-geforce-rtx-3080-rog-strix-rtx3080-o10g-gaming/p/N82E16814126457?Description=3080&cm_re=3080-_-14-126-457-_-Product", "849.99", newegg));
        cards.add(new Card("3080", "ASUS", "ASUS TUF Gaming GeForce RTX 3080 TUF-RTX3080-O10G-GAMING Video Card", "N82E16814126452", "https://www.newegg.com/asus-geforce-rtx-3080-tuf-rtx3080-o10g-gaming/p/N82E16814126452?Description=3080&cm_re=3080-_-14-126-452-_-Product", "749.99", newegg));
        cards.add(new Card("3080", "ASUS", "ASUS TUF Gaming NVIDIA GeForce RTX 3080 TUF-RTX3080-10G-GAMING Video Card", "N82E16814126453", "https://www.newegg.com/asus-geforce-rtx-3080-tuf-rtx3080-10g-gaming/p/N82E16814126453?Description=3080&cm_re=3080-_-14-126-453-_-Product", "699.99", newegg));
        cards.add(new Card("3080", "MSI", "MSI GeForce RTX 3080 DirectX 12 RTX 3080 GAMING X TRIO 10G 10GB 320-Bit GDDR6X PCI Express 4.0 HDCP Ready Video Card", "N82E16814137597", "https://www.newegg.com/msi-geforce-rtx-3080-rtx-3080-gaming-x-trio-10g/p/N82E16814137597?Description=3080&cm_re=3080-_-14-137-597-_-Product", "759.99", newegg));

        //bestbuy 3080
        cards.add(new Card("3080", "ASUS", "ASUS - GeForce RTX 3080 10GB GDDR6X PCI Express 4.0 Strix Graphics Card - Black", "6432445", "https://api.bestbuy.com/click/-/6432445/pdp", "849.99", bestbuy));
        cards.add(new Card("3080", "EVGA", "EVGA - GeForce RTX 3080 10GB GDDR6X PCI Express 4.0 Graphics Card", "6432399", "https://api.bestbuy.com/click/-/6432399/pdp", "729.99", bestbuy));
        cards.add(new Card("3080", "EVGA", "EVGA - GeForce RTX 3080 10GB GDDR6X PCI Express 4.0 Graphics Card", "6432400", "https://api.bestbuy.com/click/-/6432399/pdp", "769.99", bestbuy));
        cards.add(new Card("3080", "EVGA", "EVGA - GeForce RTX 3080 10GB GDDR6X PCI Express 4.0 Graphics Card", "6436191", "https://api.bestbuy.com/click/-/6436191/pdp", "789.99", bestbuy));
        cards.add(new Card("3080", "EVGA", "EVGA - GeForce RTX 3080 10GB GDDR6X PCI Express 4.0 Graphics Card", "6436194", "https://api.bestbuy.com/click/-/6436194/pdp", "749.99", bestbuy));
        cards.add(new Card("3080", "EVGA", "EVGA - GeForce RTX 3080 10GB GDDR6X PCI Express 4.0 Graphics Card", "6436195", "https://api.bestbuy.com/click/-/6436195/pdp", "769.99", bestbuy));
        cards.add(new Card("3080", "EVGA", "EVGA - GeForce RTX 3080 10GB GDDR6X PCI Express 4.0 Graphics Card", "6436196", "https://api.bestbuy.com/click/-/6436196/pdp", "809.99", bestbuy));
        cards.add(new Card("3080", "GIGABYTE", "GIGABYTE - GeForce RTX 3080 10G GDDR6X PCI Express 4.0 Graphics Card Black", "6430620", "https://api.bestbuy.com/click/-/6430620/pdp", "749.99", bestbuy));
        cards.add(new Card("3080", "GIGABYTE", "GIGABYTE - GeForce RTX 3080 10G GDDR6X PCI Express 4.0 Graphics Card Black", "6430621", "https://api.bestbuy.com/click/-/6430621/pdp", "729.99", bestbuy));
        cards.add(new Card("3080", "GIGABYTE", "GIGABYTE - GeForce RTX 3080 10G GDDR6X PCI Express 4.0 Graphics Card Black", "6436223", "https://api.bestbuy.com/click/-/6436223/pdp", "849.99", bestbuy));
        cards.add(new Card("3080", "GIGABYTE", "GIGABYTE - GeForce RTX 3080 10G GDDR6X PCI Express 4.0 Graphics Card White", "6436219", "https://api.bestbuy.com/click/-/6436219/pdp", "729.99", bestbuy));
        cards.add(new Card("3080", "MSI", "MSI - Geforce RTX 3080 VENTUS 3X 10G OC BV - GDDR6X - PCI Express 4.0 - Graphic Card - Black/Silver", "6430175", "https://api.bestbuy.com/click/-/6430175/pdp", "749.99", bestbuy));
        cards.add(new Card("3080", "NVIDIA", "NVIDIA GeForce RTX 3080 10GB GDDR6X PCI Express 4.0  Graphics Card - Titanium and Black", "6429440", "https://api.bestbuy.com/click/-/6429440/pdp", "699.99", bestbuy));
        cards.add(new Card("3080", "PNY", "PNY GeForce RTX 3080 10GB XLR8 Gaming EPIC-X RGB Triple Fan Graphics Card", "6432655", "https://api.bestbuy.com/click/-/6432655/pdp", "749.99", bestbuy));
        cards.add(new Card("3080", "PNY", "PNY GeForce RTX 3080 10GB XLR8 Gaming EPIC-X RGB Triple Fan Graphics Card", "6432658", "https://api.bestbuy.com/click/-/6432658/pdp", "749.99", bestbuy));








        //Look for in stock cards
        boolean inStock = false;
            do {
                for (int i = 0; i < cards.size(); i++) {
                    driver.get(cards.get(i).getUrl());
                    if (cards.get(i).getWebsite() == newegg)
                        if (driver.findElements(By.xpath("//button[@class=\"btn btn-primary btn-wide\"]")).size() > 0) {
                            Message message = Message.creator(new PhoneNumber(PHONE_NUMBER), new PhoneNumber(TWILIO_NUMBER), cards.get(i).getUrl()).create();
                            System.out.println(cards.get(i).getUrl());
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": :" + ANSI_CYAN + "Adding :" + ANSI_RESET + cards.get(i).getModel() + ANSI_GREEN + " to cart" + ANSI_RESET);
                            inStock = true;

                        }
                        else {
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": : " + ANSI_CYAN + cards.get(i).getModel() + ANSI_RESET + ANSI_GREEN + " : : " + ANSI_RED + "OUT OF STOCK at NEWEGG");
                        }
                    else if (cards.get(i).getWebsite() == bestbuy){
                        if (driver.findElements(By.xpath("//button[@class=\"btn btn-primary btn-lg btn-block btn-leading-ficon add-to-cart-button\"]")).size() > 0) {
                            Message message = Message.creator(new PhoneNumber(PHONE_NUMBER), new PhoneNumber(TWILIO_NUMBER), cards.get(i).getAddToCartURL()).create();
                            driver.get(cards.get(i).getAddToCartURL());
                            System.out.println(cards.get(i).getAddToCartURL());
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": :" + ANSI_CYAN + "Adding :" + ANSI_RESET + cards.get(i).getModel() + ANSI_GREEN + " to cart" + ANSI_RESET);
                            inStock = true;
                        }
                        else {
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": : " + ANSI_CYAN + cards.get(i).getModel() + ANSI_RESET + ANSI_GREEN + " : : " + ANSI_RED + "OUT OF STOCK at BEST BUY");
                        }

                    }
                }

            } while (!inStock);
    }

}
