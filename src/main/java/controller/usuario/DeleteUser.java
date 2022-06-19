package controller.usuario;

import DAO.Class.ErroDAO;
import DAO.Class.UsuarioDAOClass;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;

@WebServlet(name = "DeleteUser", urlPatterns = {"/deleteuser"})
public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        Usuario use = (Usuario) sessao.getAttribute("usuario");

        if (use != null && !use.isCliente()) {
            try {
                UsuarioDAOClass daoU = new UsuarioDAOClass();
                String cpf = request.getParameter("cpf");

                if (cpf != null) {
                    daoU.delete(cpf);
                }
                daoU.sair();
                response.sendRedirect("readuser");

            } catch (ErroDAO ex) {
                System.out.println(ex);
                //mensagem de erro para a View
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
