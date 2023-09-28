package com.api.marketingManager.api.view.controllers;

import com.api.marketingManager.api.application.PessoaFacade;
import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.view.dtos.PessoaDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public ResponseEntity<Object> savePessoa(@RequestBody PessoaDto pessoaDto){
        if (pessoaService.findByCPF(pessoaDto.getNumCpf()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Este cpf já está cadastrado no sistema.");
        }
        if (pessoaService.findByCNPJ(pessoaDto.getCnpj()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Este cnpj já está cadastrado no sistema.");
        }
       /* var pessoaModel = new PessoaModel(null,null,null,0,null,null,0,0,null,null,null,null,null);
        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        pessoaModel.setDtaCadastro(LocalDate.now(ZoneId.of("UTC")));*/
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaDto));
    }
    @GetMapping("/{cpf-cnpj}")
    public ResponseEntity<Object> getPessoa(@PathVariable(value = "cpf-cnpj")String identificador){
        if (identificador.length() == 11){
            PessoaModel pessoaModel = pessoaService.findByCPF(identificador);
            if (pessoaModel == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não encontrado.");
            }
            return ResponseEntity.status(HttpStatus.OK).body(pessoaModel);
        }
        if (identificador.length() == 14){
            PessoaModel pessoaModel = pessoaService.findByCNPJ(identificador);
            if (pessoaModel == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cnpj não encontrado.");
            }
            return ResponseEntity.status(HttpStatus.OK).body(pessoaModel);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cpf/Cnpj inválido.");
    }


}
