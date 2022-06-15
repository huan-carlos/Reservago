package controller.quarto;

import DAO.Class.ErroDAO;
import DAO.Class.QuartoDAOClass;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteRoom", urlPatterns = {"/deleteroom"})
public class DeleteRoom extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QuartoDAOClass daoQ = new QuartoDAOClass();

            String nome = (String) request.getAttribute("nome");

            if (nome != null) {
                daoQ.delete(nome);
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
