package br.com.lbomfim.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.lbomfim.domain.Venda;

/**
 * @author Lucas Bomfim 
 */

public interface IVendaRepository extends CrudRepository<Venda, Long>{

}
