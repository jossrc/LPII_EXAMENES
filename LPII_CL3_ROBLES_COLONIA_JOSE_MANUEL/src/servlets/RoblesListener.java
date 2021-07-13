package servlets;

import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class RoblesListener implements HttpSessionListener {

    public RoblesListener() {

    }

    public void sessionCreated(HttpSessionEvent arg0) {

        System.out.println("Inicio de Sesión");
        System.out.println("ID     : " + arg0.getSession().getId());
        System.out.println("Fecha  : " + new SimpleDateFormat().format(arg0.getSession().getCreationTime()));

        int cantidadTipo1 = 0;
        int cantidadTipo2 = 0;
        int cantidadTipo3 = 0;
        double acumuladoTipo1 = 0.0;
        double acumuladoTipo2 = 0.0;
        double acumuladoTipo3 = 0.0;

        arg0.getSession().setAttribute("cantidadTipo1", cantidadTipo1);
        arg0.getSession().setAttribute("cantidadTipo2", cantidadTipo2);
        arg0.getSession().setAttribute("cantidadTipo3", cantidadTipo3);

        arg0.getSession().setAttribute("acumuladoTipo1", acumuladoTipo1);
        arg0.getSession().setAttribute("acumuladoTipo2", acumuladoTipo2);
        arg0.getSession().setAttribute("acumuladoTipo3", acumuladoTipo3);

    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("Finalizando la Sesión");
        System.out.println("ID     : " + arg0.getSession().getId());
        System.out.println("Fecha  : " + new SimpleDateFormat().format(arg0.getSession().getCreationTime()));
    }

}
