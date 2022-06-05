package Urbex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComprobarUsuario
 */
@WebServlet("/ComprobarUsuario")
	public class ComprobarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado="";
		try {
			resultado = DBcomprobarUsuario.getSelector();
		} catch (Exception e) {
			System.out.println(e);
		} 
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultado);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		
		String res = null;
		
		try {
			if (DBcomprobarUsuario.comprobarUsuario(username, contrasena)) {
				res = "Usuario logeado correctamente ";
				System.out.println("usuario existe");
			} else {
				res = "Usuario No existe ";
				System.out.println("usuario NO existe");
			}

		} catch (Exception e) {
			res = "Fallo interno";
			System.out.println(e.getMessage());

		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(res);
	}
	
	

}
