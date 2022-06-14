package DAO.Class;

import DAO.Interfaces.UsuarioDAOInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAOClass implements UsuarioDAOInterface {

    Connection conection;

    public UsuarioDAOClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reservago?useSSL=false", "root", "Pr0fessor");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void create(Usuario u) {
        try {
            PreparedStatement ps = conection.prepareStatement("INSERT INTO usuario (cpf, nome, endereco, telefone, senha, cliente) Values (?,?,?,?,?,?);");
            ps.setString(1, u.getCpf());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getEndereco());
            ps.setString(4, u.getTelefone());
            ps.setString(5, u.getSenha());
            ps.setBoolean(6, u.isCliente());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Usuario read(String cpf) {
        Usuario u = null;
        try ( PreparedStatement ps = conection.prepareStatement("SELECT nome, endereco, telefone, senha, cpf, cliente FROM usuario WHERE cpf=?;")) {

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u;
    }

    @Override
    public void update(Usuario u) {
        try ( PreparedStatement ps = conection.prepareStatement("UPDATE usuario SET nome=?, endereco=?, telefone=?, senha=?, cliente=? WHERE cpf=?;")) {

            ps.setString(1, u.getNome());
            ps.setString(2, u.getEndereco());
            ps.setString(3, u.getTelefone());
            ps.setString(4, u.getSenha());
            ps.setBoolean(5, u.isCliente());
            ps.setString(6, u.getCpf());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(String cpf) {
        try ( PreparedStatement ps = conection.prepareStatement("DELETE FROM usuario WHERE cpf=?;")) {

            ps.setString(1, cpf);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Usuario logar(String cpf, String senha) {
        Usuario u = null;
        try ( PreparedStatement ps = conection.prepareStatement("SELECT nome, endereco, telefone, senha, cpf, cliente FROM usuario WHERE cpf=? AND senha=?;");) {

            ps.setString(1, cpf);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u;
    }

    @Override
    public void sair() {
        try {
            conection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        UsuarioDAOClass dao = new UsuarioDAOClass();
        Usuario u = new Usuario("Huan Carlos", "604 Norte", "63992028204", "teste", "03650829100", false);
        dao.create(u);
        System.out.println("Lendo Read: " + dao.read(u.getCpf()));
        u.setEndereco("Palmas");
        dao.update(u);
        System.out.println("Lendo Update " + dao.read(u.getCpf()));
        System.out.println("Logando: " + dao.logar("03650829100", "teste"));
        dao.delete(u.getCpf());
        System.out.println("Deletado");
    }

}
