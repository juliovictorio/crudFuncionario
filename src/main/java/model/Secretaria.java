package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("SECRETARIA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Secretaria extends Funcionario{
	
	@Column(name="PERIODO_TRABALHO")
	@Enumerated(EnumType.STRING)
	private PeriodoTrabalho peridoTrabalho;
	
	@Column(name="FALA_INGLES")
	private boolean falaIngles;

	public PeriodoTrabalho getPeridoTrabalho() {
		return peridoTrabalho;
	}

	public void setPeridoTrabalho(PeriodoTrabalho peridoTrabalho) {
		this.peridoTrabalho = peridoTrabalho;
	}

	public boolean isFalaIngles() {
		return falaIngles;
	}

	public void setFalaIngles(boolean falaIngles) {
		this.falaIngles = falaIngles;
	}
}
