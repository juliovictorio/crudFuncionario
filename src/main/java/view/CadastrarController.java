package view;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.SecretariaDAO;
import dao.SecretariaDAOImpl;
import model.Secretaria;

@Stateless
public class CadastrarController implements Command {

	
	//@Inject
	private SecretariaDAO secretariaDAO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		Secretaria secretaria = new Secretaria();
		secretariaDAO = new SecretariaDAOImpl(entityManager);
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		secretaria.setNome(nome);
		secretaria.setEmail(email);
		
		try {
			secretariaDAO.insere(secretaria);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return "";
	}

}
