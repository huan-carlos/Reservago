package controller.usuario;

import DAO.Class.ErroDAO;
import DAO.Class.UsuarioDAOClass;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "UpdateUser", urlPatterns = {"/updateuser"})
public class UpdateUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioDAOClass daoU = new UsuarioDAOClass();

            String nome = request.getParameter("nome");
            String endereco = (String) request.getParameter("endereco");
            String telefone = (String) request.getParameter("telefone");
            String senha = (String) request.getParameter("senha");
            String cpf = (String) request.getParameter("cpf");
            boolean cliente = Boolean.parseBoolean(request.getParameter("cliente"));

            if (nome != null && telefone != null && senha != null && cpf != null) {
                Usuario u = new Usuario(nome, endereco, telefone, senha, cpf, cliente);
                daoU.update(u);
            }

            daoU.sair();

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
