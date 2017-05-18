package dao;

import javax.persistence.EntityManager;

import model.Secretaria;

public class SecretariaDAOImpl extends GenericDAOImpl<Secretaria, Long> implements SecretariaDAO{

	public SecretariaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
