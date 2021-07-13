package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ClienteDTO;
import interfaces.ClienteDAO;
import utils.MySQLConnection8;

public class MySQLClienteDAO implements ClienteDAO {

    @Override
    public ArrayList<ClienteDTO> listado() {

        ArrayList<ClienteDTO> lista = new ArrayList<ClienteDTO>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection8.getConnection();
            String sql = "SELECT * FROM CLIENTES";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);

                ClienteDTO cliente = new ClienteDTO(codigo, nombre, apellido);
                lista.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Error en listado clientes " + e.getMessage());
        } finally {
            MySQLConnection8.closeConnection(connection);
        }

        return lista;

    }

}
