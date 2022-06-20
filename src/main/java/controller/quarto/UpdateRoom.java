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

@WebServlet(name = "UpdateRoom", urlPatterns = {"/updateroom"})
public class UpdateRoom extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        if (sessao != null) {
            Usuario u = (Usuario) sessao.getAttribute("usuario");
            if (!u.isCliente()) {
                try {
                    String nome = request.getParameter("nome");
                    QuartoDAOClass daoQ = new QuartoDAOClass();

                    Quarto roomToUpdate = daoQ.read(nome);

                    sessao.setAttribute("roomToUpdate", roomToUpdate);

                    request.getRequestDispatcher("/WEB-INF/view/quarto/updateroom.jsp").forward(request, response);
                } catch (ErroDAO ex) {
                    System.out.println(ex);
                    //mensagem de erro para a View
                }
            }
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
                    daoQ.update(q);
                    response.sendRedirect("readroom");
                }
            }

            daoQ.sair();

        } catch (ErroDAO ex) {
            System.out.println(ex);
            //mensagem de erro para a View
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
