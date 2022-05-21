package Urbex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UsuarioServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado="";
		try {
			resultado = DBprueba.selectUsuario(request.getParameter("usuario"));
		} catch (Exception e) {
			System.out.println("Error en descargar la tabla");
		} 
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultado);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBprueba.enviarUsuario(request.getParameter("usuario"), request.getParameter("correo"), request.getParameter("contraseña"));
		} catch (Exception e) {
			System.out.println("Error al insertar el usuario");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		
	}

}
