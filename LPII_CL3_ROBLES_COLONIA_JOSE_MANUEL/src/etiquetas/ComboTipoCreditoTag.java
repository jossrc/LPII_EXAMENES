package etiquetas;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.TipoCreditoDTO;
import dao.DAOFactory;

public class ComboTipoCreditoTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();

        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ArrayList<TipoCreditoDTO> lista = factory.getTipoCreditoDAO().listado();

        try {

            out.println("<option selected disabled hidden value=\"\">");
            out.println("Seleccione un tipo");
            out.println("</option>");

            for (TipoCreditoDTO t : lista) {
                out.println("<option value=\"" + t.getCodigo() + "\">" + t.getDescripcion() + "</option>");
            }

        } catch (Exception e) {
            System.out.println("Error en inicio de ComboTipoCreditoTag : " + e.getMessage());
        }

        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
