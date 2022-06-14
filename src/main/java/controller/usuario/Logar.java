package controller.usuario;

import DAO.Class.ErroDAO;
import DAO.Class.UsuarioDAOClass;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Logar", urlPatterns = {"/logar"})
public class Logar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioDAOClass daoU = new UsuarioDAOClass();

            String cpf = (String) request.getAttribute("cpf");
            String senha = (String) request.getAttribute("senha");

            if (cpf != null && senha != null) {
                if(daoU.logar(cpf, senha).isCliente()){
                    request.getRequestDispatcher("/WEB-INF/view/areacliente.jsp");
                }else{
                    request.getRequestDispatcher("/WEB-INF/view/areaatendente.jsp");
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
    }// </editor-fold>

}
