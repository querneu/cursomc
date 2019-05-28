package com.lucas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.cursomc.domain.Categoria;
import com.lucas.cursomc.repositories.CategoriaRepository;
import com.lucas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id 
					+ "do tipo Tipo: "+Categoria.class.getName());
		}
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + " do Tipo: "+Categoria.class.getName()));
	}
}
