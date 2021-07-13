package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.AuthorDTO;
import interfaces.AuthorDAO;
import useful.MySQLConnection8;

public class MySQLAuthorDAO implements AuthorDAO {

    @Override
    public ArrayList<AuthorDTO> list() {
        ArrayList<AuthorDTO> authorList = new ArrayList<AuthorDTO>();;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection8.getConnection();
            String sql = "select * from autores";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);

                AuthorDTO author = new AuthorDTO(id, name, description);
                authorList.add(author);
            }

        } catch (Exception e) {
            System.out.println("Error en listado autores " + e.getMessage());
        } finally {
            MySQLConnection8.closeConnection(connection);
        }

        return authorList;
    }

}
