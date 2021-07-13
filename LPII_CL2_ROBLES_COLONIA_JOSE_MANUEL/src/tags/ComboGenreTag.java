package tags;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.GenreDTO;
import dao.DAOFactory;

public class ComboGenreTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    private String genreCode = "-1";

    public String getGenreCode() {
        return genreCode;
    }

    public void setGenreCode(String genreCode) {
        this.genreCode = genreCode;
    }

    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();

        DAOFactory factory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
        ArrayList<GenreDTO> genreList = factory.getBookDAO().genreList();

        try {

            out.println("<option selected disabled hidden value=\"\">");
            out.println("Seleccione un genero");
            out.println("</option>");

            if (genreCode == null || genreCode.isEmpty())
                genreCode = "-1";

            for (GenreDTO g : genreList) {
                if (g.getCode() == Integer.parseInt(genreCode))
                    out.println("<option selected value=\"" + g.getCode() + "\">" + g.getName() + "</option>");
                else
                    out.println("<option value=\"" + g.getCode() + "\">" + g.getName() + "</option>");
            }

        } catch (Exception e) {
            System.out.println("Error en inicio de ComboGenreTag : " + e.getMessage());
        }

        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
