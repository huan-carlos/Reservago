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
import model.Quarto;
import model.Usuario;

@WebServlet(name = "CreateRoom", urlPatterns = {"/createroom"})
public class CreateRoom extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("1".equals(request.getParameter("flag"))) {
            request.getRequestDispatcher("/WEB-INF/view/quarto/createroom.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QuartoDAOClass daoQ = new QuartoDAOClass();
            HttpSession sessao = request.getSession(false);
            Usuario use = (Usuario) sessao.getAttribute("usuario");

            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            double valor_diaria = Double.parseDouble(request.getParameter("valor_diaria"));
            String tipo = request.getParameter("tipo");

            if (use != null && !use.isCliente()) {
                if (nome != null && descricao != null && valor_diaria > 0 && tipo != null) {
                    Quarto q = new Quarto(nome, descricao, tipo, valor_diaria);
                    daoQ.create(q);
                    daoQ.sair();
                    response.sendRedirect("readroom");
                }
            }

        } catch (ErroDAO ex) {
            System.out.println(ex);
            //mensagem de erro para a View
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
