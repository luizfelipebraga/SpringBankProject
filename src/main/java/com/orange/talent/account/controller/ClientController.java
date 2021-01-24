package com.orange.talent.account.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import com.orange.talent.account.business.ClientBusiness;
import com.orange.talent.account.dto.form.ClientFormDTO;
import com.orange.talent.account.dto.response.ClientResponseDTO;
import com.orange.talent.account.exception.ValidationFailedException;
import com.orange.talent.account.kafka.producer.ClientProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("v1/")
@Api(value = "Client Controller", tags = "Controller de cadastro de cliente")
public class ClientController {

    // injecao de depedencias;
    @Autowired
    ClientBusiness clientBusiness;
    
    @Autowired
    ClientProducer clientProducer;

    @GetMapping("client/findByName")
    @ApiOperation(httpMethod = "GET", value = "buscar por nome", notes = "buscar por nome irá retornar uma lista de clientes que contém esse nome", response = ClientResponseDTO.class)

    public ResponseEntity<List<ClientResponseDTO>> findAllClientByName(@RequestParam String name) {
        return new ResponseEntity<List<ClientResponseDTO>>(clientBusiness.findAllClientByName(name), HttpStatus.OK);
    }

    @PostMapping("client")
    @ApiOperation(httpMethod = "POST", value = "Cadastro de cliente", notes = "Cadastro de cliente com validação")
    public ResponseEntity<Object> insertClient(
            @ApiParam("formClient") @RequestBody @Valid ClientFormDTO clientFormDTO) {

        try {

            ClientResponseDTO client = clientBusiness.insertClient(clientFormDTO);
            clientProducer.send(client);
            return new ResponseEntity<Object>(client, HttpStatus.CREATED);

        } catch (ValidationFailedException e) {
            HashMap<String, Object> result = new HashMap<>();
            result.put("error", true);
            result.put("error_message", e.getMessage());
            return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
        }

    }
}
