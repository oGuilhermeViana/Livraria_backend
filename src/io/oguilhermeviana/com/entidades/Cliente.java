package io.oguilhermeviana.com.entidades;

/**
 * Classe que representa a entidade cliente. Este pode fazer um pedido.
 * @author Guilherme Viana
 */
public class Cliente {

    /*
     * Nome do cliente
     */
    private String nome;

    /*
     * Número de CPF do cliente
     */
    private String cpf;

    public Cliente() {
        this.nome = "Guilherme";
        this.cpf = "12345678900";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + "]";
    }
        
}
