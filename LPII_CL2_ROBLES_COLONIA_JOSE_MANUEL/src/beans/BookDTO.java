package beans;

public class BookDTO {
    private String code;
    private String title;
    private int pages;
    private String publicationDate;
    private int authorCode;
    private int genreCode;

    public BookDTO(String code, String title, int pages, String publicationDate, int authorCode, int genreCode) {
        this.code = code;
        this.title = title;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.authorCode = authorCode;
        this.genreCode = genreCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(int authorCode) {
        this.authorCode = authorCode;
    }

    public int getGenreCode() {
        return genreCode;
    }

    public void setGenreCode(int genreCode) {
        this.genreCode = genreCode;
    }

}
