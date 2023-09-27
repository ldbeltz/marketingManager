package com.api.marketingManager.controllers;

import com.api.marketingManager.application.PessoaFacade;
import com.api.marketingManager.domain.model.pessoa.PessoaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaFacade pessoaService;

    @Autowired
    public PessoaController(PessoaFacade pessoaService) {
      this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> getAllPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }


}
