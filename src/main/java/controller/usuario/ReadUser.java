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
import java.util.ArrayList;
import model.Usuario;

@WebServlet(name = "ReadUser", urlPatterns = {"/readuser"})
public class ReadUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("1".equals(request.getParameter("flag"))) {
            request.getRequestDispatcher("/WEB-INF/view/usuario/readuser.jsp").forward(request, response);
        }
        
        HttpSession sessao = request.getSession(false);
        Usuario u = (Usuario) sessao.getAttribute("use");
        ArrayList<Usuario> usuarios = null;

        if (!u.isCliente()) {
            try {
                UsuarioDAOClass daoU = new UsuarioDAOClass();
                usuarios = daoU.read();
                sessao.setAttribute("usuarios", usuarios);
            } catch (ErroDAO ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
