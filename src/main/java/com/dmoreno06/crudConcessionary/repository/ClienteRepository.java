package com.dmoreno06.crudConcessionary.repository;

import com.dmoreno06.crudConcessionary.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByDocIdentidad(String docIdentidad);
    boolean existsByDocIdentidad(String docIdentidad);
}
