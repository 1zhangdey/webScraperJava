import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class webScraper {
    public static String bank;

    public static void main(String []args) throws IOException, InterruptedException {
        scraper();
    }

    public static void scraper() throws IOException, InterruptedException {
        System.out.println("What do you want to search for on Kijiji? (use dashs)");
        //use dashs to ensure the search works, spaces dont work
        Scanner in2 = new Scanner(System.in);
        String choice = in2.next();
        String url = "https://www.kijiji.ca/b-gta-greater-toronto-area/" + choice + "/k0l1700272?rb=true&dc=true";
        //url of kijiji, assumes your in the GTA

        Document doc = Jsoup.connect(url).get();
        Elements product = doc.getElementsByClass("title ");


        ArrayList<String> productList = new ArrayList<String>();

        for (Element i:product) {
            Document doc1 = Jsoup.parse((i.text()));
            Elements link = doc1.select("a");
            productList.add(link.text());
        }
        System.out.println("There are " + product.size() + " " + choice + "s available for purchase right now!");
        Thread.sleep(1000);
        System.out.println("Do you want a list of all the products? (y/n)");
        //only use y or n
        Scanner in = new Scanner(System.in);
        String choiceyn = in.next();
        if (choiceyn.equalsIgnoreCase("y")){
            printcompanies(product);
        }else{
            System.out.println("Thanks for your time!");

        }
    }

    public static void printcompanies(ArrayList product) throws InterruptedException {
         for (int i = 0; i <= 100; i++) {
             //loading animation
             char[] animationChars = new char[]{'|', '/', '-', '\\'};
            System.out.print("Scraping: " + i + "% " + animationChars[i % 4] + "\r");

            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i< product.size();i++){
            System.out.println("Product: " + product.get(i));
            Thread.sleep(50);
        }
    }
}