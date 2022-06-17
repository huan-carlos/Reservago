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

@WebServlet(name = "CreateUser", urlPatterns = {"/createuser"})
public class CreateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("1".equals(request.getParameter("flag"))) {
            request.getRequestDispatcher("/WEB-INF/view/usuario/createuser.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioDAOClass daoU = new UsuarioDAOClass();
            HttpSession sessao = request.getSession(false);

            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String senha = request.getParameter("senha");
            String cpf = request.getParameter("cpf");
            boolean cliente = Boolean.parseBoolean(request.getParameter("cliente"));

            if (nome != null && telefone != null && senha != null && cpf != null) {
                Usuario u = new Usuario(nome, endereco, telefone, senha, cpf, cliente);
                daoU.create(u);
                if (sessao.getAttribute("usuario") == null) {
                    response.sendRedirect("login.jsp");
                } else {
                    request.getRequestDispatcher("/WEB-INF/view/areaatendente.jsp").forward(request, response);
                }
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
    }

}
