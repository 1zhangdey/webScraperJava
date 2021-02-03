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
        Document doc = Jsoup.connect("https://www.glassdoor.ca/Job/toronto-intern-jobs-SRCH_IL.0,7_IC2281069_KO8,14.htm").get();
        Elements links = doc.getElementsByClass(" css-l2wjgv e1n63ojh0 jobLink");

        ArrayList<String> company = new ArrayList<String>();

        for (Element link : links) {
            company.add(link.text());
        }
        System.out.println("There are " + company.size() + " companies hiring Interns right now!");
        Thread.sleep(1000);
        System.out.println("Do you want to know all the companies hiring? (y/n)");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        if (choice.equalsIgnoreCase("y")){
            printcompanies(company);
        }else{
            System.out.println("Thanks for your time!");
        }
    }

    public static void printcompanies(ArrayList company) throws InterruptedException {
        for(int i = 0; i< company.size();i++){
            System.out.println("Company: " + company.get(i));
            Thread.sleep(200);
        }
    }
}