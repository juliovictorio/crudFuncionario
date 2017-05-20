package view;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.PessoaDAOImpl;

public class ListarController implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		try {
			request.setAttribute("funcionarios", new PessoaDAOImpl(entityManager).listar());
		} catch (DAOException e) {
			request.setAttribute("mensagem", "Erro ao obter lista de funcionarios");
			e.printStackTrace();
		}
		return "/listaFuncionarios.jsp";
	}

}
