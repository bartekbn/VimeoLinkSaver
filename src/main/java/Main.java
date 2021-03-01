import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<String> subWebList = new ArrayList<String>();


        try {
            // fetch the document over HTTP
            Document doc = Jsoup.connect("https://vimeo.com/user42053854/videos").get();

            // get the page title
            String title = doc.title();
            System.out.println("title: " + title);


            Element pagination = doc.select("div.pagination").first();
            System.out.println(pagination);

            Elements liczba = pagination.select("li");

            System.out.println(liczba.text());

            String newLiczba[] = liczba.text().split(" Next");
            System.out.println(newLiczba[0]);

            String lasLiczba = (String) newLiczba[0];


            List<String> mojaLiczba = new ArrayList<String>();



            String ostatniaStrona[] = lasLiczba.split(" ");
            System.out.println("--------");



            System.out.println(ostatniaStrona[0]);
            System.out.println(ostatniaStrona[7]);
            String szukanaStrona = (ostatniaStrona[ostatniaStrona.length-1]);
            int cyfra = Integer.parseInt(szukanaStrona);
            System.out.println(cyfra);



//            // get all links in page
//            Elements links = doc.select("a[href]");
//            for (Element link : links) {
//                // get the value from the href attribute
//                System.out.println("\nlink: " + link.attr("href"));
//                System.out.println("text: " + link.text());
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
