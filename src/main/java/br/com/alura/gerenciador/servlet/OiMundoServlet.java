package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//oi na URL
@WebServlet(urlPatterns ="/oi")     //definir a URL
public class OiMundoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter(); // devolver um conteudo HTML binário
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Oi mundo parabéns</h1>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
