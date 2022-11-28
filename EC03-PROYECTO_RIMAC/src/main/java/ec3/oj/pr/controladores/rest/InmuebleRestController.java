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

import ec3.oj.pr.modelos.Inmueble;
import ec3.oj.pr.servicios.InmuebleServicio;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/rest/inmuebles")
public class InmuebleRestController {

	@Autowired
	private InmuebleServicio servicio;
	
	@GetMapping
	public  ResponseEntity<Object> buscarTodo(){
		List<Inmueble> listainmuebles =  servicio.buscarTodo();
		
		System.out.println("LISTA DE INMUEBLES : " + listainmuebles);
		
		return new ResponseEntity<>(listainmuebles, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
		
		Inmueble tipo = servicio.buscarPorId(id);
		if(tipo == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Inmueble no encontrado, id  proporcionado no es correcto");
			 return new ResponseEntity<Object>(tipo, HttpStatus.OK);

	}
	
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Inmueble tipo){
		   servicio.crear(tipo);
		   return new ResponseEntity<Object>("Inmueble creado correctamente", HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Inmueble tipo){
		servicio.actualizar(tipo);
		return new ResponseEntity<Object>("Inmueble actualizado correctamente", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
		servicio.eliminarPorId(id);
		return new ResponseEntity<Object>("Inmueble eliminado correctamente", HttpStatus.OK);
		
	}
}
