package interfaces;

import java.util.ArrayList;

import beans.BookPublicationDTO;

public interface BookPublicationDAO {

    public ArrayList<BookPublicationDTO> listByAuthor(int authorCode);

}
