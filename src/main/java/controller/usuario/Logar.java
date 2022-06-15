package controller.usuario;

import DAO.Class.ErroDAO;
import DAO.Class.UsuarioDAOClass;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import jakarta.servlet.http.HttpSession;
import model.Usuario;
=======
>>>>>>> 9d86c42de37b3f891783f245126c89687a92b1bc

@WebServlet(name = "Logar", urlPatterns = {"/logar"})
public class Logar extends HttpServlet {

    @Override
<<<<<<< HEAD
=======
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("1".equals(request.getParameter("flag"))) {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
>>>>>>> 9d86c42de37b3f891783f245126c89687a92b1bc
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioDAOClass daoU = new UsuarioDAOClass();

<<<<<<< HEAD
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");
            
            System.out.println(">>>>>"+cpf+">>>>>>"+senha);

            if (cpf != null && senha != null) {
                Usuario use = daoU.logar(cpf, senha);
                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("usuario", use);
                if (use.isCliente()) {
=======
            String cpf = (String) request.getAttribute("cpf");
            String senha = (String) request.getAttribute("senha");

            if (cpf != null && senha != null) {
                if (daoU.logar(cpf, senha).isCliente()) {
>>>>>>> 9d86c42de37b3f891783f245126c89687a92b1bc
                    request.getRequestDispatcher("/WEB-INF/view/areacliente.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/WEB-INF/view/areaatendente.jsp").forward(request, response);
                }

<<<<<<< HEAD
            } else {
=======
            }else{
>>>>>>> 9d86c42de37b3f891783f245126c89687a92b1bc
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
