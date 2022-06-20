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

@WebServlet(name = "Logar", urlPatterns = {"/logar"})
public class Logar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioDAOClass daoU = new UsuarioDAOClass();

            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");
            
            Usuario use = daoU.logar(cpf, senha);

            if (use != null) {
                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("usuario", use);
                if (!use.isCliente()) {
                    request.getRequestDispatcher("/WEB-INF/view/areaatendente.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/WEB-INF/view/areacliente.jsp").forward(request, response);
                }

            } else {
                //response.sendError(401, "Dados Invalidos!");
                response.sendRedirect("login.jsp?mensagem=Dados Invalidos!");
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
