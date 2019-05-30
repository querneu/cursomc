package com.lucas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.cursomc.domain.Cliente;
import com.lucas.cursomc.repositories.ClienteRepository;
import com.lucas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id 
					+ "do tipo Tipo: "+Cliente.class.getName());
		}
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + " do Tipo: "+Cliente.class.getName()));
	}
}
