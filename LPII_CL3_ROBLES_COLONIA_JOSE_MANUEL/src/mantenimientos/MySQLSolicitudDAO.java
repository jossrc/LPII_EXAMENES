package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.SolicitudDTO;
import interfaces.SolicitudDAO;
import utils.MySQLConnection8;

public class MySQLSolicitudDAO implements SolicitudDAO {
    
    public static String errorMessage = "";

    @Override
    public int registrar(SolicitudDTO solicitud) {
        int rs = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySQLConnection8.getConnection();
            String sql = "INSERT INTO SOLICITUDES VALUES (?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, solicitud.getCodigo());
            preparedStatement.setString(2, solicitud.getFecha());
            preparedStatement.setDouble(3, solicitud.getMonto());
            preparedStatement.setString(4, solicitud.getObservacion());
            preparedStatement.setInt(5, solicitud.getCodigoCliente());
            preparedStatement.setInt(6, solicitud.getCodigoTipoCredito());

            rs = preparedStatement.executeUpdate();

        } catch (Exception e) {
            errorMessage = e.getMessage();
            System.out.println("Error al registrar " + e.getMessage());
        } finally {
            MySQLConnection8.closeConnection(connection);
        }

        return rs;
    }

}
