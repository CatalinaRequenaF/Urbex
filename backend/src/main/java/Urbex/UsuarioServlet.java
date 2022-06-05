package Urbex;

import java.io.IOException;
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
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado="";
		try {
			resultado = DBusuario.selectUsuario(request.getParameter("usuario"));
		} catch (Exception e) {
			System.out.println("ok");
			System.out.println("Error en descargar la tabla." + e.getMessage());
		} 
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultado);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBusuario.enviarUsuario(
					request.getParameter("usuario"), 
					request.getParameter("email"), 
					request.getParameter("contrasena"));
					
					
			
			
		} catch (Exception e) {
			
			System.out.println("Error al insertar usuario: "+e.getMessage());
			response.getWriter().append("Este usuario ya existe.");
			
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
	
	}
	
	

}
