package com.dmoreno06.crudConcessionary.controller;

import com.dmoreno06.crudConcessionary.dto.ClienteDTO;
import com.dmoreno06.crudConcessionary.dto.Mensaje;
import com.dmoreno06.crudConcessionary.entity.Cliente;
import com.dmoreno06.crudConcessionary.servece.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/list")
    public ResponseEntity<List<Cliente>> list(){
        List<Cliente> list = clienteService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{idCliente}")
    public ResponseEntity<List<Cliente>> getById(@PathVariable("idCliente") int idCliente){
        if (!clienteService.existsById(idCliente))
            return new ResponseEntity(new Mensaje("el cliente existe"), HttpStatus.NOT_FOUND);
        Cliente cliente = clienteService.getOne(idCliente).get();
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody ClienteDTO clienteDTO){
        if(clienteDTO.getDocIdentidad()==null)
            return new ResponseEntity(new Mensaje("el numero de identidad es obligatorio"), HttpStatus.BAD_REQUEST);
        if(clienteDTO.getNombre().equals(null) )
            return new ResponseEntity(new Mensaje("el campo nombre es requerido"), HttpStatus.BAD_REQUEST);
        if(clienteService.existsByDocIdentidad(clienteDTO.getDocIdentidad()))
           return new ResponseEntity(new Mensaje("el numero de identificacion ya existe"), HttpStatus.BAD_REQUEST);
        Cliente cliente = new Cliente(clienteDTO.getDocIdentidad(), clienteDTO.getNombre(),
                clienteDTO.getApellidos(),clienteDTO.getCiudad(),clienteDTO.getNumTelefono());
        clienteService.save(cliente);
        return new ResponseEntity(new Mensaje("Cliente creado"), HttpStatus.OK);
    }

    @PutMapping("/edit/{idCliente}")
    public ResponseEntity<?> update(@PathVariable("idCliente")int idCliente, @RequestBody ClienteDTO clienteDTO){
        if(!clienteService.existsById(idCliente))
            return new ResponseEntity(new Mensaje("El cliente no existe"), HttpStatus.NOT_FOUND);
        if(clienteDTO.getDocIdentidad()==(null))
            return new ResponseEntity(new Mensaje("el identificador es obligatorio"), HttpStatus.BAD_REQUEST);


        Cliente cliente = clienteService.getOne((idCliente)).get();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellidos(clienteDTO.getApellidos());
        cliente.setCiudad(clienteDTO.getCiudad());
        cliente.setNumTelefono(clienteDTO.getNumTelefono());
        clienteService.save(cliente);
        return new ResponseEntity(new Mensaje("Cliente actualizado"), HttpStatus.OK);

    }
    @DeleteMapping("/delete/{idCliente}")
    public ResponseEntity<?> delete(@PathVariable("idCliente")int idCliente){
        if(!clienteService.existsById(idCliente))
            return new ResponseEntity(new Mensaje("El cliente no existe."), HttpStatus.NOT_FOUND);
        clienteService.delete(idCliente);
        return new ResponseEntity(new Mensaje("Cliente eliminado correctamente."), HttpStatus.OK);
    }
}
