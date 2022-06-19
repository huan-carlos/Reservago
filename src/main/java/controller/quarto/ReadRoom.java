package controller.quarto;

import DAO.Class.ErroDAO;
import DAO.Class.QuartoDAOClass;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Quarto;
import model.Usuario;

@WebServlet(name = "ReadRoom", urlPatterns = {"/readroom"})
public class ReadRoom extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        Usuario u = (Usuario) sessao.getAttribute("usuario");
        ArrayList<Quarto> quartos = null;

        try {
            QuartoDAOClass daoQ = new QuartoDAOClass();

            if (!u.isCliente()) {
                quartos = daoQ.read();
                sessao.setAttribute("quartos", quartos);
                request.getRequestDispatcher("/WEB-INF/view/quarto/readroom.jsp").forward(request, response);
            }
            daoQ.sair();
        } catch (ErroDAO ex) {
            System.out.println(ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
