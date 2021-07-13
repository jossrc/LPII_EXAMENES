package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.BookPublicationDTO;
import interfaces.BookPublicationDAO;
import useful.MySQLConnection8;

public class MySQLBookPublicationDAO implements BookPublicationDAO {

    @Override
    public ArrayList<BookPublicationDTO> listByAuthor(int authorCode) {
        ArrayList<BookPublicationDTO> list = new ArrayList<BookPublicationDTO>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection8.getConnection();
            String sql = "{ call usp_libro_por_autor(?) }";
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, authorCode);
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String bookCode = resultSet.getString(1);
                String authorName = resultSet.getString(2);
                String publicationDate = resultSet.getString(3);
                String bookTitle = resultSet.getString(4);
                String genreBook = resultSet.getString(5);

                BookPublicationDTO bp = new BookPublicationDTO(bookCode, authorName, publicationDate, bookTitle,
                        genreBook);
                list.add(bp);
            }

        } catch (Exception e) {
            System.out.println("Error en el Listado Publicacion de Libros " + e.getMessage());
        } finally {
            MySQLConnection8.closeConnection(connection);
        }

        return list;
    }

}
