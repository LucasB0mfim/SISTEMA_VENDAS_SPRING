package br.com.lbomfim.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.lbomfim.domain.Produto;

/**
 * @author Lucas Bomfim 
 */

public interface IProdutoRepository extends CrudRepository<Produto, Long> {

}
