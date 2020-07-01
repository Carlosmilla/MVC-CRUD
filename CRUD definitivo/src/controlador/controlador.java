package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.persona;
import modelo.personaDAO;

@WebServlet("/controlador")
public class controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	personaDAO pdao = new personaDAO();
	persona p = new persona();

    public controlador() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		switch (accion) {
		case "listar":
			List<persona>datos=pdao.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		case "nuevo":
			request.getRequestDispatcher("agregar.jsp").forward(request, response);
			break;
		case "guardar":
			String id=request.getParameter("txtid");
			String nom=request.getParameter("txtnom");
			p.setId(id);
			p.setNombre(nom);
			pdao.agregar(p);
			request.getRequestDispatcher("controlador?accion=listar").forward(request, response);
			break;
		case "editar":
			String ide=request.getParameter("id");
			persona pe = pdao.listarId(ide);
			
			request.setAttribute("persona", p);
			request.getRequestDispatcher("editar.jsp").forward(request, response);
			break;
		case "actualizar":
			String id1=request.getParameter("txtid");
			String nom1 = request.getParameter("txtnom");
			p.setId(id1);
			p.setNombre(nom1);
			pdao.actualizar(p);
			request.getRequestDispatcher("controlador?accion=listar").forward(request, response);
			break;
		case "eliminar":
			String id2 = request.getParameter("id");
			pdao.eliminar(id2);
			request.getRequestDispatcher("controlador?accion=listar").forward(request, response);
			break;
			default:
				throw new AssertionError();
		}
	}

}
