package view;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.DepartamentoDAOImpl;
import dao.DepartamentoDao;
import model.Departamento;

public class AbrirCadastroController implements Command {

	private DepartamentoDao departamentoDAO;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		departamentoDAO = new DepartamentoDAOImpl(entityManager);

		try {
			request.setAttribute("departamentos",departamentoDAO.listar());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "/cadastro.jsp";
	}

}
