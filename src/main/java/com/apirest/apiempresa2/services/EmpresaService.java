package com.apirest.apiempresa2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.apiempresa2.models.Empresa;
import com.apirest.apiempresa2.repositories.IEmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    private IEmpresaRepository empresaRepo;

    public List<Empresa> listarEmpresas(){
        return empresaRepo.findAll();
    }

}
