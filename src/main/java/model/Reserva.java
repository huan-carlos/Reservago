package model;

import DAO.Class.QuartoDAOClass;
import DAO.Class.UsuarioDAOClass;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {

    private int id_reserva;
    private Usuario usuario;
    private Quarto quarto;
    private Date inicio, fim;

    public Reserva(String usuario_cpf, String quarto_nome, String inicio, String fim) throws ParseException {
        UsuarioDAOClass daoU = new UsuarioDAOClass();
        QuartoDAOClass daoQ = new QuartoDAOClass();
        
        this.usuario = daoU.read(usuario_cpf);
        this.quarto = daoQ.read(quarto_nome);
        
        SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");

        this.inicio = sdformat.parse(inicio);
        this.fim = sdformat.parse(fim);
        
        daoU.sair();
        daoQ.sair();
    }
    
    public Reserva(int id_reserva, String usuario_cpf, String quarto_nome, String inicio, String fim) throws ParseException {
        UsuarioDAOClass daoU = new UsuarioDAOClass();
        QuartoDAOClass daoQ = new QuartoDAOClass();
        
        this.id_reserva = id_reserva;
        
        this.usuario = daoU.read(usuario_cpf);
        this.quarto = daoQ.read(quarto_nome);
        
        SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");

        this.inicio = sdformat.parse(inicio);
        this.fim = sdformat.parse(fim);
        
        daoU.sair();
        daoQ.sair();
    }

    public Reserva() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getInicio() {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        return sdformat.format(this.inicio);
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        return sdformat.format(this.fim);
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_reserva;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (this.id_reserva != other.id_reserva) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id_reserva=" + id_reserva + ", usuario=" + usuario + ", quarto=" + quarto + ", inicio=" + inicio + ", fim=" + fim + '}';
    }

}
