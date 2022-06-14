package DAO.Interfaces;

import DAO.Class.ErroDAO;
import model.Quarto;

public interface QuartoDAOInterface {

    public void create(Quarto q) throws ErroDAO;

    public Quarto read(String nome) throws ErroDAO;

    public void update(Quarto q) throws ErroDAO;

    public void delete(String nome) throws ErroDAO;

    public void sair() throws ErroDAO;
}
