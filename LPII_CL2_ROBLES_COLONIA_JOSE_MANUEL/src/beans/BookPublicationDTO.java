package beans;

public class BookPublicationDTO {

    private String bookCode;
    private String authorName;
    private String publicationDate;
    private String bookTitle;
    private String genreBook;

    public BookPublicationDTO(String bookCode, String authorName, String publicationDate, String bookTitle,
            String genreBook) {
        this.bookCode = bookCode;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
        this.bookTitle = bookTitle;
        this.genreBook = genreBook;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getGenreBook() {
        return genreBook;
    }

    public void setGenreBook(String genreBook) {
        this.genreBook = genreBook;
    }
   
}
