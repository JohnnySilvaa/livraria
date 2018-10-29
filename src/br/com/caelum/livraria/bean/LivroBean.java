package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@Model
public class LivroBean {
	
	private Livro livro = new Livro();
	private Integer autorId;
	
	
	@Inject
	private LivroService livroService; // AutorDao dao; // = new AutorDao();
	@Inject
	private AutorService autorService; // LivroDao dao; // = new AutorDao();

	
	public void cadastra() {
		
		Autor autor = this.autorService.pesquisar(autorId);
		this.livro.setAutor(autor);
		
		this.livroService.adiciona(livro);
		
		this.livro = new Livro();
	}

	public List<Autor> getAutores() {
		return autorService.todosAutores();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public List<Livro> getLivros() {
		return this.livroService.todosLivros();
	}
}
