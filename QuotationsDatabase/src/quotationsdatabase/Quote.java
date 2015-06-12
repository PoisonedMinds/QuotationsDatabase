package quotationsdatabase;
/**
 * @title QuotationsDatabase
 * @author Steven Biro
 * @teacher Mr. J. Carron
 * @date 8-Jun-2015 2:11:49 PM
 * @purpose The purpose of this program is to hold the information for a quote
 */
public class Quote {
    //hold the values for the quote
    private String msg, author;
//set the original values
    public Quote(String _Quote, String _Author){
        msg = _Quote;
        author = _Author;
    }
//get and set the values for the quote
    public String getQuote() {
        return msg;
    }

    public String getAuthor() {
        return author;
    }

    public void setQuote(String _Quote){
        msg = _Quote;
    }

    public void setAuthor(String _Author) {
        author = _Author;
    }
    
}
