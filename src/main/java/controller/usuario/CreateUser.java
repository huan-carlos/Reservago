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

@WebServlet(name = "CreateUser", urlPatterns = {"/createuser"})
public class CreateUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioDAOClass daoU = new UsuarioDAOClass();
            
            String nome = (String) request.getAttribute("nome");
            String endereco = (String) request.getAttribute("endereco");
            String telefone = (String) request.getAttribute("telefone");
            String senha = (String) request.getAttribute("senha");
            String cpf = (String) request.getAttribute("cpf");
            boolean cliente = (boolean) request.getAttribute("cliente");
            
            Usuario u = new Usuario(nome, endereco, telefone, senha, cpf, cliente);
            
            daoU.create(u);
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
