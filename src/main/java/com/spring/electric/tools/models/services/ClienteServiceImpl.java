package com.spring.electric.tools.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.electric.tools.models.entities.Cliente;
import com.spring.electric.tools.models.repositories.ClientesRepository;


@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClientesRepository clienteRepository;	
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public List<Cliente> buscarCliente(String campoBusqueda) {
		return clienteRepository.buscarCliente(campoBusqueda);
	}

	@Override
	public Cliente findByCedula(String cedula) {
		return clienteRepository.findByCedula(cedula);
	}
	
	
}

