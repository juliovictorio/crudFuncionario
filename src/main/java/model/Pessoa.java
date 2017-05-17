package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PESSOA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_PESSOA", discriminatorType = DiscriminatorType.STRING)
public abstract class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 4176763578348023841L;
	
	@Id
	@SequenceGenerator(name="IDENTITY_PESSOA", sequenceName="IDENTITY_PESSOA", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IDENTITY_PESSOA")
	@Column(name = "ID")
	private long id;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "SENHA")
	private String senha;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
