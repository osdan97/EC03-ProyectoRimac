package ec3.oj.pr.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ec3.oj.pr.modelos.Tipo_empleado;
import ec3.oj.pr.servicios.Tipo_empleadoServicio;


@Controller
@RequestMapping("/tipo_empleado")
public class Tipo_empleadoRimacController {

	@Autowired
	private Tipo_empleadoServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarTipos_empleados(Model model) {
		List<Tipo_empleado> listaTipos_empleados = servicio.buscarTodo();
		
		System.out.println("LISTA DE TIPOS DE EMPLEADOS : " + listaTipos_empleados);
		
		model.addAttribute("listaTipos_empleados", listaTipos_empleados);
		return "/moduloTipo_empleado/listarTodo";
	}
	

	@RequestMapping("/nuevo")
	public String nuevoTipo_empleado(Model model) {
		Tipo_empleado tipo_empleado = new Tipo_empleado();
		model.addAttribute("tipo_empleado", tipo_empleado);
		return "/moduloTipo_empleado/nuevoTipo_empleado";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearTipo_empleado(@ModelAttribute("tipo_empleado") Tipo_empleado tipo_empleado) {
		    servicio.crear(tipo_empleado);
		    return "redirect:/tipo_empleado/listarTodo";
	
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarPelicula(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloTipo_empleado/editarTipo_empleado");
	    Tipo_empleado tipo_empleado = servicio.buscarPorId(id);
	    mav.addObject("tipo_empleado", tipo_empleado);
	    return mav;
	}
	
	
	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarTipo_empleado(@PathVariable(name = "id") int id) {
		  servicio.eliminarPorId(id);
		 return "redirect:/tipo_empleado/listarTodo";
		
	}
	
	
	
}
	
	
	
	
	
	
	
