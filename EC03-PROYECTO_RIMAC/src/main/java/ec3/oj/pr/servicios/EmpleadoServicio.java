package ec3.oj.pr.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec3.oj.pr.modelos.Empleado;

import ec3.oj.pr.repositorios.rest.EmpleadoRestRepositorio;



@Service
@Transactional
public class EmpleadoServicio {

	@Autowired // Inyeccción de depencia
	private EmpleadoRestRepositorio repositorio;

	public EmpleadoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Empleado> buscarTodo() {
		return (List<Empleado>) repositorio.findAll();
	}
    
	//Metodo post
	public Empleado crear(Empleado empleado) {
		return repositorio.save(empleado);
	}
    
	//Metodo put
	public Empleado actualizar (Empleado empleadoActualizar) {
		
		
		Empleado empleadoActual= repositorio.findById(empleadoActualizar.getId()).get();
		
		empleadoActual.setId(empleadoActualizar.getId());
		empleadoActual.setUsuario(empleadoActualizar.getUsuario());
		empleadoActual.setContraseña(empleadoActualizar.getContraseña());
		empleadoActual.setNombres(empleadoActualizar.getNombres());
		empleadoActual.setApellidos(empleadoActualizar.getApellidos());
		empleadoActual.setDni(empleadoActualizar.getDni());
		empleadoActual.setCorreo(empleadoActualizar.getCorreo());
		empleadoActual.setRol(empleadoActualizar.getRol());
		
		Empleado empleadoActualizado = repositorio.save(empleadoActual);
		return empleadoActualizado;
	}
	
	public Empleado buscarPorId(Integer id) {
		
		return repositorio.findById(id).get();
		
	}
	
	public void eliminarPorId(Integer id) {
		repositorio.deleteById(id);
		
	}
	
	
	
}
