package DAO.Interfaces;

import DAO.Class.ErroDAO;
import java.util.ArrayList;
import model.Reserva;
import model.Usuario;

public interface UsuarioDAOInterface {

    public void create(Usuario u) throws ErroDAO;

    public Usuario read(String cpf) throws ErroDAO;
    
    public ArrayList<Usuario> read() throws ErroDAO;

    public void update(Usuario u) throws ErroDAO;

    public void delete(String cpf) throws ErroDAO;

    public Usuario logar(String cpf, String senha) throws ErroDAO;

    public void sair() throws ErroDAO;
}
