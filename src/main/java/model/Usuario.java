package model;

import java.util.Objects;

public class Usuario {

    private String nome, endereco, telefone, senha, cpf;
    private boolean cliente;

    public Usuario(String cpf) {
        this.cpf = cpf;
    }

    public Usuario() {
    }

    public Usuario(String nome, String endereco, String telefone, String senha, String cpf, boolean cliente) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.senha = senha;
        this.cpf = cpf;
        this.cliente = cliente;
    }

    public Usuario(String nome, String telefone, String senha, String cpf, boolean cliente) {
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.cpf = cpf;
        this.cliente = cliente;
        //endereço não é um dado obrigatório
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isCliente() {
        return cliente;
    }
    
    /*public String getCliente(){
        if(this.cliente){
            return "Cliente";
        }
        return "Atendente";
    }*/

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.cpf);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", senha=" + senha + ", cpf=" + cpf + ", cliente=" + cliente + '}';
    }

}
