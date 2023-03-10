package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Cliente;


@WebServlet("/clientes")
public class ClientesService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	List<Cliente> clientes = new Banco().getClientes();
	
	
	String valor = request.getHeader("accept");
	
	if(valor.endsWith("xml")) { // endsWith cabeçalho terminando exemplo  site.com/xml termina com o XML site.com/json termina com a palavra json
	XStream xstream = new XStream();
	xstream.alias("cliente", Cliente.class); //formatação do xml 
	String xml = xstream.toXML(clientes);
	
	response.setContentType("application/xml");  //Definir o tipo de conteudo
	response.getWriter().print(xml);  //método para devolver string
	}else if(valor.endsWith("json")) {
		
		Gson gson = new Gson();
		String json = gson.toJson(clientes);
			 
		response.setContentType("application/json");  //Definir o tipo de conteudo
		response.getWriter().print(json);  //método para devolver string
		
	}else {
		response.setContentType("application/json");  //Definir o tipo de conteudo
		response.getWriter().print("{ Mensagem: Erro not found =D }");  //método para devolver string
	}
	
	
	 
		
	}

}
