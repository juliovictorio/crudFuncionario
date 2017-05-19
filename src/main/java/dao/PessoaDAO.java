package dao;

import model.Pessoa;
import model.Secretaria;

public interface PessoaDAO extends GenericDAO<Pessoa, Long>{
	
	Pessoa getPessoaByLoginSenha(String email, String senha) throws DAOException;

}
