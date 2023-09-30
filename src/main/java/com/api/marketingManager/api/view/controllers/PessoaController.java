package com.api.marketingManager.api.view.controllers;

import com.api.marketingManager.api.application.PessoaFacade;
import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.view.dtos.PessoaDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Object> savePessoa(@RequestBody PessoaDto pessoaDto){
        if (pessoaService.findByCPF(pessoaDto.getNumCpf()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Este cpf já está cadastrado no sistema.");
        }
        if (pessoaService.findByCNPJ(pessoaDto.getCnpj()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Este cnpj já está cadastrado no sistema.");
        }
        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        pessoaModel.setDtaCadastro(LocalDate.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaModel));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPessoa(@PathVariable(value = "id")Long id){
        PessoaModel pessoaModel = pessoaService.findById(id);
        if (pessoaModel != null){
            return ResponseEntity.status(HttpStatus.OK).body(pessoaModel);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não cadastrada no sistema.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePessoa(@PathVariable(value = "id") Long id,
                                               @RequestBody PessoaDto pessoaDto){
        PessoaModel pessoaModel = pessoaService.findById(id);
        if (pessoaModel == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não cadastrada no sistema.");
        }
        Long pessoaId = pessoaModel.getPessoaId();
        LocalDate dtaCadastroPessoa = pessoaModel.getDtaCadastro();

        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        pessoaModel.setPessoaId(pessoaId);
        pessoaModel.setDtaCadastro(dtaCadastroPessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(pessoaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable(value = "id") Long id){
        PessoaModel pessoaModel = pessoaService.findById(id);
        if (pessoaModel == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não cadastrada no sistema.");
        }
        pessoaService.delete(pessoaModel);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa removida com sucesso.");
    }


}
