package io.oguilhermeviana.com.bancodados;

import java.util.ArrayList;
import java.util.List;

import io.oguilhermeviana.com.entidades.Cliente;
import io.oguilhermeviana.com.entidades.Cupom;
import io.oguilhermeviana.com.entidades.Pedido;
import io.oguilhermeviana.com.entidades.Produto;

/**
 * Classe responsável por simular um banco de dados. Esta faz as inserções e
 * exclusões da
 * aplicação. Atualizações não são permitidas para facilitar o funcionamento da
 * aplicação.
 * 
 * @author Guilherme Viana
 */
public class Banco {
    /**
     * Lista que armazena o produtos(Livros e Cadernos) cadastrados.
     */
    private List<Produto> produtos;

    /**
     * Lista que armazenar os pedidos cadastrados.
     */
    private List<Pedido> pedidos;

    /**
     * Lista que armazenar os cupons cadastrados.
     */
    private List<Cupom> cupons;

    /**
     * Cliente cadastrado.
     */
    private Cliente cliente;

    public Banco() {
        this.cliente = new Cliente();
        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();

        this.cupons = new ArrayList<>();
        cupons.add(new Cupom("CUPOM2", 2));
        cupons.add(new Cupom("CUPOM5", 5));
        cupons.add(new Cupom("CUPOM7", 7));
    }

    public Produto[] getProdutos() {
        return produtos.toArray(new Produto[produtos.size()]);
    }

    public Pedido[] getPedidos() {
        return pedidos.toArray(new Pedido[pedidos.size()]);
    }

    public Cupom[] getCupons() {
        return cupons.toArray(new Cupom[cupons.size()]);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int posicao) {
        produtos.remove(posicao);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void adicionarRemover(int posicao) {
        pedidos.remove(posicao);
    }

}
