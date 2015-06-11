package quotationsdatabase;

public class Quote implements Comparable<Quote>{
    private String msg, author;

    public Quote(String _Quote, String _Author){
        msg = _Quote;
        author = _Author;
    }

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
    
    public int compareTo(Quote other) {
        return author.compareTo(other.author);
    }
}
