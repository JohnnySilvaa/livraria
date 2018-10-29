package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;


@Stateless
public class LivroService {
	
	@Inject
    LivroDao dao;

    public void adiciona(Livro livro){
        this.dao.salva(livro);
        
    }
    
    public List<Livro> todosLivros() {
        return this.dao.todosLivros();
    }

}
