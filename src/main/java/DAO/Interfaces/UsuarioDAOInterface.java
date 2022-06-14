package DAO.Interfaces;

import model.Usuario;

public interface UsuarioDAOInterface {

    public void create(Usuario u);

    public Usuario read(String cpf);

    public void update(Usuario u);

    public void delete(String cpf);

    public Usuario logar(String cpf, String senha);

    public void sair();
}
