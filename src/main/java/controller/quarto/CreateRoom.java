package controller.quarto;

import DAO.Class.ErroDAO;
import DAO.Class.QuartoDAOClass;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Quarto;

@WebServlet(name = "CreateRoom", urlPatterns = {"/createroom"})
public class CreateRoom extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QuartoDAOClass daoQ = new QuartoDAOClass();

            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            double valor_diaria = Double.parseDouble(request.getParameter("valor_diaria"));
            String tipo = request.getParameter("tipo");

            if (nome != null && descricao != null && valor_diaria > 0 && tipo != null) {
                Quarto q = new Quarto(nome, descricao, tipo, valor_diaria);
                daoQ.create(q);
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
