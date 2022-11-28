
package ec3.oj.pr.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ec3.oj.pr.modelos.Cliente;



public interface ClienteRepositorio extends CrudRepository<Cliente, Integer> {


	
}
