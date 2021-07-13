package etiquetas;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.ClienteDTO;
import dao.DAOFactory;

public class ComboClienteTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();

        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ArrayList<ClienteDTO> lista = factory.getClienteDAO().listado();

        try {
            out.println("<option selected disabled hidden value=\"\">");
            out.println("Seleccione un cliente");
            out.println("</option>");

            for (ClienteDTO c : lista) {
                out.println("<option value=\"" + c.getCodigo() + "\">" + c.getNombre() + " " + c.getApellido()
                        + "</option>");
            }

        } catch (Exception e) {
            System.out.println("Error en inicio de ComboClienteTag : " + e.getMessage());
        }

        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
