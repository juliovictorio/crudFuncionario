package view;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import model.Pessoa;

@WebServlet(value="/Controller")
@Transactional
public class Controller extends HttpServlet {
    
	private static final long serialVersionUID = 7616184007340949927L;
	
	@PersistenceContext(name = "apiPU")
	protected EntityManager entityManager;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command comando;
        Pessoa usuarioLogado;
        String page = null;
		try {
			Object usuario = request.getSession().getAttribute("usuarioLogado");
			String command = request.getParameter("command");
			if (usuario == null && !("LogarController".equals(command))) {
				page = "/login.jsp";
			}else if("DeslogarController".equals(command)){
				page = "/login.jsp";
				request.getSession().removeAttribute("usuarioLogado");
			}else{
				comando = (Command) Class.forName("view."+command).newInstance();
				page = comando.execute(request, response, entityManager);
			}
			getServletContext().getRequestDispatcher(page).forward(request, response);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
