package io.oguilhermeviana.com.entidades;

/**
 * Classe que representa a abstração dos produtos que podem ser vendidos pela loja.
 * @author Guilherme Viana
 */
public abstract class Produto {
    /*
     * código de identificação do produto
     */
    private String id;

    /*
     * preço unitário do produto
     */
    private double preco;

    /*
     * quantidade a ser comprada
     */
    private int quantidade;

    public Produto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Calcula o preço do frete para os produtos comprados. Este cálculo pode
     * variar de acordo com o produto
     * @return valor do frete para o determinado produto
     */
    public abstract double calcularFrete();
}
