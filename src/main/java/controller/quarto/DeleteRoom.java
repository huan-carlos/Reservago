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
import model.Usuario;

@WebServlet(name = "DeleteRoom", urlPatterns = {"/deleteroom"})
public class DeleteRoom extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QuartoDAOClass daoQ = new QuartoDAOClass();
            HttpSession sessao = request.getSession(false);
            Usuario use = (Usuario) sessao.getAttribute("usuario");

            String nome = request.getParameter("nome");

            if (use != null && !use.isCliente() && nome != null) {
                daoQ.delete(nome);
            }

            daoQ.sair();
            response.sendRedirect("readroom");

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
