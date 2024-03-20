package io.oguilhermeviana.com.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a entidade pedido, qual é a compra dos produtos por um cliente.
 * @author Guilherme Viana
 */
public class Pedido {
    /**
     * Código do produto
     */
    private String id;

    /**
     * {@inheritDoc}
     */
    private Cliente cliente;

    /**
     * Lista de @see Produto
     */
    private List<Produto> produtos;

    /**
     * total do pedido
     */
    private double total;

    public Pedido() {
        this.produtos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private String getProdutosComprados(){

        StringBuilder produtos = new StringBuilder();
        produtos.append("[");
        for(Produto produto : getProdutos()){
            produtos.append(produto.toString());
            produtos.append("Qtd:");
            produtos.append(produto.getQuantidade());
            produtos.append(" ");
        }
        produtos.append("]");

        return produtos.toString();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", produtos=" + getProdutosComprados() +
                ", total=" + total +
                '}';
    }
}
