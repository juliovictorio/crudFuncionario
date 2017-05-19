package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public abstract class Funcionario extends Pessoa {
	
	@ManyToOne
    @JoinColumn(name="ID_DEPARTAMENTO")
	private Departamento departamento;
	
	@Column(name="DATA_ADMISSAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAdmissao;
	
	@Column(name="SALARIO")
	private Double salario;
	
	@Column(name="MATRICULA")
	private String matricula;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
