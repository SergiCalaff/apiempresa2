package com.apirest.apiempresa2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.apiempresa2.models.Rol;
import com.apirest.apiempresa2.repositories.IRolRepository;

@Service
public class RolService {

    @Autowired
    private IRolRepository rolRepo;

    public List<Rol> listarRoles(){
        return rolRepo.findAll();
    };

}
