package DAO.Interfaces;

import DAO.Class.ErroDAO;
import java.util.ArrayList;
import model.Reserva;

public interface ReservaDAOInterface {

    public void create(Reserva r) throws ErroDAO;

    public Reserva read(int id_reserva) throws ErroDAO;

    public ArrayList<Reserva> read(String procuraPor, String dado) throws ErroDAO;
    
    public ArrayList<Reserva> read() throws ErroDAO;

    public void update(Reserva r) throws ErroDAO;

    public void delete(int id_reserva) throws ErroDAO;

    public void sair() throws ErroDAO;
}
