package com.apirest.apiempresa2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.apiempresa2.models.Empresa;
import com.apirest.apiempresa2.services.EmpresaService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarEmpresas() {
        List<Empresa> empresas =  empresaService.listarEmpresas();
        return ResponseEntity.ok(empresas);
    }
    



}
