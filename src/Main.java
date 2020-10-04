//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    Profile profile = new Profile();
    Billing billing = new Billing();
    Scanner scan = new Scanner(System.in);


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
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

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

        //cards.add(new Card("2060", "GIGABYTE", "GIGABYTE GeForce RTX 2060 DirectX 12 GV-N2060GAMINGOC PRO-6GD Ver 2.0 6GB 192-Bit GDDR6 PCI Express 3.0 x16 ATX Video Card", "N82E16814932225","https://www.newegg.com/gigabyte-geforce-rtx-2060-gv-n2060gamingoc-pro-6gd-ver-2-0/p/N82E16814932225?Description=2060&cm_re=2060-_-14-932-225-_-Product", "359.99"));
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

        //bestbuy
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

        //Look for in stock cards
        boolean inStock = false;
            do {
                for (int i = 0; i < cards.size(); i++) {
                    driver.get(cards.get(i).getUrl());
                    if (cards.get(i).getWebsite() == newegg)
                        if (driver.findElements(By.xpath("//button[@class=\"btn btn-primary btn-wide\"]")).size() > 0) {
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": :" + ANSI_CYAN + "Adding :" + ANSI_RESET + cards.get(i).getModel() + ANSI_GREEN + " to cart" + ANSI_RESET);
                            Thread.sleep((long) (Math.random() * 2003));
                            driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-wide\"]")).click();
                            Thread.sleep((long) (Math.random() * 2003));
                            //driver.get("https://secure.newegg.com/Shopping/ShoppingCart.aspx"); going straight to cart doesn't work
                            driver.get("https://www.newegg.com/d/Shopping/ShoppingItem?ItemList=" + cards.get(i).getSku());
                            Thread.sleep((long) (Math.random() * 2003));
                            inStock = true;
                            if (driver.findElements(By.className("btn btn-primary")).size() > 0) {
                                driver.findElement(By.className("btn btn-primary")).click();
                                Thread.sleep((long) (Math.random() * 2003));
                                if (driver.findElements(By.className("button button-primary has-icon-right")).size() > 0) {
                                    driver.findElement(By.className("button button-primary has-icon-right")).click();
                                }
                            }
                        } else {
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": : " + ANSI_CYAN + cards.get(i).getModel() + ANSI_RESET + ANSI_GREEN + " : : " + ANSI_RED + "OUT OF STOCK at NEWEGG");
                        }
                    else if (cards.get(i).getWebsite() == bestbuy){
                        //System.out.println(cards.get(i).getAddToCartURL());
                        if (driver.findElements(By.xpath("//button[@class=\"btn btn-primary btn-lg btn-block btn-leading-ficon add-to-cart-button\"]")).size() > 0) {
                            driver.get(cards.get(i).getAddToCartURL());
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": :" + ANSI_CYAN + "Adding :" + ANSI_RESET + cards.get(i).getModel() + ANSI_GREEN + " to cart" + ANSI_RESET);
                            inStock = true;
                        }
                        else {
                            System.out.println(ANSI_YELLOW + "Info " + ANSI_RESET + ": : " + ANSI_CYAN + cards.get(i).getModel() + ANSI_RESET + ANSI_GREEN + " : : " + ANSI_RED + "OUT OF STOCK at BEST BUY");
                            Thread.sleep((long) (Math.random() * 2353));
                        }

                    }
                }

            } while (!inStock);
    }


    // work on later
    public void autoCheckoutSetup(){
        System.out.println("Enter First Name: ");
        profile.setFirstName(scan.next());
        System.out.println("Enter Last Name: ");
        profile.setLastName(scan.next());
        System.out.println("Enter email address to be used for transaction: ");
        profile.setEmailAddress(scan.next());
        System.out.println("Enter billing/shipping address: ");
        billing.setStreetAddress(scan.next());
        System.out.println("Enter billing/shipping city: ");
        billing.setCity(scan.next());
        System.out.println("Enter billing state: ");
        billing.setState(scan.next());
        System.out.println("Enter Credit Card #: ");
        billing.setCreditCardNumber(scan.next());
        System.out.println("Enter expiration month (i.e. 04): ");
        billing.setExpMon(scan.next());
        System.out.println("Enter expiration year (i.e. 2025): ");
        billing.setExpYear(scan.next());
        System.out.println("Enter ccv: ");
        billing.setCcv(scan.next());
    }
}
