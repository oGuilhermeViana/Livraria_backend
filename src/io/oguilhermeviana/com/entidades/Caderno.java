package io.oguilhermeviana.com.entidades;

import io.oguilhermeviana.com.entidades.constantes.Materias;

/**
 * Classe que representa um caderno, qual é uma especialização de um produto da loja.
 * @author Guilherme Viana
 */
public class Caderno extends Produto {
    /**
     * Quantidade de matérias que o caderno pode ter.
     */
    private Materias tipo;

    public Materias getTipo() {
        return tipo;
    }

    public void setTipo(Materias tipo) {
        this.tipo = tipo;
    }

    @Override
    public double calcularFrete() {
        return (getPreco() * getQuantidade()) + tipo.getFator();
    }

    @Override
    public String toString() {
        return "Caderno{" +
                " tipo=" + tipo + '\'' +
                ", codigo='" + getId() + '\'' +
                ", preço='" + getPreco() + '\'' +
                '}';
    }
    
}
