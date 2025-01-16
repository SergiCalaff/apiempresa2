package com.apirest.apiempresa2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.apiempresa2.models.Empresa;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {

}
