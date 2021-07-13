package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.ManagementShipping;
import model.Shipping;

@MultipartConfig
@WebServlet(name = "shipping", urlPatterns = { "/shipping" })
public class ShippingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option = request.getParameter("opcion") != null ? request.getParameter("opcion") : "error";

        switch (option) {
        case "registrar":
            register(request, response);
            break;
        case "listar":
            list(request, response);
            break;
        default:
            System.out.println("Error en la opción");
            break;
        }

    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("shipping-code");
        String clientName = request.getParameter("shipping-clientName");
        String productName = request.getParameter("shipping-product");
        String address = request.getParameter("shipping-address");
        double price = Double.parseDouble(request.getParameter("shipping-price"));
        String date = request.getParameter("shipping-date");
        int status = Integer.parseInt(request.getParameter("shipping-status"));

        Shipping shipping = new Shipping(code, clientName, productName, address, price, date, status);

        int ok = new ManagementShipping().register(shipping);

        if (ok == 0) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            PrintWriter writer = response.getWriter();
            String message = ManagementShipping.errorMessage;
            writer.print(message);

        } else {
            System.out.println("Se registro un envío en la Base de Datos");
        }

    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Shipping> list = new ManagementShipping().list();

        request.setAttribute("shippingList", list);
        request.getRequestDispatcher("robles-consulta.jsp").forward(request, response);

    }

}
