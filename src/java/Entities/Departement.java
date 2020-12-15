/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohamed
 */
@Entity
@Table(name = "departement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
    @NamedQuery(name = "Departement.findByIdDept", query = "SELECT d FROM Departement d WHERE d.idDept = :idDept"),
    @NamedQuery(name = "Departement.findByNom", query = "SELECT d FROM Departement d WHERE d.nom = :nom")})
public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DEPT")
    private String idDept;
    @Column(name = "NOM")
    private String nom;
    @OneToMany(mappedBy = "refDept")
    private List<Employe> employeList;

    public Departement() {
    }

    public Departement(String idDept) {
        this.idDept = idDept;
    }
    public Departement(String idDept,String nom) {
        this.idDept = idDept;
        this.nom = nom ;
    }
    public String getIdDept() {
        return idDept;
    }

    public void setIdDept(String idDept) {
        this.idDept = idDept;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Employe> getEmployeList() {
        return employeList;
    }

    public void setEmployeList(List<Employe> employeList) {
        this.employeList = employeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDept != null ? idDept.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.idDept == null && other.idDept != null) || (this.idDept != null && !this.idDept.equals(other.idDept))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Departement[ idDept=" + idDept + " ]";
    }
    
}
