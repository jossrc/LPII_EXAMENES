package dao;

import interfaces.ClienteDAO;
import interfaces.SolicitudDAO;
import interfaces.TipoCreditoDAO;

public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int SQL = 3;
    public static final int POSTGRESQL = 4;
    
    public abstract ClienteDAO getClienteDAO();
    public abstract TipoCreditoDAO getTipoCreditoDAO();
    public abstract SolicitudDAO getSolicitudDAO();
    
    public static DAOFactory getDAOFactory(int qBD) {
        switch (qBD) {
        case MYSQL:
            return new MySQLDAOFactory();
        default:
            return null;
        }
    }
    
}
