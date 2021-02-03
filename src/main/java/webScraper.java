import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class webScraper {
    public static void main(String []args) throws IOException, InterruptedException {
        scraper();
    }

    public static void scraper() throws IOException, InterruptedException {
        System.out.println("What do you want to search for on Kijiji? (use dashs)");
        Scanner in2 = new Scanner(System.in);
        String choice = in2.next();
        String url = "https://www.kijiji.ca/b-gta-greater-toronto-area/" + choice + "/k0l1700272?rb=true&dc=true";
        Document doc = Jsoup.connect(url).get();
        Elements product = doc.getElementsByClass("title ");
//

        ArrayList<String> productList = new ArrayList<String>();

        for (Element i:product) {
            productList.add(i.text());
        }
        System.out.println("There are " + product.size() + " " + choice + "s available for purchase right now!");
        Thread.sleep(1000);
        System.out.println("Do you want a list of all the products? (y/n)");
        Scanner in = new Scanner(System.in);
        String choiceyn = in.next();
        if (choiceyn.equalsIgnoreCase("y")){
            printcompanies(product);
        }else{
            System.out.println("Thanks for your time!");

        }
    }

    public static void printcompanies(ArrayList product) throws InterruptedException {
        for(int i = 0; i< product.size();i++){
            System.out.println(product.get(i) + " \n Link: ");
            Thread.sleep(200);
        }
    }
}