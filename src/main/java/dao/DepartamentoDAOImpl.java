package dao;

import javax.persistence.EntityManager;

import model.Departamento;

public class DepartamentoDAOImpl extends GenericDAOImpl<Departamento, Long> implements DepartamentoDao{

	public DepartamentoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
