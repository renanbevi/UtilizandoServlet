package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Acessos> ListaAcessos = new ArrayList<>();

	public void adiciona(Empresa empresa) {  //criação de um banco para guardar as informações das empresas em uma lista
		Banco.listaEmpresas.add(empresa);
		
	}
	
	public List<Empresa> getEmpresas(){  // Mostra todas as informações gravada na Lista das empresas
		return Banco.listaEmpresas;
	}

	public void adicionaAcessos(Acessos nomelogin, Acessos senhaLogin) {
		Banco.ListaAcessos.add(nomelogin);
		Banco.ListaAcessos.add(senhaLogin);
		
	
	}
	
	public List<Acessos> getAcessos(){
		return Banco.ListaAcessos;
	}

	
}
