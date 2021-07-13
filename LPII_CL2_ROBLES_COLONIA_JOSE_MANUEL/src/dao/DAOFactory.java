package dao;

import interfaces.AuthorDAO;
import interfaces.BookDAO;
import interfaces.BookPublicationDAO;

public abstract class DAOFactory {
    
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int SQL = 3;
    public static final int POSTGRESQL = 4;
    
    public abstract AuthorDAO getAuthorDAO();
    public abstract BookDAO getBookDAO();
    public abstract BookPublicationDAO getBookPublicationDAO();
    
    public static DAOFactory getDaoFactory(int qBD) {
        switch (qBD) {
        case MYSQL:
            return new MySQLDAOFactory();
        default:
            return null;
        }
    }

}
