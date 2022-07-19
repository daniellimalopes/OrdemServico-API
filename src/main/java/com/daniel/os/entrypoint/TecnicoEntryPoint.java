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

import com.daniel.os.core.business.TecnicoBusiness;
import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.entrypoint.httpmodel.ClienteHttpModel;
import com.daniel.os.entrypoint.httpmodel.TecnicoHttpModel;
import com.daniel.os.entrypoint.mapper.TecnicoHttpModelMapper;

@RestController
@RequestMapping(value = "/tecnico")
public class TecnicoEntryPoint {

	@Autowired 
	private TecnicoBusiness tecnicoBusiness;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id ){
		Tecnico tecnicos = tecnicoBusiness.findById(id);
		return ResponseEntity.ok().body(tecnicos);
		
	}
	
	@GetMapping
	public ResponseEntity<Tecnico> findAll(){
		Tecnico tecnico = tecnicoBusiness.findAll();
		return ResponseEntity.ok().body(tecnico);
		
	}

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody TecnicoHttpModel tecnicoHttpModel) {
		Tecnico tecnico = tecnicoBusiness.cadastrarTecnico(TecnicoHttpModelMapper.to(tecnicoHttpModel));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteHttpModel> update (@PathVariable("id") Integer id, @RequestBody TecnicoHttpModel tecnicoHttpModel) {
		Tecnico tecnico = (tecnicoBusiness).atualizarTecnico(id, TecnicoHttpModelMapper.to(tecnicoHttpModel));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

		
	}
}
