package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTAMENTO")
public class Departamento implements Serializable{
	
	private static final long serialVersionUID = -545913726750613065L;

	@Id
	@SequenceGenerator(name="IDENTITY_DEPARTAMENTO", sequenceName="IDENTITY_DEPARTAMENTO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IDENTITY_DEPARTAMENTO")
	@Column(name = "ID")
	private long id;

	@OneToMany(mappedBy="departamento")
	private List<Funcionario> funcionarios;

	@Column(name="NOME_DEPARTAMENTO")
	private String nomeDepartamento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
}
