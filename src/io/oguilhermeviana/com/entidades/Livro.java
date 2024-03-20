package io.oguilhermeviana.com.entidades;

import io.oguilhermeviana.com.entidades.constantes.Genero;

/**
 * Classe que representa um livro, qual é uma especialização de um produto da loja.
 * @author Guilherme Viana
 */
public class Livro extends Produto {
    /*
     * Nome do livro
     */
    private String nome;
    /*
     * genero do livro
     */
    private Genero genero;

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Genero getGenero() {
        return genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public double calcularFrete() {
        return (getPreco() * getQuantidade()) * (1 + genero.getFator());
    }
    
    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", genero=" + genero + '\'' +
                ", codigo='" + getId() + '\'' +
                ", preço='" + getPreco() + '\'' +
                '}';
    }
}
