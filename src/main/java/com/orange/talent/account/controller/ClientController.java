package com.orange.talent.account.controller;

import com.orange.talent.account.business.ClientBusiness;
import com.orange.talent.account.dto.form.ClientFormDTO;
import com.orange.talent.account.dto.response.ClientResponseDTO;
import com.orange.talent.account.exception.BusinessException;
import com.orange.talent.account.exception.MethodArgumentNotValidExceptionHandler;
import com.orange.talent.account.exception.ValidationFailedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("v1/")
@Api(value="Client Controller", tags = "Controller de cadastro de cliente")
public class ClientController {

    //injecao de depedencias;
    @Autowired
    ClientBusiness clientBusiness;


    @GetMapping("client/findByName")
    @ApiOperation(httpMethod = "GET", value = "buscar por nome", notes = "buscar por nome irá retornar uma lista de clientes que contém esse nome", response = ClientResponseDTO.class)

    public ResponseEntity<List<ClientResponseDTO>> findAllClientByName(@RequestParam String name) {
        return new ResponseEntity<List<ClientResponseDTO>>(clientBusiness.findAllClientByName(name), HttpStatus.OK);
    }

    @PostMapping("client")
    @ApiOperation(httpMethod = "POST", value = "Cadastro de cliente", notes = "Cadastro de cliente com validação")
    public ResponseEntity<Object> insertClient(@ApiParam("formClient") @RequestBody @Valid ClientFormDTO clientFormDTO) {

        try {
            return new ResponseEntity<Object>(clientBusiness.insertClient(clientFormDTO), HttpStatus.CREATED);

            } catch (ValidationFailedException e) {
                HashMap<String, Object> result = new HashMap<>();
                result.put("error", true);
                result.put("error_message", e.getMessage());
                return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
        }

    }
}
