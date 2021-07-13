package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SolicitudDTO;
import dao.DAOFactory;
import mantenimientos.MySQLSolicitudDAO;

@WebServlet(name = "solservlet", urlPatterns = { "/solservlet" })
public class SolicitudesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option = request.getParameter("opcion");

        try {
            switch (option) {
            case "registrar":
                registrar(request, response);
                break;
            case "limpiar":
                limpiarContadores(request, response);
                break;
            default:
                System.out.println("ERROR EN LAS OPCIONES");
                break;
            }
        } catch (Exception e) {
            System.out.println("Error inesperado en el SolicitudesServlet");
        }

    }

    private void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = request.getParameter("txtCodigo");
        String fecha = request.getParameter("txtFecha");
        double monto = Double.parseDouble(request.getParameter("txtMonto"));
        String observacion = request.getParameter("txtObservacion");
        int codigoCliente = Integer.parseInt(request.getParameter("cboCliente"));
        int codigoTipCredi = Integer.parseInt(request.getParameter("cboTipoCredito"));

        SolicitudDTO solicitud = new SolicitudDTO(codigo, fecha, monto, observacion, codigoCliente, codigoTipCredi);

        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        int ok = factory.getSolicitudDAO().registrar(solicitud);

        String mensaje = "";
        String type = "";

        if (ok != 0) {
            mensaje = "Nueva solicitud registrada correctamente";
            type = "success";

            switch (codigoTipCredi) {
            case 1:
                contarYAcumularPorTipo(request, "cantidadTipo1", "acumuladoTipo1", monto);
                break;
            case 2:
                contarYAcumularPorTipo(request, "cantidadTipo2", "acumuladoTipo2", monto);
                break;
            case 3:
                contarYAcumularPorTipo(request, "cantidadTipo3", "acumuladoTipo3", monto);
                break;
            }

        } else {
            mensaje = "Sucedió un error : " + MySQLSolicitudDAO.errorMessage;
            type = "danger";
        }

        request.setAttribute("soliMensaje", mensaje);
        request.setAttribute("soliType", type);

        request.getRequestDispatcher("registro-robles.jsp").forward(request, response);
    }

    private void limpiarContadores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().setAttribute("cantidadTipo1", 0);
        request.getSession().setAttribute("cantidadTipo2", 0);
        request.getSession().setAttribute("cantidadTipo3", 0);

        request.getSession().setAttribute("acumuladoTipo1", 0.0);
        request.getSession().setAttribute("acumuladoTipo2", 0.0);
        request.getSession().setAttribute("acumuladoTipo3", 0.0);

        request.setAttribute("soliResultados", "Los acumuladores y contadores se limpiaron correctamente");
        request.setAttribute("soliType", "success");

        request.getRequestDispatcher("resultados-robles.jsp").forward(request, response);

    }

    private void contarYAcumularPorTipo(HttpServletRequest request, String varCantidad, String varMonto, double monto) {
        int cantidadSolicitudes = (int) request.getSession().getAttribute(varCantidad);
        double montoSolicitud = (double) request.getSession().getAttribute(varMonto);

        cantidadSolicitudes += 1;
        montoSolicitud += monto;

        request.getSession().setAttribute(varCantidad, cantidadSolicitudes);
        request.getSession().setAttribute(varMonto, montoSolicitud);
    }

}
