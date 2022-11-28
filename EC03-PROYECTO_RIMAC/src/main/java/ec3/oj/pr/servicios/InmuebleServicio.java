package ec3.oj.pr.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec3.oj.pr.modelos.Inmueble;

import ec3.oj.pr.repositorios.rest.InmuebleRestRepositorio;



@Service
@Transactional
public class InmuebleServicio {

	@Autowired // Inyeccción de depencia
	private InmuebleRestRepositorio repositorio;

	public InmuebleServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Inmueble> buscarTodo() {
		return (List<Inmueble>) repositorio.findAll();
	}
    
	//Metodo post
	public Inmueble crear(Inmueble inmueble) {
		return repositorio.save(inmueble);
	}
    
	//Metodo put
	public Inmueble actualizar (Inmueble inmuebleActualizar) {
		
		
		Inmueble inmuebleActual= repositorio.findById(inmuebleActualizar.getId_inmueble()).get();
		
		inmuebleActual.setId_inmueble(inmuebleActualizar.getId_inmueble());
		inmuebleActual.setEstado(inmuebleActualizar.getEstado());
		inmuebleActual.setDelegacion_municipio(inmuebleActualizar.getDelegacion_municipio());
		inmuebleActual.setReferencia(inmuebleActualizar.getReferencia());
		
		
		Inmueble InmuebleActualizado = repositorio.save(inmuebleActual);
		return InmuebleActualizado;
	}
	
	public Inmueble buscarPorId(Integer id_inmueble) {
		
		return repositorio.findById(id_inmueble).get();
		
	}
	
	public void eliminarPorId(Integer id_inmueble) {
		repositorio.deleteById(id_inmueble);
		
	}
	
	
	
}
