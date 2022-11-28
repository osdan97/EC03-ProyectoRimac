
package ec3.oj.pr.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ec3.oj.pr.modelos.Empleado;



public interface EmpleadoRepositorio extends CrudRepository<Empleado, Integer> {


	
}
