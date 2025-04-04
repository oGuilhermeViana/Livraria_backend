package io.oguilhermeviana.com.negocio;

import java.util.Optional;

import io.oguilhermeviana.com.bancodados.Banco;
import io.oguilhermeviana.com.entidades.Produto;

/**
 * Classe para manipular a entidade {@see Produto}
 * 
 * @author Guilherme Viana
 */
public class ProdutoNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * 
     * @param banco Banco de dados para ter armazenar e ter acesso os produtos
     */
    public ProdutoNegocio(Banco bancoDados) {
        this.bancoDados = bancoDados;
    }

    /**
     * Salva um novo produto(livro ou caderno) na loja.
     * 
     * @param novoProduto Livro ou caderno que pode ser vendido
     */
    public void salvar(Produto novoProduto) {

        String codigo = "PR%04d";
        codigo = String.format(codigo, bancoDados.getProdutos().length);
        novoProduto.setId(codigo);

        boolean produtoRepetido = false;
        for (Produto produto : bancoDados.getProdutos()) {
            if (produto.getId() == novoProduto.getId()) {
                produtoRepetido = true;
                System.out.println("Produto já cadastrado");
                break;
            }
        }

        if (!produtoRepetido) {
            this.bancoDados.adicionarProduto(novoProduto);
            System.out.println("Produto cadastrado com sucesso");
        }

    }

    /**
     * Exclui um produto pelo código de cadastro.
     * 
     * @param codigo Código de cadastro do produto
     */
    public void excluir(String codigo) {

        int produtoExclusao = -1;
        for (int i = 0; i < bancoDados.getProdutos().length; i++) {
            Produto produto = bancoDados.getProdutos()[i];
            if (produto.getId().equals(codigo)) {
                produtoExclusao = i;
                break;
            }
        }

        if (produtoExclusao != -1) {
            bancoDados.removerProduto(produtoExclusao);
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto inexistente.");
        }

    }

    /**
     * Obtem um produto a partir de seu código de cadastro.
     * @param codigo Código de cadastro do produto
     * @return Optional indicando a existência ou não do Produto
     */
    public Optional<Produto> consultar(String codigo) {

        for ( Produto produto : bancoDados.getProdutos()) {

            if (produto.getId().equalsIgnoreCase(codigo)) {
                return Optional.of(produto);
            }
        }

        return Optional.empty();

    }

    /**
     * Lista todos os produtos cadastrados.
     */
    public void listarTodos() {
        
        if (bancoDados.getProdutos().length == 0){
            System.out.println("Não existem produtos cadastrados");
        } else {

            for(Produto produto : bancoDados.getProdutos()) {
                System.out.println(produto.toString());
            }

        }
    }


}
