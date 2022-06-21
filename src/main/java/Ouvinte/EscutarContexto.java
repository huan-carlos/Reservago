package Ouvinte;

import DAO.Class.ErroDAO;
import DAO.Class.QuartoDAOClass;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.util.ArrayList;
import model.Quarto;

@WebListener
public class EscutarContexto implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            QuartoDAOClass daoQ = new QuartoDAOClass();
            ArrayList<Quarto> quartos = daoQ.read();
            sce.getServletContext().setAttribute("quartos", quartos);
        } catch (ErroDAO ex) {
            System.out.println(ex);
        }
    }
}