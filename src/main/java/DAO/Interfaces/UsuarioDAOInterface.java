package DAO.Interfaces;

import DAO.Class.ErroDAO;
import model.Usuario;

public interface UsuarioDAOInterface {

    public void create(Usuario u) throws ErroDAO;

    public Usuario read(String cpf) throws ErroDAO;

    public void update(Usuario u) throws ErroDAO;

    public void delete(String cpf) throws ErroDAO;

    public Usuario logar(String cpf, String senha) throws ErroDAO;

    public void sair() throws ErroDAO;
}
