package com.daniel.os.core.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.daniel.os.configuration.entity.FieldMensage;
import com.daniel.os.core.domain.enums.TipoCliente;
import com.daniel.os.dataprovaider.repository.ClienteRepository;
import com.daniel.os.entrypoint.httpmodel.ClienteHttpModel;


public class ClienteInsertValidation implements ConstraintValidator<ClienteInsert, ClienteHttpModel> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteHttpModel clienteHttpModel, ConstraintValidatorContext context) {
		List<FieldMensage> list = new ArrayList<>();

		if(clienteHttpModel.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getCod()) && !CpfCnpjValidation.isValidCPF(clienteHttpModel.getCpfcnpj())){
			list.add(new FieldMensage("CpfOucnpj", "CPF Inválido"));
		}
		
		if(clienteHttpModel.getTipoCliente().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !CpfCnpjValidation.isValidCNPJ(clienteHttpModel.getCpfcnpj())){
			list.add(new FieldMensage("CpfOucnpj", "CNPJ Inválido"));
		}
		
		ClienteHttpModel aux = (ClienteHttpModel) clienteRepository.findAll();
		if(aux != null) {
			list.add(new FieldMensage("Email", "Email já cadastrado "));
		}
		
		

		for (FieldMensage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
