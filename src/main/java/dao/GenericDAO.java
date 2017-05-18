package dao;

import java.util.Collection;

	/**
	 * 
	 * Interface para o GenericDAO
	 *
	 * @param <E>
	 * @param <K>
	 */
	public interface GenericDAO<E, K> {
		
		/**
		 * Metodo para inserir a classe de domínio
		 * @param entity
		 * @throws DAOException
		 */
	    void insere(E entity) throws DAOException;
	    
	    /**
	     * Metodo para atualizar a classe de domínio
	     * @param entity
	     * @throws DAOException
	     */
	    void atualiza(E entity) throws DAOException;
	    
	    /**
	     * Metodo para excluir a classe de dominio
	     * @param entity
	     * @throws DAOException
	     */
	    void exclui(E entity) throws DAOException;
	    
	    /**
	     * Metodo para recuperar a classe de domínio a partir de sua chave primaria
	     * @param id
	     * @return
	     * @throws DAOException
	     */
	    E recupera(K id) throws DAOException;
	    
	    /**
	     * Metodo para listar os registros da tabela mapeada pela classe de domínio
	     * @return
	     * @throws DAOException
	     */
	    Collection<E> listar() throws DAOException;
	    
}
