package com.daniel.os.entrypoint;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.daniel.os.core.business.CadastrarClienteBusiness;
import com.daniel.os.core.domain.Cliente;
import com.daniel.os.entrypoint.httpmodel.ClienteHttpModel;
import com.daniel.os.entrypoint.mapper.ClienteHttpModelMapper;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteEntryPoint {

	@Autowired
	private CadastrarClienteBusiness cadastrarClienteBusiness;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteHttpModel clienteHttpModel) {
		Cliente cliente = cadastrarClienteBusiness.cadastrarCliente(ClienteHttpModelMapper.to(clienteHttpModel));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
