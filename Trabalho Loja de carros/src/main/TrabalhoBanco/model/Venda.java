package main.TrabalhoBanco.model;

import java.util.Date;

public class Venda {
    private Integer codigo;
    private Date dataVenda;
    private Cliente cliente;
    private Veiculo veiculo;
    private Double valorVenda;

    public Venda(Integer codigo, Double valorVenda, Veiculo veiculo, Cliente cliente, Date dataVenda) {
        this.codigo = codigo;
        this.valorVenda = valorVenda;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
    }

    public Venda() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}
