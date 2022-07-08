package com.daniel.os.entrypoint;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.daniel.os.core.business.ClienteBusiness;
import com.daniel.os.core.domain.Cliente;
import com.daniel.os.entrypoint.httpmodel.ClienteHttpModel;
import com.daniel.os.entrypoint.mapper.ClienteHttpModelMapper;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteEntryPoint {

	@Autowired
	private ClienteBusiness clienteBusiness;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id ){
		Cliente clientes = clienteBusiness.findById(id);
		return ResponseEntity.ok().body(clientes);
		
	}
	
	@GetMapping
	public ResponseEntity<Cliente> findAll(){
		Cliente cliente = clienteBusiness.findAll();
		return ResponseEntity.ok().body(cliente);
		
	}

	@PostMapping
	public ResponseEntity<ClienteHttpModel> insert(@Valid @RequestBody ClienteHttpModel clienteHttpModel) {
		Cliente cliente = clienteBusiness.cadastrarCliente(ClienteHttpModelMapper.to(clienteHttpModel));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteHttpModel> update (@PathVariable("id") Integer id, @RequestBody ClienteHttpModel clienteHttpModel) {
		Cliente cliente = (clienteBusiness).atualizarCliente(id, ClienteHttpModelMapper.to(clienteHttpModel));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

		
	}

	
}
