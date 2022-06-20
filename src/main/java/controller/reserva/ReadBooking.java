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
import java.util.ArrayList;
import model.Reserva;
import model.Usuario;

@WebServlet(name = "ReadBooking", urlPatterns = {"/readbooking"})
public class ReadBooking extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession(false);
        Usuario use = (Usuario) sessao.getAttribute("usuario");
        ArrayList<Reserva> re = null;

        try {
            ReservaDAOClass daoR = new ReservaDAOClass();
            if (use != null && use.isCliente()) {

                re = daoR.read("usuario_cpf", use.getCpf());
                sessao.setAttribute("bookingUser", re);
                request.getRequestDispatcher("/WEB-INF/view/areacliente.jsp").forward(request, response);
            } else if (use != null && !use.isCliente()) {
                re = daoR.read();
                sessao.setAttribute("allBookings", re);
                request.getRequestDispatcher("/WEB-INF/view/reserva/readbooking.jsp").forward(request, response);
            }
        } catch (ErroDAO ex) {
            System.out.println(ex);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
