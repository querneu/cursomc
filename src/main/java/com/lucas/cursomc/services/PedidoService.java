package com.lucas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.cursomc.domain.Pedido;
import com.lucas.cursomc.repositories.PedidoRepository;
import com.lucas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id 
					+ "do tipo Tipo: "+Pedido.class.getName());
		}
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + " do Tipo: "+Pedido.class.getName()));
	}
}
