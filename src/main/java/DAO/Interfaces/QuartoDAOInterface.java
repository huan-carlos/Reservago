package DAO.Interfaces;

import DAO.Class.ErroDAO;
import java.util.ArrayList;
import model.Quarto;
import model.Reserva;

public interface QuartoDAOInterface {

    public void create(Quarto q) throws ErroDAO;

    public Quarto read(String nome) throws ErroDAO;
    
    public ArrayList<Quarto> read() throws ErroDAO;

    public void update(Quarto q) throws ErroDAO;

    public void delete(String nome) throws ErroDAO;

    public void sair() throws ErroDAO;
}
