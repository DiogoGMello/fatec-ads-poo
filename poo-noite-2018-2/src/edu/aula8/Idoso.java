package edu.aula8;

public class Idoso implements Assinante {
	private String nome;
	
	public Idoso(String nome) {
		this.nome = nome; 
	}
	
	@Override
	public void receberNoticia(String noticia) {
		System.out.println(nome + " no �nibus as 07h da manh� lendo a noticia " + noticia);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
