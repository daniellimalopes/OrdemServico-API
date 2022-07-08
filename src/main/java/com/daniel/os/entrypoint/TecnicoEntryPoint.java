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

import com.daniel.os.core.business.TecnicoBusiness;
import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.entrypoint.httpmodel.TecnicoHttpModel;
import com.daniel.os.entrypoint.mapper.TecnicoHttpModelMapper;

@RestController
@RequestMapping(value = "/tecnico")
public class TecnicoEntryPoint {

	@Autowired 
	private TecnicoBusiness cadastrarTecnicoBusiness;



	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TecnicoHttpModel tecnicoHttpModel) {
		Tecnico tecnico = cadastrarTecnicoBusiness.cadastrarTecnico(TecnicoHttpModelMapper.to(tecnicoHttpModel));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
