package DAO.Interfaces;

import model.Quarto;

public interface QuartoDAOInterface {

    public void create(Quarto q);

    public Quarto read(String nome);

    public void update(Quarto q);

    public void delete(String nome);

    public void sair();
}
