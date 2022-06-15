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

            String nome = (String) request.getAttribute("nome");
            String descricao = (String) request.getAttribute("descricao");
            double valor_diaria = (double) request.getAttribute("valor_diaria");
            String tipo = (String) request.getAttribute("tipo");

            if (nome != null && descricao != null && valor_diaria > 0 && tipo != null) {
                Quarto q = new Quarto(nome, descricao, tipo, valor_diaria);
                daoQ.create(q);
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
    }

}
