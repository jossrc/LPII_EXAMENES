package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookDTO;
import dao.DAOFactory;

@WebServlet(name = "libros", urlPatterns = { "/libros" })
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option = request.getParameter("opcion");

        try {
            switch (option) {
            case "buscar":
                searchBook(request, response);
                break;
            case "eliminar":
                deleteBook(request, response);
                break;
            default:
                System.out.println("ERROR EN LAS OPCIONES");
                break;
            }
        } catch (Exception e) {
            System.out.println("Error inesperado en el BookServlet");
        }

    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "";
        String message = "";

        String bookCode = request.getParameter("txtBookCode");
        
        System.out.println(bookCode);

        DAOFactory factory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
        int ok = factory.getBookDAO().delete(bookCode);

        if (ok == 0) {
            message = "Oops sucedió un error no se pudo eliminar";
            url = "consulta-robles.jsp";
        } else {
            message = "El libro se eliminó correctamente";
            url = "mantenimiento-robles.jsp";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher(url).forward(request, response);

    }

    private void searchBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bookCode = request.getParameter("idbook");

        DAOFactory factory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);

        BookDTO book = factory.getBookDAO().searchByCode(bookCode);

        if (book != null) {
            request.setAttribute("foundBook", book);
            request.getRequestDispatcher("mantenimiento-robles.jsp").forward(request, response);
        } else {
            String message = "ERROR - Libro no encontrado para eliminar";
            request.setAttribute("message", message);
            request.getRequestDispatcher("consulta-robles.jsp").forward(request, response);
        }

    }

}
