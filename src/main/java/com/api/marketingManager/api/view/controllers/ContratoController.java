package com.api.marketingManager.api.view.controllers;

import com.api.marketingManager.api.application.ContratoFacade;
import com.api.marketingManager.api.domain.model.contrato.ContratoModel;
import com.api.marketingManager.api.view.dtos.ContratoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/contrato")
public class ContratoController {

    private final ContratoFacade contratoService;

    @Autowired
    public ContratoController(ContratoFacade contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping
    public ResponseEntity<List<ContratoModel>> getAllContratos(){
        return ResponseEntity.status(HttpStatus.OK).body(contratoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveContrato(@RequestBody ContratoDto contratoDto){
        var contratoModel = new ContratoModel();
        BeanUtils.copyProperties(contratoDto, contratoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(contratoService.save(contratoModel));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getContrato(@PathVariable(value = "id")Long id){
        ContratoModel contratoModel = contratoService.findById(id);
        if (contratoModel != null){
            return ResponseEntity.status(HttpStatus.OK).body(contratoModel);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não cadastrada no sistema.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContrato(@PathVariable(value = "id") Long id,
                                               @RequestBody ContratoDto contratoDto){
        ContratoModel contratoModel = contratoService.findById(id);
        if (contratoModel == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrato não cadastrado no sistema.");
        }
        Long idContrato = contratoModel.getIdContrato();

        BeanUtils.copyProperties(contratoDto, contratoModel);
        contratoModel.setIdContrato(idContrato);

        return ResponseEntity.status(HttpStatus.OK).body(contratoService.update(contratoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContrato(@PathVariable(value = "id") Long id){
        ContratoModel contratoModel = contratoService.findById(id);
        if (contratoModel == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrato não cadastrado no sistema.");
        }
        contratoService.delete(contratoModel);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa removida com sucesso.");
    }
}
