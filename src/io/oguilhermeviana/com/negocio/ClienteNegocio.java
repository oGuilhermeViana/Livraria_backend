package io.oguilhermeviana.com.negocio;

import java.util.Optional;

import io.oguilhermeviana.com.bancodados.Banco;
import io.oguilhermeviana.com.entidades.Cliente;

/**
 * Classe para manipular a entidade {@see Cliente}
 * @author Guilherme Viana
 */
public class ClienteNegocio {
    
    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * @param banco Banco de dados para ter acesso aos clientes cadastrados
     */
    public ClienteNegocio(Banco bancoDados) {
        this.bancoDados = bancoDados;
    }

    public Optional<Cliente> consultar(String cpf){
        
        if(bancoDados.getCliente().getCpf().equals(cpf)) {
            return Optional.of(bancoDados.getCliente());
        } else {
            return Optional.empty();
        }
    }

}
