package view;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/Controller")
public class Controller extends HttpServlet {
    
	private static final long serialVersionUID = 7616184007340949927L;
	
	@PersistenceContext(name = "apiPU")
	protected EntityManager entityManager;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //VERIFICA SE O USUARIO ESTÁ LOGADO

        Command comando;
		try {
			comando = (Command) Class.forName("view."+request.getParameter("command")).newInstance();
			comando.execute(request, response, entityManager);        
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
