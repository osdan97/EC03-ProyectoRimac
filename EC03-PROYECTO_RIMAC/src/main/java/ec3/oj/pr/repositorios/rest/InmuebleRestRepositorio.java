package ec3.oj.pr.repositorios.rest;

import org.springframework.data.repository.CrudRepository;

import ec3.oj.pr.modelos.Inmueble;

public interface InmuebleRestRepositorio extends CrudRepository<Inmueble, Integer> {
	
}
