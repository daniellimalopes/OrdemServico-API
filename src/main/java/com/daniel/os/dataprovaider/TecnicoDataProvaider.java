package com.daniel.os.dataprovaider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.dataprovaider.entity.DadosDeLoginEntity;
import com.daniel.os.dataprovaider.entity.TecnicoEntity;
import com.daniel.os.dataprovaider.gateway.TecnicoGateway;
import com.daniel.os.dataprovaider.mapper.TecnicoEntityMapper;
import com.daniel.os.dataprovaider.repository.DadosDeLoginRepository;
import com.daniel.os.dataprovaider.repository.TecnicoRepository;

@Component
public class TecnicoDataProvaider implements TecnicoGateway {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private DadosDeLoginRepository dadosDeLoginRepository;

	@Override
	public Tecnico cadastrarTecnico(Tecnico tecnico) {
		TecnicoEntity tecnicoEntity = TecnicoEntityMapper.from(tecnico);
		TecnicoEntity tecnicoEntityNovo = tecnicoRepository.save(tecnicoEntity);
		tecnicoEntity.setId(tecnicoEntityNovo.getId());
		
		for(DadosDeLoginEntity dadosDeLoginEntity : tecnicoEntity.getDadosDeLogins()) {
			dadosDeLoginEntity.setTecnicoId(tecnicoEntityNovo.getId());
			dadosDeLoginRepository.save(dadosDeLoginEntity);
		}

		return TecnicoEntityMapper.to(tecnicoEntityNovo);
	}

	@Override
	public Tecnico findById(Integer id) {
		TecnicoEntity tecnicoEntity = tecnicoRepository.findById(id).get();
		return TecnicoEntityMapper.to(tecnicoEntity);
	}

	@Override
	public Tecnico findAll() {
		TecnicoEntity tecnicoEntity = (TecnicoEntity) tecnicoRepository.findAll();
		return TecnicoEntityMapper.to(tecnicoEntity);
	}

	@Override
	public Tecnico atualizarTecnico(Integer id, Tecnico tecnico) {
		TecnicoEntity tecnicoEntity = TecnicoEntityMapper.from(tecnico);
		TecnicoEntity tecnicoEntityAtualizado = tecnicoRepository.save(tecnicoEntity);
		tecnicoEntity.setId(tecnicoEntityAtualizado.getId());

		return TecnicoEntityMapper.to(tecnicoEntityAtualizado);
	}
}
