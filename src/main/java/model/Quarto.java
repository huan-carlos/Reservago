package model;

import java.util.Objects;

public class Quarto {

    private String nome, descricao, tipo;
    private double valor_diaria;

    public Quarto() {
    }

    public Quarto(String nome) {
        this.nome = nome;
    }

    public Quarto(String nome, String descricao, String tipo, double valor_diaria) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor_diaria = valor_diaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(double valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nome);
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
        final Quarto other = (Quarto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quarto{" + "nome=" + nome + ", descricao=" + descricao + ", tipo=" + tipo + ", valor_diaria=" + valor_diaria + '}';
    }

}
