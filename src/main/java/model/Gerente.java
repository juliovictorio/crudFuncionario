package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="GERENTE")
@DiscriminatorValue("GERENTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Gerente extends Funcionario {

	@Column(name="BONIFICACAO")
	private double bonificacao;

	public double getBonificacao() {
		return bonificacao;
	}

	public void setBonificacao(double bonificacao) {
		this.bonificacao = bonificacao;
	}
	
}
