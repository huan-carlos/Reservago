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

@WebServlet(name = "UpdateUser", urlPatterns = {"/updateuser"})
public class UpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        if (sessao != null) {
            Usuario u = (Usuario) sessao.getAttribute("usuario");
            if (!u.isCliente()) {
                try {
                    String cpf = (String) request.getParameter("cpf");
                    UsuarioDAOClass daoU = new UsuarioDAOClass();

                    Usuario userToUpdate = daoU.read(cpf);

                    sessao.setAttribute("userToUpdate", userToUpdate);
                    
                    request.getRequestDispatcher("/WEB-INF/view/usuario/updateuser.jsp").forward(request, response);
                } catch (ErroDAO ex) {
                    System.out.println(ex);
                    //mensagem de erro para a View
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        if (sessao != null) {
            Usuario u = (Usuario) sessao.getAttribute("usuario");
            if (!u.isCliente()) {

                try {
                    UsuarioDAOClass daoU = new UsuarioDAOClass();

                    String nome = request.getParameter("nome");
                    String endereco = request.getParameter("endereco");
                    String telefone = request.getParameter("telefone");
                    String senha = request.getParameter("senha");
                    String cpf = request.getParameter("cpf");
                    boolean cliente = Boolean.parseBoolean(request.getParameter("cliente"));

                    if (nome != null && telefone != null && senha != null && cpf != null) {
                        Usuario user = new Usuario(nome, endereco, telefone, senha, cpf, cliente);
                        daoU.update(user);
                    }

                    daoU.sair();
                    
                    response.sendRedirect("readuser");

                } catch (ErroDAO ex) {
                    System.out.println(ex);
                    //mensagem de erro para a View
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
