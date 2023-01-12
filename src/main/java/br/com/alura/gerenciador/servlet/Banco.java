package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Banco {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Empresa> listaCnpj = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Ai papaizinho");
		empresa.setCnpj("1948393000100");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Chamaaaa");
		empresa2.setCnpj("1948393000144");
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
		
	}
	
	
	
	public void adiciona(Empresa empresa) {  //criação de um banco para guardar as informações das empresas em uma lista
		empresa.setId(Banco.chaveSequencial);
		Banco.listaEmpresas.add(empresa);
		
	}
	
	public List<Empresa> getEmpresas(){  // Mostra todas as informações gravada na Lista das empresas
		return Banco.listaEmpresas;
	}

	public void adicionaCnpj(Empresa cnpj) {
		Banco.listaCnpj.add(cnpj);
	}
	
	public List<Empresa> getCnpj() {
		return Banco.listaCnpj;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = listaEmpresas.iterator();
		
		while (it.hasNext()) { //tem o proximo elemento?
			Empresa emp = it.next(); // me dá o proximo elemento
			if(emp.getId() == id) {
				it.remove();
			}
			
		}
	}
		public Empresa buscaEmpresaPelaId(Integer id) {
			for (Empresa empresa : listaEmpresas) {
				if(empresa.getId() == id) {
					return empresa;
				}
			}	
			return null;
		
				
		}
	
}

