package DAO.Class;

import DAO.Interfaces.ReservaDAOInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import model.Reserva;

public class ReservaDAOClass implements ReservaDAOInterface {

    Connection conection;

    public ReservaDAOClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservago?useSSL=false", "root", "Pr0fessor");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void create(Reserva r) {
        try ( PreparedStatement ps = conection.prepareStatement("INSERT INTO reserva (usuario_cpf, quarto_nome, inicio, fim) Values (?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, r.getUsuario().getCpf());
            ps.setString(2, r.getQuarto().getNome());
            ps.setString(3, r.getInicio());
            ps.setString(4, r.getFim());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                r.setId_reserva(rs.getInt(1));
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Reserva read(int id_reserva) throws ErroDAO {
        Reserva r = null;
        try ( PreparedStatement ps = conection.prepareStatement("SELECT id_reserva, usuario_cpf, quarto_nome, inicio, fim FROM reserva WHERE id_reserva=?;")) {

            ps.setInt(1, id_reserva);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                r = new Reserva(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

            }

            ps.close();

        } catch (SQLException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    @Override
    public ArrayList<Reserva> read(String procuraPor, String dado) throws ErroDAO {
        ArrayList<Reserva> r = new ArrayList();

        try ( PreparedStatement ps = conection.prepareStatement("SELECT id_reserva, usuario_cpf, quarto_nome, inicio, fim FROM reserva WHERE " + procuraPor + "=?;")) {

            ps.setString(1, dado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                r.add(new Reserva(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

            ps.close();

        } catch (SQLException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    @Override
    public void update(Reserva r) {
        try ( PreparedStatement ps = conection.prepareStatement("UPDATE reserva SET usuario_cpf=?, quarto_nome=?, inicio=?, fim=? WHERE id_reserva=?;")) {

            ps.setString(1, r.getUsuario().getCpf());
            ps.setString(2, r.getQuarto().getNome());
            ps.setString(3, r.getInicio());
            ps.setString(4, r.getFim());
            ps.setInt(5, r.getId_reserva());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(int id_reserva) {
        try ( PreparedStatement ps = conection.prepareStatement("DELETE FROM reserva WHERE id_reserva=?;")) {

            ps.setInt(1, id_reserva);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
        try {
            Reserva r = new Reserva(1, "02020", "0000", "01-01-1993", "02-01-1993");
            System.out.println(">>>>>" + r.getInicio());
        } catch (ErroDAO | ParseException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
