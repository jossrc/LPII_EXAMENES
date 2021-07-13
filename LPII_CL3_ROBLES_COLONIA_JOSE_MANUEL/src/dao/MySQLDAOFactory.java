package dao;

import interfaces.ClienteDAO;
import interfaces.SolicitudDAO;
import interfaces.TipoCreditoDAO;
import mantenimientos.MySQLClienteDAO;
import mantenimientos.MySQLSolicitudDAO;
import mantenimientos.MySQLTipoCreditoDAO;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public ClienteDAO getClienteDAO() {
        return new MySQLClienteDAO();
    }

    @Override
    public TipoCreditoDAO getTipoCreditoDAO() {
        return new MySQLTipoCreditoDAO();
    }

    @Override
    public SolicitudDAO getSolicitudDAO() {
        return new MySQLSolicitudDAO();
    }

}
