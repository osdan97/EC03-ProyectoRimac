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

import ec3.oj.pr.modelos.Empleado;
import ec3.oj.pr.servicios.EmpleadoServicio;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/rest/empleados")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoServicio servicio;
	
	@GetMapping
	public  ResponseEntity<Object> buscarTodo(){
		List<Empleado> listaempleados =  servicio.buscarTodo();
		
		System.out.println("LISTA DE EMPLEADOS : " + listaempleados);
		
		return new ResponseEntity<>(listaempleados, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
		
		Empleado tipo = servicio.buscarPorId(id);
		if(tipo == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Empleado no encontrado, id  proporcionado no es correcto");
			 return new ResponseEntity<Object>(tipo, HttpStatus.OK);

	}
	
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Empleado tipo){
		   servicio.crear(tipo);
		   return new ResponseEntity<Object>("Empleado creado correctamente", HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Empleado tipo){
		servicio.actualizar(tipo);
		return new ResponseEntity<Object>("Empleado actualizado correctamente", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
		servicio.eliminarPorId(id);
		return new ResponseEntity<Object>("Empleado eliminado correctamente", HttpStatus.OK);
		
	}
}
