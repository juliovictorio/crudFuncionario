package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import model.Pessoa;
import model.Secretaria;

public class PessoaDAOImpl extends GenericDAOImpl<Pessoa, Long> implements PessoaDAO{

	public PessoaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Pessoa getPessoaByLoginSenha(String email, String senha) throws DAOException {
		Pessoa pessoa;
		try {
			pessoa = entityManager.createQuery("FROM Pessoa p where p.email = :email and p.senha = :senha", Pessoa.class)
					.setParameter("email", email)
					.setParameter("senha", senha)
					.getSingleResult();
		} catch (NoResultException n) {
			return null;
		}
		
		return pessoa;
	}

}
