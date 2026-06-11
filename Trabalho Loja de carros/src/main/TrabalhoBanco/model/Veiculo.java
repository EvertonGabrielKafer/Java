package main.TrabalhoBanco.model;

public class Veiculo {
    private Integer codigo;
    private String marca;
    private String modelo;
    private Integer ano;
    private Double valor;
    private Boolean disponivel;

    public Veiculo(Integer codigo, String marca, String modelo, Integer ano, Double valor, Boolean disponivel) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public Veiculo(String marca, String modelo, Integer ano, Double valor, Boolean disponivel) {
        this(null, marca, modelo, ano, valor, disponivel);
    }

    public Veiculo() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getAno() {
        return ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }



    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
