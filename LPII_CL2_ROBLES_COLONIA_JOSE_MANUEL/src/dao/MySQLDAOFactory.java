package dao;

import interfaces.AuthorDAO;
import interfaces.BookDAO;
import interfaces.BookPublicationDAO;
import mantenimientos.MySQLAuthorDAO;
import mantenimientos.MySQLBookDAO;
import mantenimientos.MySQLBookPublicationDAO;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public AuthorDAO getAuthorDAO() {
        return new MySQLAuthorDAO();
    }

    @Override
    public BookDAO getBookDAO() {
        return new MySQLBookDAO();
    }

    @Override
    public BookPublicationDAO getBookPublicationDAO() {
        return new MySQLBookPublicationDAO();
    }

}
