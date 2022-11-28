package ec3.oj.pr.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec3.oj.pr.modelos.Tipo_empleado;

import ec3.oj.pr.repositorios.rest.Tipo_empleadoRestRepositorio;



@Service
@Transactional
public class Tipo_empleadoServicio {

	@Autowired // Inyeccción de depencia
	private Tipo_empleadoRestRepositorio repositorio;

	public Tipo_empleadoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Tipo_empleado> buscarTodo() {
		return (List<Tipo_empleado>) repositorio.findAll();
	}
    
	//Metodo post
	public Tipo_empleado crear(Tipo_empleado tipo_empleado) {
		return repositorio.save(tipo_empleado);
	}
    
	//Metodo put
	public Tipo_empleado actualizar (Tipo_empleado tipo_empleadoActualizar) {
		
		
		Tipo_empleado tipo_empleadoActual= repositorio.findById(tipo_empleadoActualizar.getId()).get();
		
		tipo_empleadoActual.setId(tipo_empleadoActualizar.getId());
		tipo_empleadoActual.setClase_empleado(tipo_empleadoActualizar.getClase_empleado());
		tipo_empleadoActual.setArea_empleo(tipo_empleadoActualizar.getArea_empleo());
		tipo_empleadoActual.setSalario_dolares(tipo_empleadoActualizar.getSalario_dolares());
		tipo_empleadoActual.setSalario_soles(tipo_empleadoActualizar.getSalario_soles());
		
		Tipo_empleado tipo_empleadoActualizado = repositorio.save(tipo_empleadoActual);
		return tipo_empleadoActualizado;
	}
	
	public Tipo_empleado buscarPorId(Integer id) {
		
		return repositorio.findById(id).get();
		
	}
	
	public void eliminarPorId(Integer id) {
		repositorio.deleteById(id);
		
	}
	
	
	
}
