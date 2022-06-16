package DAO.Class;

import DAO.Interfaces.QuartoDAOInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Quarto;
import model.Usuario;

public class QuartoDAOClass implements QuartoDAOInterface {

    Connection conection;

    public QuartoDAOClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservago?useSSL=false", "root", "Pr0fessor");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void create(Quarto q) throws ErroDAO {
        try ( PreparedStatement ps = conection.prepareStatement("INSERT INTO quarto (nome, descricao, valor_diaria, tipo) Values (?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, q.getNome());
            ps.setString(2, q.getDescricao());
            ps.setDouble(3, q.getValor_diaria());
            ps.setString(4, q.getTipo());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Quarto read(String nome) throws ErroDAO {
        Quarto q = null;
        try ( PreparedStatement ps = conection.prepareStatement("SELECT nome, descricao, tipo, valor_diaria FROM quarto WHERE nome=?;")) {

            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                q = new Quarto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return q;
    }

    @Override
    public ArrayList<Quarto> read() throws ErroDAO {
        ArrayList<Quarto> r = new ArrayList();

        try ( PreparedStatement ps = conection.prepareStatement("SELECT nome, descricao, tipo, valor_diaria FROM quarto;")) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                r.add(new Quarto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    @Override
    public void update(Quarto q) throws ErroDAO {
        try ( PreparedStatement ps = conection.prepareStatement("UPDATE quarto SET descricao=?, tipo=?, valor_diaria=? WHERE nome=?;")) {

            ps.setString(1, q.getDescricao());
            ps.setString(2, q.getTipo());
            ps.setDouble(3, q.getValor_diaria());
            ps.setString(4, q.getNome());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(String nome) throws ErroDAO {
        try ( PreparedStatement ps = conection.prepareStatement("DELETE FROM quarto WHERE nome=?;")) {

            ps.setString(1, nome);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void sair() throws ErroDAO {
        try {
            conection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            QuartoDAOClass dao = new QuartoDAOClass();
            Quarto q = new Quarto("A101", "2 Quarto + 1 Banheiro", "Casal", 100.00);
            dao.create(q);
            System.out.println("Lendo Após Create: " + dao.read(q.getNome()));
            q.setValor_diaria(500.00);
            dao.update(q);
            System.out.println("Lendo Após Update: " + dao.read(q.getNome()));
            dao.delete(q.getNome());
            System.out.println("Deletado");
        } catch (ErroDAO ex) {
            Logger.getLogger(QuartoDAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
