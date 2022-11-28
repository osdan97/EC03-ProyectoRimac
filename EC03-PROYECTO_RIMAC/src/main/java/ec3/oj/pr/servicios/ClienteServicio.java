package ec3.oj.pr.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec3.oj.pr.modelos.Cliente;

import ec3.oj.pr.repositorios.rest.ClienteRestRepositorio;



@Service
@Transactional
public class ClienteServicio {

	@Autowired // Inyeccción de depencia
	private ClienteRestRepositorio repositorio;

	public ClienteServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Cliente> buscarTodo() {
		return (List<Cliente>) repositorio.findAll();
	}
    
	//Metodo post
	public Cliente crear(Cliente cliente) {
		return repositorio.save(cliente);
	}
    
	//Metodo put
	public Cliente actualizar (Cliente clienteActualizar) {
		
		
		Cliente clienteActual= repositorio.findById(clienteActualizar.getIdcliente()).get();
		
		clienteActual.setIdcliente(clienteActualizar.getIdcliente());
		clienteActual.setNombre(clienteActualizar.getNombre());
		clienteActual.setDni(clienteActualizar.getDni());
		clienteActual.setDireccion(clienteActualizar.getDireccion());
		clienteActual.setTelefono(clienteActualizar.getTelefono());
		clienteActual.setNro_inmuebles(clienteActualizar.getNro_inmuebles());
		
		
		Cliente clienteActualizado = repositorio.save(clienteActual);
		return clienteActualizado;
	}
	
	public Cliente buscarPorId(Integer id) {
		
		return repositorio.findById(id).get();
		
	}
	
	public void eliminarPorId(Integer id) {
		repositorio.deleteById(id);
		
	}
	
	
	
}
