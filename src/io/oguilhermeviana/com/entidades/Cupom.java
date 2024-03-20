package io.oguilhermeviana.com.entidades;

/**
 * Classe que representa a entidade cupom. Este pode ser utilizado no ato do fechamento do pedido
 * para obter um desconto, caso desejado.
 * @author Guilherme Viana
 */
public class Cupom {
    /*
     * Código descritivo do cupom.
     */
    private String id;

    /*
     * Valor em porcentagem do desconto.
     */
    private int desconto;

    /**
     * Constructor do cupom
     * @param id Código do cupom
     * @param desconto Procentagem do desconto
     */
    public Cupom(String id, int desconto) {
        this.id = id;
        this.desconto = desconto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
}
