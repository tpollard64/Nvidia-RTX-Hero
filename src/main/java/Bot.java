import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;


public class Bot {

    public static final String ACCOUNT_SID = "######################"; // Your Twilio SID goes here
    public static final String AUTH_TOKEN = "###################"; // Your Twilio Auto Token goes here
    public static final String PHONE_NUMBER = "+11234567899"; // Your phone number goes here use +1 in front for US numbers
    public static final String TWILIO_NUMBER = "+12135686029"; // Your twilio number goes here. get from twilio dashboard
    //public static final String TWILIO_NUMBER_2 = "+12135686029"; // Optional second twilio number. I have this set to a different contact on my phone so I know if its go time or not.

    //colors for console output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static ArrayList<Card> cards = new ArrayList<Card>();
    public static Website newegg = new Website();
    public static Website bestbuy = new Website();
    //public static Website nvidia = new Website(); //DEAD
    public static Website amazon = new Website();


    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false); //Set headless to true if you don't want a browser window to popup. WARNING: Bestbuy does not work headless.
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // wait up to 5 seconds for add to cart button to display
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





        displayMenu();
        int selection = scanner.nextInt();
        displayStores();
        int storeSelection = scanner.nextInt();

        switch(storeSelection){
            case 1:
                if (selection == 1){
                    newegg3080();
                }
                else if (selection == 2){
                    newegg3090();
                }
                else if (selection == 3){
                    newegg3080();
                    newegg3090();
                }
            case 2:
                if (selection == 1){
                    bestbuy3080();
                }
                else if (selection == 2){
                    bestbuy3090();
                }
                else if (selection == 3){
                    bestbuy3080();
                    bestbuy3090();
                }
            case 3:
                if (selection == 1){
                    amazon3080();
                }
                else if (selection == 2){
                    amazon3090();
                }
                else if (selection == 3){
                    amazon3080();
                    amazon3090();
                }
            case 4:
                if (selection == 1){
                    newegg3080();
                    bestbuy3080();
                    amazon3080();
                }
                else if (selection == 2){
                    newegg3090();
                    bestbuy3090();
                    amazon3090();
                }
                else if (selection == 3){
                    newegg3080();
                    bestbuy3080();
                    amazon3080();
                    newegg3090();
                    bestbuy3090();
                    amazon3090();
                }
            case 5:
                if (selection == 1){
                    testCards();
                }
                else if (selection == 2){
                    testCards();
                }
                else if (selection == 3){
                    testCards();
                }
            default:
                System.out.println("Select 1-5");
        }






        try {
            driver.get(cards.get(0).getUrl());
            //Look for in stock cards
            boolean inStock = false; //inStock will always be false in order to keep bot running even if in stock card is found
            int counter = 0; // counter to send text message updates so you know the bot is still running

            do {
                for (Card card : cards) {
                    driver.get(card.getUrl());
                    Thread.sleep((long)(Math.random() * 876));
                    counter++;

                    if (card.getWebsite().equals(newegg))
                        if (driver.findElements(By.xpath("//button[@class=\"btn btn-primary btn-wide\"]")).size() > 0) {
                            Message message = Message.creator(new PhoneNumber(PHONE_NUMBER), new PhoneNumber(TWILIO_NUMBER), card.getUrl()).create();
                            System.out.println(card.getUrl());
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET +  ": :" + ANSI_CYAN + "Adding :" + ANSI_RESET + card.getModel() + ANSI_GREEN + " to cart" + ANSI_RESET);
                            //inStock = true; // uncomment if you want the bot to stop after finding one card in stock > I recommend you leave this commented to prevent having to restart in case the card sells out fast

                        } else {
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": : " + ANSI_CYAN + card.getModel() + ANSI_RESET + ANSI_GREEN + " : : " + ANSI_RED + "OUT OF STOCK at NEWEGG");
                        }
                    else if (card.getWebsite().equals(bestbuy)) {
                        if (driver.findElements(By.xpath("//button[@class=\"btn btn-primary btn-lg btn-block btn-leading-ficon add-to-cart-button\"]")).size() > 0) {
                            Message message = Message.creator(new PhoneNumber(PHONE_NUMBER), new PhoneNumber(TWILIO_NUMBER), card.getAddToCartURL()).create();
                            driver.get(card.getAddToCartURL());
                            System.out.println(card.getAddToCartURL());
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": :" + ANSI_CYAN + "Adding :" + ANSI_RESET + card.getModel() + ANSI_GREEN + " to cart" + ANSI_RESET);
                            //inStock = true; // uncomment if you want the bot to stop after finding one card in stock > I recommend you leave this commented to prevent having to restart in case the card sells out fast
                        } else {
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": : " + ANSI_CYAN + card.getModel() + ANSI_RESET + ANSI_GREEN + " : : " + ANSI_RED + "OUT OF STOCK at BEST BUY");
                        }

                    } else if (card.getWebsite().equals(amazon)) {
                        //Thread.sleep((long) (Math.random() * 2323));
                        if (driver.findElements(By.name("submit.add-to-cart")).size() > 0) {
                            Message message = Message.creator(new PhoneNumber(PHONE_NUMBER), new PhoneNumber(TWILIO_NUMBER), card.getUrl()).create();
                            System.out.println(card.getUrl());
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": :" + ANSI_CYAN + "Adding :" + ANSI_RESET + card.getModel() + ANSI_GREEN + " to cart" + ANSI_RESET);
                            //inStock = true; // uncomment if you want the bot to stop after finding one card in stock > I recommend you leave this commented to prevent having to restart in case the card sells out fast
                        }
                        else {
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": : " + ANSI_CYAN + card.getModel() + ANSI_RESET + ANSI_GREEN + " : : " + ANSI_RED + "OUT OF STOCK at AMAZON");
                        }
                    }
                    if (counter == 750) {
                        Message message = Message.creator(new PhoneNumber(PHONE_NUMBER), new PhoneNumber(TWILIO_NUMBER), "No cards found. Continuing to look.").create(); // use TWILIO_NUMBER_2 if you decide to get second twilio number for text updates
                        counter = 0;
                        System.out.println("STILL NO GPUS");
                    }

                }

            } while (!inStock);

        }
        catch (Exception exception){
            System.out.println("Error occured - Waiting 15 secs...");
            Thread.sleep(15000);
        }
    }

    public static void displayMenu(){
        System.out.println("Welcome to NVIDIA RTX HERO");
        System.out.println("This tool will look for instock RTX 30 series graphics cards");
        System.out.println("and text you a link to purchase the card. Use this tool on your");
        System.out.println("computer using a VPN, and checkout on your cellphone by following");
        System.out.println("the link provided. This will prevent you from being flagged as a bot.");
        System.out.println();
        System.out.println();
        System.out.println("Selections:");
        System.out.println("1. 3080");
        System.out.println("2. 3090");
        System.out.println("3. 3080 & 3090");
    }

    public static void displayStores(){
        System.out.println("This tool searches both Newegg and Bestbuy for in stock cards");
        System.out.println("Selections:");
        System.out.println("Selections:");
        System.out.println("1. Newegg");
        System.out.println("2. BestBuy");
        System.out.println("3. Amazon");
        System.out.println("4. All Stores");
        System.out.println("5. Test Alerts");

    }

    public static void newegg3080(){
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
        cards.add(new Card("3080", "PNY","PNY GeForce RTX 3080 10GB XLR8 Gaming EPIC-X RGB Triple Fan Graphics Card, VCG308010TFXPPB", "N82E16814133809", "https://www.newegg.com/pny-geforce-rtx-3080-vcg308010tfxppb/p/N82E16814133809", "749.99", newegg));
        cards.add(new Card("3080", "ZOTAC","ZOTAC GAMING GeForce RTX 3080 Trinity OC 10GB GDDR6X 320-bit 19 Gbps PCIE 4.0 Gaming Graphics Card, IceStorm 2.0 Advanced Cooling, SPECTRA 2.0 RGB Lighting, ZT-A30800J-10P", "N82E16814500504", "https://www.newegg.com/zotac-geforce-rtx-3080-zt-t30800j-10p/p/N82E16814500504", "729.99", newegg));
        cards.add(new Card("3080", "GIGABYTE","GIGABYTE GeForce RTX 3080 DirectX 12 GV-N3080VISION OC-10GD 10GB 320-Bit GDDR6X PCI Express 4.0 x16 ATX Video Card", "N82E16814932337", "https://www.newegg.com/gigabyte-geforce-rtx-3080-gv-n3080vision-oc-10gd/p/N82E16814932337", "769.99", newegg));
        cards.add(new Card("3080", "GIGABYTE","GIGABYTE AORUS GeForce RTX 3080 DirectX 12 GV-N3080AORUS M-10GD 10GB 320-Bit GDDR6X PCI Express 4.0 x16 ATX Video Card", "N82E16814932336", "https://www.newegg.com/gigabyte-geforce-rtx-3080-gv-n3080aorus-m-10gd/p/N82E16814932336", "849.99", newegg));
    }

    public static void newegg3090() {
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
        cards.add(new Card("3090", "PNY","PNY GeForce RTX 3090 24GB XLR8 Gaming EPIC-X RGB Triple Fan Graphics Card, VCG309024TFXPPB", "N82E16814133807", "https://www.newegg.com/pny-geforce-rtx-3090-vcg309024tfxppb/p/N82E16814133807", "1549.99", newegg));
        //newegg bundles
        cards.add(new Card("3090","ASUS", "ASUS AMD AM4 ROG X570 Crosshair VIII Hero (Wi-Fi) ATX Motherboard + ASUS ROG Strix GeForce RTX 3090 DirectX 12 ROG-STRIX-RTX3090-O24G-GAMING 24GB 384-Bit GDDR6X PCI Express 4.0 x16 HDCP Ready SLI Support Video Card", "Combo.4094955", "https://www.newegg.com/Product/ComboDealDetails?ItemList=Combo.4094955", "2159.99",newegg));
    }


    public static void bestbuy3090(){
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
    }

    public static void bestbuy3080(){
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
    }

    public static void amazon3090(){
        cards.add(new Card("3090", "ZOTAC", "ZOTAC Gaming GeForce RTX 3090 Trinity 24GB GDDR6X 384-bit 19.5 Gbps PCIE 4.0 Gaming Graphics Card, IceStorm 2.0 Advanced Cooling, Spectra 2.0 RGB Lighting, ZT-A30900D-10P ", "B08HJQ182D", "https://www.amazon.com/ZOTAC-Graphics-IceStorm-Advanced-ZT-A30900D-10P/dp/B08HJQ182D?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "ASUS", "ASUS TUF Gaming NVIDIA GeForce RTX 3090 Graphics Card (PCIe 4.0, 24GB GDDR6X, HDMI 2.1, DisplayPort 1.4a, Dual Ball Fan Bearings, Military-Grade Certification, GPU Tweak II) ", "B08HJLLF7G", "https://www.amazon.com/ASUS-Graphics-DisplayPort-Military-Grade-Certification/dp/B08HJLLF7G?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "ASUS", "ASUS TUF Gaming NVIDIA GeForce RTX 3090 OC Edition Graphics Card (PCIe 4.0, 24GB GDDR6X, HDMI 2.1, DisplayPort 1.4a, Dual Ball Fan Bearings, Military-Grade Certification, GPU Tweak II) ", "B08HJGNJ81", "https://www.amazon.com/ASUS-Graphics-DisplayPort-Military-Grade-Certification/dp/B08HJGNJ81?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "GIGABYTE", "AGigabyte GeForce RTX 3090 Gaming OC 24G Graphics Card, 3X WINDFORCE Fans, 24GB 384-bit GDDR6X, GV-N3090GAMING OC-24GD Video Card ", "B08HJRF2CN", "https://www.amazon.com/Gigabyte-GeForce-Graphics-WINDFORCE-GV-N3090GAMING/dp/B08HJRF2CN?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "GIGABYTE", "Gigabyte GeForce RTX 3090 Eagle OC 24G Graphics Card, 3X WINDFORCE Fans, 24GB 384-bit GDDR6X, GV-N3090EAGLE OC-24GD Video Card", "B08HJPDJTY", "https://www.amazon.com/Gigabyte-GeForce-Graphics-WINDFORCE-GV-N3090EAGLE/dp/B08HJPDJTY?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "PNY", "PNY GeForce RTX 3090 24GB XLR8 Gaming Revel Epic-X RGB Triple Fan Graphics Card ", "B08HBQWBHH", "https://www.amazon.com/PNY-GeForce-Gaming-Epic-X-Graphics/dp/B08HBQWBHH?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "PNY", "PNY GeForce RTX 3090 24GB XLR8 Gaming Revel Epic-X RGB Triple Fan Graphics Card ", "B08HBVX53D", "https://www.amazon.com/PNY-GeForce-RTX-3090-Graphics/dp/B08HBVX53D?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "MSI", "MSI Gaming GeForce RTX 3090 24GB GDRR6X 384-Bit HDMI/DP Nvlink Tri-Frozr 2 Ampere Architecture OC Graphics Card (RTX 3090 Gaming X Trio 24G) ", "B08HRBW6VB", "https://www.amazon.com/MSI-GeForce-RTX-3090-24G/dp/B08HRBW6VB?ref_=ast_sto_dp", "1539.99", amazon));
    }

    public static void amazon3080(){
        cards.add(new Card("3080", "ZOTAC", "ZOTAC Gaming GeForce RTX 3080 Trinity 10GB GDDR6X 320-bit 19 Gbps PCIE 4.0 Gaming Graphics Card, IceStorm 2.0 Advanced Cooling, Spectra 2.0 RGB Lighting, ZT-A30800D-10P ", "B08HJNKT3P", "https://www.amazon.com/ZOTAC-Graphics-IceStorm-Advanced-ZT-A30800D-10P/dp/B08HJNKT3P?ref_=ast_sto_dp", "749.99", amazon));
        cards.add(new Card("3080", "ASUS", "ASUS TUF Gaming NVIDIA GeForce RTX 3080 OC Edition Graphics Card (PCIe 4.0, 10GB GDDR6X, HDMI 2.1, DisplayPort 1.4a, Dual Ball Fan Bearings, Military-Grade Certification, GPU Tweak II) ", "B08HH5WF97", "https://www.amazon.com/ASUS-Graphics-DisplayPort-Military-Grade-Certification/dp/B08HH5WF97?ref_=ast_sto_dp", "749.99", amazon));
        cards.add(new Card("3080", "ASUS", "ASUS TUF Gaming NVIDIA GeForce RTX 3080 Graphics Card (PCIe 4.0, 10GB GDDR6X, HDMI 2.1, DisplayPort 1.4a, Dual Ball Fan Bearings, Military-Grade Certification, GPU Tweak II) ", "B08HHDP9DW", "https://www.amazon.com/ASUS-Graphics-DisplayPort-Military-Grade-Certification/dp/B08HHDP9DW?ref_=ast_sto_dp", "769.99", amazon));
        cards.add(new Card("3090", "GIGABYTE", "AGigabyte GeForce RTX 3090 Gaming OC 24G Graphics Card, 3X WINDFORCE Fans, 24GB 384-bit GDDR6X, GV-N3090GAMING OC-24GD Video Card ", "B08HJRF2CN", "https://www.amazon.com/Gigabyte-GeForce-Graphics-WINDFORCE-GV-N3090GAMING/dp/B08HJRF2CN?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "GIGABYTE", "Gigabyte GeForce RTX 3090 Eagle OC 24G Graphics Card, 3X WINDFORCE Fans, 24GB 384-bit GDDR6X, GV-N3090EAGLE OC-24GD Video Card", "B08HJPDJTY", "https://www.amazon.com/Gigabyte-GeForce-Graphics-WINDFORCE-GV-N3090EAGLE/dp/B08HJPDJTY?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "PNY", "PNY GeForce RTX 3090 24GB XLR8 Gaming Revel Epic-X RGB Triple Fan Graphics Card ", "B08HBQWBHH", "https://www.amazon.com/PNY-GeForce-Gaming-Epic-X-Graphics/dp/B08HBQWBHH?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "PNY", "PNY GeForce RTX 3090 24GB XLR8 Gaming Revel Epic-X RGB Triple Fan Graphics Card ", "B08HBVX53D", "https://www.amazon.com/PNY-GeForce-RTX-3090-Graphics/dp/B08HBVX53D?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3090", "MSI", "MSI Gaming GeForce RTX 3090 24GB GDRR6X 384-Bit HDMI/DP Nvlink Tri-Frozr 2 Ampere Architecture OC Graphics Card (RTX 3090 Gaming X Trio 24G) ", "B08HRBW6VB", "https://www.amazon.com/MSI-GeForce-RTX-3090-24G/dp/B08HRBW6VB?ref_=ast_sto_dp", "1539.99", amazon));
        cards.add(new Card("3080", "EVGA", "EVGA 10G-P5-3897-KR GeForce RTX 3080 FTW3 ULTRA GAMING, 10GB GDDR6X, iCX3 Technology, ARGB LED, Metal Backplate ", "B08HR3Y5GQ", "https://www.amazon.com/EVGA-10G-P5-3897-KR-GeForce-Technology-Backplate/dp/B08HR3Y5GQ?ref_=ast_sto_dp", "809.9", amazon));
        cards.add(new Card("3080", "EVGA", "EVGA 10G-P5-3895-KR GeForce RTX 3080 FTW3 GAMING, 10GB GDDR6X, iCX3 Technology, ARGB LED, Metal Backplate ", "B08HR3DPGW", "https://www.amazon.com/EVGA-10G-P5-3895-KR-GeForce-Technology-Backplate/dp/B08HR3DPGW?ref_=ast_sto_dp", "789.99", amazon));

    }

    public static void testCards(){
        cards.add(new Card("2060", "GIGABYTE", "GIGABYTE GeForce RTX 2060 DirectX 12 GV-N2060GAMINGOC PRO-6GD Ver 2.0 6GB 192-Bit GDDR6 PCI Express 3.0 x16 ATX Video Card", "N82E16814932225","https://www.newegg.com/gigabyte-geforce-rtx-2060-gv-n2060gamingoc-pro-6gd-ver-2-0/p/N82E16814932225?Description=2060&cm_re=2060-_-14-932-225-_-Product", "359.99", newegg));
        cards.add(new Card("YETI", "YETI", "YETI MICROPHONE", "4758301", "https://api.bestbuy.com/click/-/6403801/pdp", "129.99", bestbuy));
        cards.add(new Card("TITAN", "NVIDIA", "RTX TITAN TESTER", "B08HRBW6VB", "https://www.amazon.com/NVIDIA-Titan-RTX-Graphics-Card/dp/B07L8YGDL5/ref=sr_1_1?dchild=1&keywords=rtx+titan&qid=1602119013&s=electronics&sr=1-1", "1539.99", amazon));
    }

    //NVIDIA FE  >>> NOT WORKING AT THE MOMENT
    //cards.add(new Card("3090", "NVIDIA", "NVIDIA GEFORCE RTX 3090 FE", "NVGFT090", "https://www.nvidia.com/en-us/shop/geforce/gpu/?page=1&limit=9&locale=en-us&category=GPU&gpu=RTX%203090", "1499.99", nvidia));
    //api link
    //cards.add(new Card("3090", "NVIDIA", "NVIDIA GEFORCE RTX 3090 FE - API", "NVGFT090", "https://api.nvidia.partners/edge/product/search?page=1&limit=9&locale=en-us&category=GPU&gpu=RTX%203090&manufacturer=NVIDIA&manufacturer_filter=NVIDIA~1,ASUS~1,EVGA~3,GIGABYTE~2,MSI~1,PNY~0,ZOTAC~0", "1499.99", nvidia));
    //cards.add(new Card())


}



