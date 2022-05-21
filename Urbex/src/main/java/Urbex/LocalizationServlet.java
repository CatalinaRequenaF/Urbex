package Urbex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocalizationServlet
 */
@WebServlet("/LocalizationServlet")
public class LocalizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalizationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado="";
		try {
			resultado = BDlocalization.selectLocalization(request.getParameter("localization"));
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
			BDlocalization.enviarlocalization(request.getParameter("lat"), request.getParameter("lon"));
		} catch (Exception e) {
			System.out.println("Error al insertar el usuario");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
	}	

}
