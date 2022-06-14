package DAO.Interfaces;

import java.util.ArrayList;
import model.Reserva;

public interface ReservaDAOInterface {

    public void create(Reserva r);

    public Reserva read(int id_reserva);

    public ArrayList<Reserva> read(String procuraPor, String dado);

    public void update(Reserva r);

    public void delete(int id_reserva);

    public void sair();
}
