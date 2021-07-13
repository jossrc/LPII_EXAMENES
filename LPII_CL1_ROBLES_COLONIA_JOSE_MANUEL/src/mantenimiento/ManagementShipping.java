package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.ShippingInterface;
import model.Shipping;
import useful.MySQLConnection8;

public class ManagementShipping implements ShippingInterface {
    
    public static String errorMessage = "";

    @Override
    public int register(Shipping shipping) {
        int rs = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySQLConnection8.getConnection();
            String sql = "INSERT INTO envios VALUES (?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, shipping.getCode());
            preparedStatement.setString(2, shipping.getClientName());
            preparedStatement.setString(3, shipping.getProductName());
            preparedStatement.setString(4, shipping.getAddress());
            preparedStatement.setDouble(5, shipping.getPrice());
            preparedStatement.setString(6, shipping.getDate());
            preparedStatement.setInt(7, shipping.getStatus());

            rs = preparedStatement.executeUpdate();

        } catch (Exception e) {
            errorMessage = e.getMessage();
            System.out.println("Error al registrar " + e.getMessage());
        } finally {
            MySQLConnection8.closeConnection(connection);
        }

        return rs;
    }

    @Override
    public ArrayList<Shipping> list() {
        ArrayList<Shipping> list = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection8.getConnection();
            String sql = "SELECT * FROM envios";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            list = new ArrayList<Shipping>();

            while (resultSet.next()) {

                String code = resultSet.getString(1);
                String clientName = resultSet.getString(2);
                String productName = resultSet.getString(3);
                String address = resultSet.getString(4);
                double price = resultSet.getDouble(5);
                String date = resultSet.getString(6);
                int status = resultSet.getInt(7);

                Shipping newShipping = new Shipping(code, clientName, productName, address, price, date, status);
                list.add(newShipping);
            }

        } catch (Exception e) {
            System.out.println("Error en el listado de envíos " + e.getMessage());
        } finally {
            MySQLConnection8.closeConnection(connection);
        }

        return list;
    }

}
