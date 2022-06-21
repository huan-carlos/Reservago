package controller.reserva;

import DAO.Class.ErroDAO;
import DAO.Class.ReservaDAOClass;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.Reserva;
import model.Usuario;

@WebServlet(name = "DeleteBooking", urlPatterns = {"/deletebooking"})
public class DeleteBooking extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession sessao = request.getSession(false);
            Usuario use = (Usuario) sessao.getAttribute("usuario");
            int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
            ReservaDAOClass daoR = new ReservaDAOClass();
            SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");

            Reserva r = daoR.read(id_reserva);
            Date inicio = sdformat.parse(r.getInicio());

            int dias = (int) ((inicio.getTime() / 1000 / 60 / 60 / 24) - (Calendar.getInstance().getTimeInMillis() / 1000 / 60 / 60 / 24));

            if (use != null) {
                if (use.getCpf().equals(r.getUsuario().getCpf())) {
                    if (dias > 3) {
                        daoR.delete(id_reserva);
                    } else {
                        request.getRequestDispatcher("/WEB-INF/view/areacliente.jsp?mensagem=Resvas com menos de 72Hrs nao podem ser Deletada. Fale com um Atendente!").forward(request, response);
                    }
                } else if (!use.isCliente()) {
                    daoR.delete(id_reserva);
                    daoR.sair();
                    response.sendRedirect("readbooking");
                }
            }

        } catch (ErroDAO | ParseException | IllegalStateException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
