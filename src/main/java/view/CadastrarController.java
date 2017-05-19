package view;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import model.Departamento;
import model.Funcionario;
import model.Gerente;
import model.PeriodoTrabalho;
import model.Pessoa;
import model.Secretaria;

@Stateless
public class CadastrarController implements Command {

	private PessoaDAO secretariaDAO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		Funcionario funcionario = null;
		String tipoFuncionario = request.getParameter("tipoFuncionario");
		if ("GERENTE".equals(tipoFuncionario)) {
			funcionario = new Gerente();
			((Gerente)funcionario).setBonificacao(Double.valueOf(request.getParameter("bonificacao")));;
		}else{
			 funcionario = new Secretaria();
			 ((Secretaria)funcionario).setFalaIngles(Boolean.valueOf(request.getParameter("falaIngles")));
			 ((Secretaria)funcionario).setPeridoTrabalho(PeriodoTrabalho.valueOf(request.getParameter("periodoTrabalho")));
		}
		secretariaDAO = new PessoaDAOImpl(entityManager);
		
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setEmail(request.getParameter("email"));
		funcionario.setSenha(request.getParameter("senha"));
		funcionario.setSalario(Double.valueOf(request.getParameter("salario")));
		funcionario.setDepartamento(new Departamento(Long.valueOf(request.getParameter("departamento"))));
		funcionario.setDataAdmissao(new Date());
		funcionario.setMatricula(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)+System.currentTimeMillis()));
		
		String mensagem = "Cadastro efetuado com sucesso!";
		
		try {
			secretariaDAO.insere(funcionario);
		} catch (DAOException e) {
			e.printStackTrace();
			mensagem = "Ocorreu um erro ao efetuar o cadastro: " +e.getMessage();
		}
		
		request.setAttribute("mensagem", mensagem);
		return "/cadastro.jsp";
	}

}
