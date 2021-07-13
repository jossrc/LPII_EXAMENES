package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.TipoCreditoDTO;
import interfaces.TipoCreditoDAO;
import utils.MySQLConnection8;

public class MySQLTipoCreditoDAO implements TipoCreditoDAO {

    @Override
    public ArrayList<TipoCreditoDTO> listado() {
        ArrayList<TipoCreditoDTO> lista = new ArrayList<TipoCreditoDTO>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection8.getConnection();
            String sql = "SELECT * FROM TIPOS_CREDITO";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt(1);
                String descripcion = resultSet.getString(2);
                String terminos = resultSet.getString(3);

                TipoCreditoDTO tipo = new TipoCreditoDTO(codigo, descripcion, terminos);
                lista.add(tipo);
            }

        } catch (Exception e) {
            System.out.println("Error en listado tipo de creditos " + e.getMessage());
        } finally {
            MySQLConnection8.closeConnection(connection);
        }

        return lista;
    }

}
