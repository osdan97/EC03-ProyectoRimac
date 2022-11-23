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
@Table(name = "tipo_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo_empleado.findAll", query = "SELECT t FROM tipo_empleado t")
    , @NamedQuery(name = "Tipo_empleado.findByIdTipo_empleado", query = "SELECT t FROM tipo_empleado t WHERE t.id = :id")
    , @NamedQuery(name = "Tipo_empleado.findClase_empleado", query = "SELECT t FROM tipo_empleado t WHERE t.clase_empleado = :clase_empleado")
    , @NamedQuery(name = "Tipo_empleado.findByArea_empleo", query = "SELECT t FROM tipo_empleado t WHERE t.area_empleo = :area_empleo")
    , @NamedQuery(name = "Tipo_empleado.findBySalario_soles", query = "SELECT t FROM tipo_empleado t WHERE t.salario_soles = :salario_soles")
    , @NamedQuery(name = "Tipo_empleado.findBySalario_dolares", query = "SELECT t FROM tipo_empleado t WHERE t.salario_dolares = :salario_dolares")
    })
public class Tipo_empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "clase_empleado")
    private String clase_empleado;
    @Column(name = "area_empleo")
    private String area_empleo;
    @Column(name = "salario_soles")
    private Integer salario_soles;
    @Column(name = "salario_dolares")
    private Integer salario_dolares;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_empleado",fetch=FetchType.LAZY)
    @JsonBackReference(value="tipo_empleado_funcionario")
    private List<Empleado> empleadosList;

    public Tipo_empleado() {
    }
    

    public Tipo_empleado(Integer id, String clase_empleado) {
        this.id = id;
        this.clase_empleado = clase_empleado;
    }

    public Tipo_empleado(String area_empleo, Integer salario_soles, Integer salario_dolares) {
		super();
		this.area_empleo = area_empleo;
		this.salario_soles = salario_soles;
		this.salario_dolares = salario_dolares;
		
	}


    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getClase_empleado() {
		return clase_empleado;
	}


	public void setClase_empleado(String clase_empleado) {
		this.clase_empleado = clase_empleado;
	}


	public String getArea_empleo() {
		return area_empleo;
	}


	public void setArea_empleo(String area_empleo) {
		this.area_empleo = area_empleo;
	}


	public Integer getSalario_soles() {
		return salario_soles;
	}


	public void setSalario_soles(Integer salario_soles) {
		this.salario_soles = salario_soles;
	}


	public Integer getSalario_dolares() {
		return salario_dolares;
	}


	public void setSalario_dolares(Integer salario_dolares) {
		this.salario_dolares = salario_dolares;
	}

	@XmlTransient
	public List<Empleado> getEmpleadosList() {
		return empleadosList;
	}


	public void setEmpleadosList(List<Empleado> empleadosList) {
		this.empleadosList = empleadosList;
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
        if (!(object instanceof Tipo_empleado)) {
            return false;
        }
        Tipo_empleado other = (Tipo_empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec3.oj.pr.modelos.Tipo_empleado[ id=" + id + " ]";
    }

	public Tipo_empleado buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
