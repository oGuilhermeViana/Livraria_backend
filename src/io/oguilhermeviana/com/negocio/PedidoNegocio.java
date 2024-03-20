package io.oguilhermeviana.com.negocio;

import java.time.LocalDate;
import java.util.List;

import io.oguilhermeviana.com.bancodados.Banco;
import io.oguilhermeviana.com.entidades.Cupom;
import io.oguilhermeviana.com.entidades.Pedido;
import io.oguilhermeviana.com.entidades.Produto;

/**
 * Classe para manipular a entidade {@link Pedido}.
 * 
 * @author Guilherme Viana
 */
public class PedidoNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * 
     * @param banco Banco de dados para ter armazenar e ter acesso os pedidos
     */
    public PedidoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    private double calcularValor(List<Produto> produtos, Cupom cupom) {
        double total = 0.0;

        for (Produto produto : produtos) {
            total += produto.calcularFrete();
        }

        if (cupom != null) {
            return total * (1 - cupom.getDesconto());
        } else {
            return total;
        }

    }

    /**
     * Salva um novo pedido sem cupom de desconto.
     * 
     * @param novoPedido Pedido a ser armazenado
     */
    public void salvar(Pedido novoPedido) {
        salvar(novoPedido, null);
    }

    /**
     * Salva um novo pedido com cupom de desconto.
     * 
     * @param novoPedido Pedido a ser armazenado
     * @param cupom      Cupom de desconto a ser utilizado
     */
    public void salvar(Pedido novoPedido, Cupom cupom) {
        String codigo = "PE%4d%2d%04d";
        LocalDate hoje = LocalDate.now();
        codigo = String.format(codigo, hoje.getYear(), hoje.getMonthValue(), bancoDados.getPedidos().length);

        novoPedido.setId(codigo);
        novoPedido.setCliente(bancoDados.getCliente());
        novoPedido.setTotal(calcularValor(novoPedido.getProdutos(), cupom));
        bancoDados.adicionarPedido(novoPedido);
        System.out.println("Pedido cadastrado com sucesso.");

    }

    /**
     * Exclui um pedido a partir de seu código de rastreio.
     * 
     * @param codigo Código do pedido
     */
    public void excluir(String codigo) {

        int pedidoExcluido = -1;
        for (int i = 0; i < bancoDados.getPedidos().length; i++) {
            Pedido pedido = bancoDados.getPedidos()[i];
            if (pedido.getId().equals(codigo)) {
                pedidoExcluido = i;
                break;
            }
        }

        if (pedidoExcluido != -1) {
            bancoDados.removerProduto(pedidoExcluido);
            System.out.println("Pedido excluido com sucesso.");
        } else {
            System.out.println("Pedido inexistente.");
        }

    }

    /**
     * Lista todos os pedidos realizados.
     */
    public void listarTodos() {

        if (bancoDados.getPedidos().length == 0) {
            System.out.println("Não existem pedidos cadastrados");
        } else {

            for (Pedido pedido : bancoDados.getPedidos()) {
                System.out.println(pedido.toString());
            }
        }
    }

}
