package view;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.DepartamentoDAOImpl;
import dao.DepartamentoDao;
import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import model.Gerente;
import model.Pessoa;

public class EditarController implements Command{
	private PessoaDAO pessoaDAO;
	private DepartamentoDao departamentoDAO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		String mensagem = null;
		try {
			pessoaDAO = new PessoaDAOImpl(entityManager);
			departamentoDAO = new DepartamentoDAOImpl(entityManager);
			
			Pessoa funcionario = pessoaDAO.recupera(Long.valueOf(request.getParameter("idFuncionario")));
			request.setAttribute("departamentos",departamentoDAO.listar());
			request.setAttribute("funcionario",funcionario);
			
			request.setAttribute("tipoFuncionario", funcionario instanceof Gerente ? "GERENTE" : "SECRETARIA");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mensagem = "Id do funcionario inválido";
		} catch (DAOException e) {
			mensagem = "Erro ao acessar a base de dados";
			e.printStackTrace();
		}
		
		request.setAttribute("mensagem", mensagem);
		return "/cadastro.jsp";
	}

}
