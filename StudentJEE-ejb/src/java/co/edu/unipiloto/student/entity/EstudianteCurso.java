/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mateo
 */
@Entity
@Table(name = "ESTUDIANTE_CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudianteCurso.findAll", query = "SELECT e FROM EstudianteCurso e"),
    @NamedQuery(name = "EstudianteCurso.findByIdEstudiante", query = "SELECT e FROM EstudianteCurso e WHERE e.estudianteCursoPK.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "EstudianteCurso.findByCodigoCurso", query = "SELECT e FROM EstudianteCurso e WHERE e.estudianteCursoPK.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "EstudianteCurso.findByNota", query = "SELECT e FROM EstudianteCurso e WHERE e.nota = :nota")})
public class EstudianteCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudianteCursoPK estudianteCursoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTA")
    private Double nota;
    @JoinColumn(name = "CODIGO_CURSO", referencedColumnName = "CODIGO_CURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "ID_ESTUDIANTE", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public EstudianteCurso() {
    }

    public EstudianteCurso(EstudianteCursoPK estudianteCursoPK) {
        this.estudianteCursoPK = estudianteCursoPK;
    }

    public EstudianteCurso(int idEstudiante, String codigoCurso, double nota) {
        this.estudianteCursoPK = new EstudianteCursoPK(idEstudiante,codigoCurso);
        this.nota = nota;
        
    }

    public EstudianteCursoPK getEstudianteCursoPK() {
        return estudianteCursoPK;
    }

    public void setEstudianteCursoPK(EstudianteCursoPK estudianteCursoPK) {
        this.estudianteCursoPK = estudianteCursoPK;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteCursoPK != null ? estudianteCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteCurso)) {
            return false;
        }
        EstudianteCurso other = (EstudianteCurso) object;
        if ((this.estudianteCursoPK == null && other.estudianteCursoPK != null) || (this.estudianteCursoPK != null && !this.estudianteCursoPK.equals(other.estudianteCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.entity.EstudianteCurso[ estudianteCursoPK=" + estudianteCursoPK + " ]";
    }
    
}
