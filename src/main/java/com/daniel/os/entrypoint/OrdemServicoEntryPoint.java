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

import com.daniel.os.core.business.CadastrarOrdemServicoBusiness;
import com.daniel.os.core.domain.OrdemServico;
import com.daniel.os.entrypoint.httpmodel.OrdemServicoHttpModel;
import com.daniel.os.entrypoint.mapper.OrdemServicoHttpModelMapper;

@RestController
@RequestMapping(value = "/ordemservico")
public class OrdemServicoEntryPoint {
	
	@Autowired
	private CadastrarOrdemServicoBusiness cadastrarOrdemServicoBusiness;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<OrdemServico> insert(@Valid @RequestBody OrdemServicoHttpModel ordemServicoHttpModel){
		OrdemServico ordemServico = cadastrarOrdemServicoBusiness.cadastrarOrdemServico(OrdemServicoHttpModelMapper.to(ordemServicoHttpModel));
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordemServico.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
