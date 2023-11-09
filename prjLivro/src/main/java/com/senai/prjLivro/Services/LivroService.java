package com.senai.prjLivro.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.prjLivro.Entities.Livro;

import com.senai.prjLivro.Repositories.LivroRepository;

@Service
public class LivroService {
	private final LivroRepository livroRepository;

	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro getLivroById(Long idLivro) {
		return livroRepository.findById(idLivro).orElse(null);
	}

	public List<Livro> getAllLivros() {
		return livroRepository.findAll();
	}
	
	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}

	public void deleteLivro(Long idLivro) {
		livroRepository.deleteById(idLivro);
	}
	
		public Livro updateLivro(Long idLivro, Livro novolivro) {
			Optional<Livro> livroOptional = livroRepository.findById(idLivro);
	        if (livroOptional.isPresent()) {
	        	Livro livroExistente = livroOptional.get();
	           	livroExistente.setdescricao(novolivro.getdescricao());
	        	livroExistente.setISBN(novolivro.getISBN());          
	            return livroRepository.save(livroExistente); 
	        } else {
	            return null; 
	        }
	    }
}