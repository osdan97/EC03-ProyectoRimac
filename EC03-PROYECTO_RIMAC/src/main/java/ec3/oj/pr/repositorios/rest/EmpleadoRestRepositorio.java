package ec3.oj.pr.repositorios.rest;

import org.springframework.data.repository.CrudRepository;

import ec3.oj.pr.modelos.Empleado;

public interface EmpleadoRestRepositorio extends CrudRepository<Empleado, Integer> {
	
}
