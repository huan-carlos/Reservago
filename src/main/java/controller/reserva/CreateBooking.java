package controller.reserva;

import DAO.Class.ErroDAO;
import DAO.Class.QuartoDAOClass;
import DAO.Class.ReservaDAOClass;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Quarto;
import model.Reserva;
import model.Usuario;

@WebServlet(name = "CreateBooking", urlPatterns = {"/createbooking"})
public class CreateBooking extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        Usuario use = (Usuario) sessao.getAttribute("usuario");

        if (use != null && "1".equals(request.getParameter("flag"))) {
            try {
                String quarto_nome = request.getParameter("flag");
                QuartoDAOClass daoQ = new QuartoDAOClass();
                Quarto q = daoQ.read(quarto_nome);
                sessao.setAttribute("RoomToBooking", q);
                request.getRequestDispatcher("/WEB-INF/view/reserva/createbooking.jsp").forward(request, response);
            } catch (ErroDAO ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        Usuario use = (Usuario) sessao.getAttribute("usuario");

        if (use != null) {
            try {
                String usuario_cpf = request.getParameter("usuario_cpf");
                String quarto_nome = request.getParameter("quarto_nome");
                String inicio = request.getParameter("inicio");
                String fim = request.getParameter("fim");
                Reserva r = null;

                r = new Reserva(usuario_cpf, quarto_nome, inicio, fim);

                ReservaDAOClass daoR = new ReservaDAOClass();
                daoR.create(r);
                response.sendRedirect("readbooking");
            } catch (ParseException | ErroDAO ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
