package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookPublicationDTO;
import dao.DAOFactory;

@WebServlet(name = "publicacion", urlPatterns = { "/publicacion" })
public class BookPublicationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option = request.getParameter("opcion");

        try {
            switch (option) {
            case "filtrar":
                filterByAuthors(request, response);
                break;
            default:
                System.out.println("ERROR EN LAS OPCIONES");
                break;
            }
        } catch (Exception e) {
            System.out.println("Error inesperado en el BookPublicationServlet");
        }

    }

    private void filterByAuthors(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int authorCode = Integer.parseInt(request.getParameter("cboAuthors"));

        DAOFactory factory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
        ArrayList<BookPublicationDTO> bookList = factory.getBookPublicationDAO().listByAuthor(authorCode);

        request.setAttribute("rqAuthorCode", String.valueOf(authorCode));

        if (bookList.size() > 0) {
            request.setAttribute("lstPublicationBooks", bookList);
            request.getRequestDispatcher("consulta-robles.jsp").forward(request, response);
        } else {
            String message = "No se encontraron libros relacionados a ese autor";
            request.setAttribute("message", message);
            request.getRequestDispatcher("consulta-robles.jsp").forward(request, response);
        }

    }

}
