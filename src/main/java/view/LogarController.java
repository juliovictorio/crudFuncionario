package view;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import model.Pessoa;

@Stateless
public class LogarController implements Command {

	private PessoaDAO pessoaDAO;
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		Pessoa pessoa = null;
		pessoaDAO = new PessoaDAOImpl(entityManager);
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		String mensagem = "";
		String page = "/listaFuncionarios.jsp";
		try {
			Pessoa usuarioLogado = pessoaDAO.getPessoaByLoginSenha(email,Pessoa.criptografaSenha(senha));
			if (usuarioLogado == null) {
				mensagem = "Login ou senha incorreta!";
				page = "/login.jsp";
			}else{
				request.getSession().setAttribute("usuarioLogado", usuarioLogado);
				request.setAttribute("funcionarios", pessoaDAO.listar());
			}
		} catch (DAOException e) {
			e.printStackTrace();
			mensagem = "Ocorreu um erro ao efetuar o login: " +e.getMessage();
		}
		
		request.setAttribute("mensagem", mensagem);
		return page;
	}

	
}
