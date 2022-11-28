/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec3.oj.pr.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;



/**
 *
 * @author man
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByDNI", query = "SELECT c FROM Cliente c WHERE c.dni = :dni")
    , @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Cliente.findByCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo")
    , @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Cliente.findByNro_inmuebles", query = "SELECT c FROM Cliente c WHERE c.nro_inmuebles = :nro_inmuebles")
    })
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dni")
    private String dni;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "nro_inmuebles")
    private Integer nro_inmuebles;
    @JoinColumn(name = "id_tipo_empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleado;
    public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente",fetch=FetchType.LAZY)
    @JsonBackReference(value="cliente_inmueble")
    private List<Inmueble> inmueblesList;

    public Cliente() {
    }
    

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
        
    }

    public Cliente(String nombre, String dni, String correo,String telefono,String direccion,Integer nro_inmuebles) {
		super();
		
		this.nombre = nombre;
		this.dni = dni;
		this.correo = correo;
		this.telefono=telefono;
		this.direccion=direccion;
		this.nro_inmuebles=nro_inmuebles;
		
	}


    public Integer getIdcliente() {
		return idcliente;
	}


	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Integer getNro_inmuebles() {
		return nro_inmuebles;
	}


	public void setNro_inmuebles(Integer nro_inmuebles) {
		this.nro_inmuebles = nro_inmuebles;
	}

	@XmlTransient
	public List<Inmueble> getInmueblesList() {
		return inmueblesList;
	}


	public void setInmueblesList(List<Inmueble> inmueblesList) {
		this.inmueblesList = inmueblesList;
	}


	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec3.oj.pr.modelos.Cliente[ id=" + idcliente + " ]";
    }

	public Cliente buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
