package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaempresasServlet
 */
@WebServlet("/listaEmpresas")
public class ListaempresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListaempresasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		List<Acessos> listaAcessos = banco.getAcessos();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		out.println("<ul>");
		
		
		for(Empresa empresa : lista) {
			out.println("<li>" + empresa.getNome() + "</li>");
		}
		
		for (Acessos acessos : listaAcessos) {
			out.println("<li>" + acessos.getAdmin() + "" + acessos.getSenha() + "</li>");
		}
		
		out.println("</ul>");
		out.println("</body></html>");
	}

}
