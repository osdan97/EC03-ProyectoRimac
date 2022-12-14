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
@Table(name = "inmueble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inmueble.findAll", query = "SELECT i FROM Inmueble i")
    , @NamedQuery(name = "Inmueble.findByIdInmueble", query = "SELECT i FROM Inmueble i WHERE i.id_inmueble = :id_inmueble")
    , @NamedQuery(name = "Inmueble.findByEstado", query = "SELECT i FROM Inmueble i WHERE i.estado = :estado")
    , @NamedQuery(name = "Inmueble.findByDelegacion_municipio", query = "SELECT i FROM Inmueble i WHERE i.delegacion_municipio = :delegacion_municipio")
    , @NamedQuery(name = "Inmueble.findByReferencia", query = "SELECT i FROM Inmueble i WHERE i.referencia = :referencia")
})
public class Inmueble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inmueble")
    private Integer id_inmueble;
    @Column(name = "estado")
    private String estado;
    @Column(name = "delegacion_municipio")
    private String delegacion_municipio;
    @Column(name = "referencia")
    private String referencia;
    @JoinColumn(name = "id_cliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente cliente;
  
    public Inmueble() {
    }
    

    public Inmueble(Integer id_inmueble) {
        this.id_inmueble = id_inmueble;
        
    }

    public Inmueble(Integer id_inmueble,String estado, String delegacion_municipio, String referencia) {
		super();
		this.id_inmueble = id_inmueble;
		this.estado = estado;
		this.delegacion_municipio = delegacion_municipio;
		this.referencia = referencia;
		
	}


	public Integer getId_inmueble() {
		return id_inmueble;
	}


	public void setId_inmueble(Integer id_inmueble) {
		this.id_inmueble = id_inmueble;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getDelegacion_municipio() {
		return delegacion_municipio;
	}


	public void setDelegacion_municipio(String delegacion_municipio) {
		this.delegacion_municipio = delegacion_municipio;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id_inmueble != null ? id_inmueble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inmueble)) {
            return false;
        }
        Inmueble other = (Inmueble) object;
        if ((this.id_inmueble == null && other.id_inmueble != null) || (this.id_inmueble != null && !this.id_inmueble.equals(other.id_inmueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec3.oj.pr.modelos.Inmueble[ id=" + id_inmueble + " ]";
    }

	public Inmueble buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
