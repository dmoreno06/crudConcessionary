package com.dmoreno06.crudConcessionary.servece;

import com.dmoreno06.crudConcessionary.entity.Cliente;
import com.dmoreno06.crudConcessionary.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> list(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getOne(int id){
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> getByDocIdentidad(String docIdentidad){
        return clienteRepository.findByDocIdentidad(docIdentidad);
    }

    public void  save(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void delete(int id){
        clienteRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return clienteRepository.existsById(id);
    }

    public boolean existsByDocIdentidad(String docIdentidad){
       return clienteRepository.existsByDocIdentidad(docIdentidad);
    }
}
