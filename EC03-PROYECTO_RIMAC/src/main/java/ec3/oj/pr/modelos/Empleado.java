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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "empleado.findAll", query = "SELECT e FROM empleado e")
    , @NamedQuery(name = "empleado.findByIdEmpleado", query = "SELECT e FROM empleado e WHERE e.id = :id")
    , @NamedQuery(name = "empleado.findByIdTipo_Empleado", query = "SELECT e FROM empleado e WHERE e.id_tipo_empleado = :id_tipo_empleado")
    , @NamedQuery(name = "empleado.findByUsuario", query = "SELECT e FROM empleado e WHERE e.usuario = :usuario")
    , @NamedQuery(name = "empleado.findByContraseña", query = "SELECT e FROM empleado e WHERE e.contraseña = :contraseña")
    , @NamedQuery(name = "empleado.findByDNI", query = "SELECT e FROM empleado e WHERE e.dni = :dni")
    , @NamedQuery(name = "empleado.findByNombres", query = "SELECT e FROM empleado e WHERE e.nombres = :nombres")
    , @NamedQuery(name = "empleado.findByApellidos", query = "SELECT e FROM empleado e WHERE e.apellidos = :apellidos")
    , @NamedQuery(name = "empleado.findByCorreo", query = "SELECT e FROM empleado e WHERE e.correo = :correo")
    , @NamedQuery(name = "empleado.findByRol", query = "SELECT e FROM empleado e WHERE e.rol = :rol")
})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_tipo_empleado")
    private Integer id_tipo_empleado;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "dni")
    private String dni;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "correo")
    private String correo;
    @Column(name = "rol")
    private String rol;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado",fetch=FetchType.LAZY)
    @JsonBackReference(value="empleado_inspeccion")
    private List<Inspeccion> inspeccionesList;

    public Empleado() {
    }
    

    public Empleado(Integer id, Integer id_tipo_empleado) {
        this.id = id;
        this.id_tipo_empleado = id_tipo_empleado;
    }

    public Empleado(String usuario, String contraseña, String dni,String nombres,String apellidos
    		,String correo,String rol) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.dni = dni;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.correo=correo;
		this.rol=rol;
		
	}




    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId_tipo_empleado() {
		return id_tipo_empleado;
	}


	public void setId_tipo_empleado(Integer id_tipo_empleado) {
		this.id_tipo_empleado = id_tipo_empleado;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}

	@XmlTransient
	public List<Inspeccion> getInspeccionesList() {
		return inspeccionesList;
	}


	public void setInspeccionesList(List<Inspeccion> inspeccionesList) {
		this.inspeccionesList = inspeccionesList;
	}


	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec3.oj.pr.modelos.Empleado[ id=" + id + " ]";
    }

	public Empleado buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
