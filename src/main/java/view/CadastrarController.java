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

	private PessoaDAO pessoaDAO;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		Funcionario funcionario = null;
		String mensagem = "Cadastro efetuado com sucesso!";
		boolean edicao = false;

		try {
			String tipoFuncionario = request.getParameter("tipoFuncionario");
			pessoaDAO = new PessoaDAOImpl(entityManager);
			String idFuncionario = request.getParameter("idFuncionario");
			if (idFuncionario != null && !idFuncionario.equals("")) {
				funcionario = (Funcionario) pessoaDAO.recupera(Long.valueOf(idFuncionario));
				edicao = true;
			}else{
				if ("GERENTE".equals(tipoFuncionario)) {
					funcionario = new Gerente();
					((Gerente) funcionario).setBonificacao(Double.valueOf(request.getParameter("bonificacao")));
				} else {
					funcionario = new Secretaria();
					((Secretaria) funcionario).setFalaIngles(Boolean.valueOf(request.getParameter("falaIngles")));
					((Secretaria) funcionario)
					.setPeridoTrabalho(PeriodoTrabalho.valueOf(request.getParameter("periodoTrabalho")));
				}
			}
			

			funcionario.setNome(request.getParameter("nome"));
			funcionario.setEmail(request.getParameter("email"));
			funcionario.setSalario(Double.valueOf(request.getParameter("salario")));
			funcionario.setDepartamento(new Departamento(Long.valueOf(request.getParameter("departamento"))));
			funcionario.setDataAdmissao(new Date());
			funcionario.setMatricula(
					String.valueOf(Calendar.getInstance().get(Calendar.YEAR) + System.currentTimeMillis()));

			if (edicao) {
				pessoaDAO.atualiza(funcionario);
			}else{
				funcionario.setSenha(request.getParameter("senha"));
				pessoaDAO.insere(funcionario);
			}
		} catch (DAOException e) {
			e.printStackTrace();
			mensagem = "Ocorreu um erro ao efetuar o cadastro: " + e.getMessage();
		}

		request.setAttribute("mensagem", mensagem);
		return "/cadastro.jsp";
	}

}
