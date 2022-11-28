package ec3.oj.pr.controladores.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ec3.oj.pr.modelos.Cliente;
import ec3.oj.pr.servicios.ClienteServicio;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/rest/clientes")
public class ClienteRestController {

	@Autowired
	private ClienteServicio servicio;
	
	@GetMapping
	public  ResponseEntity<Object> buscarTodo(){
		List<Cliente> listaclientes =  servicio.buscarTodo();
		
		System.out.println("LISTA DE clientes : " + listaclientes);
		
		return new ResponseEntity<>(listaclientes, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
		
		Cliente tipo = servicio.buscarPorId(id);
		if(tipo == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Cliente no encontrado, id  proporcionado no es correcto");
			 return new ResponseEntity<Object>(tipo, HttpStatus.OK);

	}
	
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Cliente tipo){
		   servicio.crear(tipo);
		   return new ResponseEntity<Object>("Cliente creado correctamente", HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Cliente tipo){
		servicio.actualizar(tipo);
		return new ResponseEntity<Object>("Cliente actualizado correctamente", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
		servicio.eliminarPorId(id);
		return new ResponseEntity<Object>("Cliente eliminado correctamente", HttpStatus.OK);
		
	}
}
