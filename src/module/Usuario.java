package module;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private Endereco endereco;
    private Integer idade;
    private static List<Evento> eventosConfirmados = new ArrayList<>();

    private static List<Usuario> usuarios = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public static List<Evento> getEventosConfirmados() {
        return eventosConfirmados;
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }
}
