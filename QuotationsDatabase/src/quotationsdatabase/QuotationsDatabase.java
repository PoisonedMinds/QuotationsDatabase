package quotationsdatabase;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @title QuotationsDatabase
 * @author Steven Biro
 * @teacher Mr. J. Carron
 * @date 8-Jun-2015 2:11:49 PM
 * @purpose The purpose of this program is to
 */
public class QuotationsDatabase {

    static JTextArea textArea = new JTextArea(30, 80);
    static JScrollPane scrollPane;

    public static void main(String[] args) {
        String buttons[] = {"List Quotes", "Search Quotes", "Sort Quotes", "Add a Quote", "Remove a Quote", "Exit"},buttons2[]={"By Author","By Quote"};
        QuotationEngine qEngine = new QuotationEngine();
        String searchTerm, name, quote;
        int option = 0, index = 0,option2=0;
        while (option != 5) {
            option = JOptionPane.showOptionDialog(null, "What would you like to do?", "Quotations Database", JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[0]);
            if (option == 0) {
                textArea.setText(qEngine.toStringWithNumbers());
                scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(null, scrollPane);

            } else if (option == 1) {
                searchTerm = JOptionPane.showInputDialog("What would you like to search for?\nType part of the quote or the Author's name");
                if (searchTerm != null) {
                    qEngine.searchQuotes(searchTerm);
                    textArea.setText(qEngine.toStringSearch());
                    scrollPane = new JScrollPane(textArea);
                    JOptionPane.showMessageDialog(null, scrollPane);
                }
            } else if (option == 2) {
            option2 = JOptionPane.showOptionDialog(null, "How would you like to sort the quotes", "Quotations Database", JOptionPane.PLAIN_MESSAGE, 3, null, buttons2, buttons2[0]);
            if(option2==0) {
                qEngine.alphebeticalSortAuthor();
            } else {
                qEngine.alphebeticalSortQuote();
            }
        } else if (option == 3) {
                quote = JOptionPane.showInputDialog("What is the quote");
                if (quote != null) {
                    name = JOptionPane.showInputDialog("What is the author's name?");
                    if (name != null) {
                        qEngine.addQuote(quote, name);
                    }
                }
            } else if (option == 4) {
                String quotearray[] = new String[qEngine.numOfQuotes()];
                for (int i = 0; i < quotearray.length; i++) {
                    quotearray[i] = qEngine.getQuote(i);
                }
                searchTerm = (String) JOptionPane.showInputDialog(null, "What quote would you like to remove", "QuotationsDatabase", JOptionPane.PLAIN_MESSAGE, null, quotearray, quotearray[0]);
                if (searchTerm!=null){
                index = Arrays.asList(quotearray).lastIndexOf(searchTerm);
                qEngine.removeQuote(index);
            }
            }

        }
        qEngine.write();
    }

}
