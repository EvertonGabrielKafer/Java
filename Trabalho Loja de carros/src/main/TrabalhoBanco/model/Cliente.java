package main.TrabalhoBanco.model;

public class Cliente {
    private Integer codigo;
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente(Integer codigo, String nome, String cpf, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Cliente(String nome, String cpf, String telefone) {
        this(null, nome, cpf, telefone);
    }

    public Cliente() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
