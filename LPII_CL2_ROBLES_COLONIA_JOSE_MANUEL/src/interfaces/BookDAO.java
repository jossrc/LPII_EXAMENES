package interfaces;

import java.util.ArrayList;

import beans.BookDTO;
import beans.GenreDTO;

public interface BookDAO {

    public int delete(String bookCode);

    public ArrayList<GenreDTO> genreList();
    
    public BookDTO searchByCode(String bookCode);
}
