package dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.transaction.Transactional;

@Transactional
public class GenericDAOImpl<E, K> implements GenericDAO<E, K> {

	protected EntityManager entityManager;
	
	public GenericDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void insere(E entity) throws DAOException {
		entityManager.persist(entity);		
		entityManager.flush();
	}

	@Override
	@Transactional
	public void atualiza(E entity) throws DAOException {
		entityManager.merge(entity);
	}

	@Override
	public void exclui(E entity) throws DAOException {
		entityManager.remove(entity);
	}

	@Override
	public E recupera(K id) throws DAOException {
		return entityManager.find(getTypeClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<E> listar() throws DAOException {
		return entityManager.createQuery("FROM " + getTypeClass().getName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	private Class<E> getTypeClass() {
		return (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
