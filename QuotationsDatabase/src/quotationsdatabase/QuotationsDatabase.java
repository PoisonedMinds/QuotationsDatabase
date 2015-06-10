package quotationsdatabase;

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
        String buttons[] = {"List Quotes", "Search Quotes", "Sort Quotes", "Add a Quote", "Remove a Quote", "Exit"};
        QuotationEngine qEngine = new QuotationEngine();
        String searchTerm,name,quote;
        int option = 0;
        while (option != 5) {
            option = JOptionPane.showOptionDialog(null, "What would you like to do?", "Quotations Database", JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[0]);
            if (option == 0) {
                textArea.setText(qEngine.toStringWithNumbers());
                scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(null, scrollPane);

            } else if (option == 1) {
                searchTerm = JOptionPane.showInputDialog("What would you like to search for?\nType part of the quote or the Author's name");
                qEngine.searchQuotes(searchTerm);
                textArea.setText(qEngine.toString());
                scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(null, scrollPane);
            } else if (option==2) {
                
            } else if (option==3) {
                quote=JOptionPane.showInputDialog("What is the quote");
                name=JOptionPane.showInputDialog("What is the author's name?");
                qEngine.addQuote(quote, name);
            }

        }
    }

}
