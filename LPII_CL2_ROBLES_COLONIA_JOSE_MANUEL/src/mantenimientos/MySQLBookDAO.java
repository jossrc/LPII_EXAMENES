package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.BookDTO;
import beans.GenreDTO;
import interfaces.BookDAO;
import useful.MySQLConnection8;

public class MySQLBookDAO implements BookDAO {

    @Override
    public int delete(String bookCode) {
        int rs = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySQLConnection8.getConnection();
            String sql = "delete from libros where codigo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookCode);

            rs = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al eliminar libro " + e.getMessage());
        } finally {
            MySQLConnection8.closeConnection(connection);
        }

        return rs;
    }

    @Override
    public ArrayList<GenreDTO> genreList() {
        ArrayList<GenreDTO> list = new ArrayList<GenreDTO>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection8.getConnection();
            String sql = "select * from generos";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);

                GenreDTO genre = new GenreDTO(id, name, description);
                list.add(genre);
            }

        } catch (Exception e) {
            System.out.println("Error en listado genero " + e.getMessage());
        } finally {
            MySQLConnection8.closeConnection(connection);
        }

        return list;
    }

    @Override
    public BookDTO searchByCode(String bookCode) {
        BookDTO book = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection8.getConnection();
            String sql = "select * from libros where codigo = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, bookCode);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String code = resultSet.getString(1);
                String title = resultSet.getString(2);
                int pages = resultSet.getInt(3);
                String publicationDate = resultSet.getString(4);
                int authorCode = resultSet.getInt(5);
                int genreCode = resultSet.getInt(6);

                book = new BookDTO(code, title, pages, publicationDate, authorCode, genreCode);

            }

        } catch (Exception e) {
            System.out.println("Error al buscar libro " + e.getMessage());
        } finally {
            MySQLConnection8.closeConnection(connection);
        }

        return book;
    }

}
