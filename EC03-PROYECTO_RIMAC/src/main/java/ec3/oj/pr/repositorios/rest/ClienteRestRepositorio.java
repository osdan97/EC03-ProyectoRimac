package ec3.oj.pr.repositorios.rest;

import org.springframework.data.repository.CrudRepository;

import ec3.oj.pr.modelos.Cliente;

public interface ClienteRestRepositorio extends CrudRepository<Cliente, Integer> {
	
}
