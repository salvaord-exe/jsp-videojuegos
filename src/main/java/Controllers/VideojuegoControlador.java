package Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import Models.Videojuego;

/**
 * Servlet implementation class VideojuegoControlador
 */
public class VideojuegoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Videojuego oModel = new Videojuego();
	
    private String list = "Views/Videojuego/ListVideojuego.jsp?action=list";
    private String edit = "Views/Videojuego/EditVideojuego.jsp";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideojuegoControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String acceso = null;
		
		if(request.getParameter("action").equals("list")) {
			response.getWriter().append("Se detectó request: " + request.getParameter("action"));
			response.sendRedirect(request.getContextPath() + "/Views/Videojuego/ListVideojuego.jsp?action=list");
		}else if(request.getParameter("action").equals("delete")) {
			response.getWriter().append("Se detectó request: " + request.getParameter("action"));
			
			Videojuego varVid = new Videojuego();
			
			varVid.setId(Integer.parseInt(request.getParameter("id")));
			
			this.oModel.eliminar(varVid);
			
			response.sendRedirect(request.getContextPath() + "/Views/Videojuego/ListVideojuego.jsp?action=list");
		}
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acceso=null;
		if(request.getParameter("action").equals("create") || request.getParameter("action").equals("update")) {
			String actionRequest = request.getParameter("action").toString();
			
			response.getWriter().append("Se detectó request: " + request.getParameter("action"));
			
			Videojuego oVid = new Videojuego();
			
			
			
			oVid.setNombre(request.getParameter("nombre").toString());
			oVid.setFabricante(request.getParameter("fabricante").toString());
			
			String fecha_lanzamiento = (request.getParameter("fecha_lanzamiento").toString());
			
			LocalDate fechaLanzamiento = LocalDate.parse(fecha_lanzamiento);
			
			oVid.setFecha_lanzamiento(fechaLanzamiento);
			
			oVid.setVd_version(request.getParameter("vd_version").toString());
			
			double calificacion = Double.parseDouble(request.getParameter("calificacion"));
			
			oVid.setCalificacion(calificacion);
			
			double precio = Double.parseDouble(request.getParameter("precio"));
			
			oVid.setPrecio(precio);
			
			if(actionRequest.equals("create")) {
				this.oModel.Crear(oVid);
			}else {
				
				oVid.setId(Integer.parseInt(request.getParameter("id").toString()));
				System.out.println("Se manda a actualizar");
				
				System.out.println(this.oModel.actualizar(oVid)); 
			}
			
			
			
			acceso = this.list;
			
			
		}
		
		
		response.sendRedirect(request.getContextPath() + "/Views/Videojuego/ListVideojuego.jsp?action=list");
		
		
	}

}
