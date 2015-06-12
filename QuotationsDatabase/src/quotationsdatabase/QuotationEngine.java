package quotationsdatabase;

import java.util.*;
import java.io.*;

public class QuotationEngine {

    private ArrayList<Quote> quotes;
    private ArrayList<Integer> search=new ArrayList();
    private int quoteCount, currQuoteNum;

    public QuotationEngine() {
        quoteCount = 0;
        quotes = new ArrayList<Quote>();
        int num = 0;
        String line1 = null, line2 = null;
        ArrayList contents = read("quotes.txt");

        for (Object content : contents) {
            if (num % 2 == 0) {
                line1 = ((String) content);
            } else {

                line2 = ((String) content);
                quotes.add(new Quote(line1, line2));
                quoteCount++;
            }
            num++;
        }
    }

    public void addQuote(String _Quote, String _Author) {
        quotes.add(new Quote(_Quote, _Author));
        quoteCount++;
    }

    public void removeQuote(int n) {
        quotes.remove(n);
        quoteCount--;
    }

    public String getQuote(int i) {
        currQuoteNum = i;
        return quotes.get(i).getQuote();
    }

    public void write() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("quotes.txt"));
                writer.println(toString());
            writer.close();
        } catch (IOException ex) {
            System.out.println("An error has occured.");
            System.exit(0);
        }
    }
    public void searchQuotes(String searchTerm) {
                findAuthor(searchTerm);
               findQuote(searchTerm); 
    }
    
    public void findAuthor(String name) {
        currQuoteNum = -1;
        for (int i = 0; i < quoteCount; i++) {
            if (quotes.get(i).getAuthor().toLowerCase().contains(name.toLowerCase())) {
                search.add(i);
            }
        }
        search.add(-1);
        if (currQuoteNum == -1) {
        }
    }

    public void findQuote(String term) {
        currQuoteNum = -1;
        for (int i = 0; i < quoteCount; i++) {
            if (quotes.get(i).getQuote().toLowerCase().contains(term.toLowerCase())) {

                search.add(i);
            }
        }
        if (currQuoteNum == -1) {
        }
    }
    
    public void alphebeticalSortAuthor() {
 Collections.sort(quotes, Comparator.comparing((quote) -> quote.getAuthor().toLowerCase()));  
 write();
    }
    
    public void alphebeticalSortQuote() {
 Collections.sort(quotes, Comparator.comparing((quote) -> quote.getQuote().toLowerCase()));  
 write();
    }

    public String toStringSearch() {
        String output = "In Author Name:\n";
        for (int i = 0; i < search.size(); i++) {
            if (search.get(i)!=-1){
            output += quotes.get(search.get(i)).getQuote() + "\n" + quotes.get(search.get(i)).getAuthor();
            if (i != (search.size() - 1)) {
                output += "\n";
            }
            } else {
                output+="\nIn Quote:\n";
            }
        }
        return output;
    }
    

    public String toStringWithNumbers() {
        String output = "";
        for (int i = 0; i < quoteCount; i++) {
            output += "---Quote #" + (i + 1) + "---\n" + quotes.get(i).getQuote() + "\n" + quotes.get(i).getAuthor();
            if (i != (quoteCount - 1)) {
                output += "\n";
            }

        }
        return output;
    }
    
    public static ArrayList read(String path) {
        int num = 0;
        ArrayList contents = new ArrayList();
        String line;
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(path));

            while ((line = br.readLine()) != null) {
                contents.add(num, line);
                num++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(0);

        } catch (IOException ex) {
            System.out.println("An error has occured");
            System.exit(1);
        }
        return contents;
    }
    public int numOfQuotes(){
        return (quotes.size());
    }
     public String toString() {
        String output = "";
        for(int i = 0; i < quoteCount; i++){
            output += quotes.get(i).getQuote() + "\n" + quotes.get(i).getAuthor();
            if(i != (quoteCount - 1))
                output += "\n";
        }
        return output;
    }

}
