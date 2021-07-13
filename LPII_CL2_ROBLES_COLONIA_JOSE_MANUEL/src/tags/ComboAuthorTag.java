package tags;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.AuthorDTO;
import dao.DAOFactory;

public class ComboAuthorTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    private String authorCode = "-1";
    
    public String getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(String authorCode) {
        this.authorCode = authorCode;
    }

    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();

        DAOFactory factory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
        ArrayList<AuthorDTO> authorList = factory.getAuthorDAO().list();
        try {

            out.println("<option selected disabled hidden value=\"\">");
            out.println("Seleccione un autor");
            out.println("</option>");
                        
            if (authorCode == null || authorCode.isEmpty())
                authorCode = "-1";

            for (AuthorDTO a : authorList) {

                if (a.getCode() == Integer.parseInt(authorCode))
                    out.println("<option selected value=\"" + a.getCode() + "\">" + a.getName() + "</option>");
                else
                    out.println("<option value=\"" + a.getCode() + "\">" + a.getName() + "</option>");
            }

        } catch (Exception e) {
            System.out.println("Error en inicio de ComboAuthorTag : " + e.getMessage());
        }

        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
