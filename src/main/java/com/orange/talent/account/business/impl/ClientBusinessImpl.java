package com.orange.talent.account.business.impl;

import com.orange.talent.account.business.ClientBusiness;
import com.orange.talent.account.dto.form.ClientFormDTO;
import com.orange.talent.account.dto.response.ClientResponseDTO;
import com.orange.talent.account.entity.Account;
import com.orange.talent.account.entity.Bank;
import com.orange.talent.account.entity.Client;
import com.orange.talent.account.enums.ClientValidationEnum;
import com.orange.talent.account.exception.BusinessException;
import com.orange.talent.account.exception.ValidationFailedException;
import com.orange.talent.account.mapper.MapperConverter;
import com.orange.talent.account.repository.AccountRepository;
import com.orange.talent.account.repository.BankRepository;
import com.orange.talent.account.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ClientBusinessImpl implements ClientBusiness {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private AccountRepository accountRepository;

    public List<ClientResponseDTO> findAllClientByName(String name){

        MapperConverter mapper = MapperConverter.convert();

        List<Client> clients = clientRepository.findByNameContains(name);

        return mapper.map(clients, ClientResponseDTO.class);
    }

    public ClientResponseDTO insertClient(ClientFormDTO clientFormDTO) throws ValidationFailedException {


        if (clientRepository.findByDocument(clientFormDTO.getDocument()).isPresent()){
            throw new ValidationFailedException(ClientValidationEnum.DOCUMENT_REGISTRED);
        }

        if (clientRepository.findByEmail(clientFormDTO.getEmail()).isPresent()){
            throw new ValidationFailedException(ClientValidationEnum.EMAIL_REGISTRED);
        }

        MapperConverter mapper = MapperConverter.convert();

        Client client = mapper.map(clientFormDTO, Client.class);

        Optional<Bank> bank = bankRepository.findById(1L);

        Account account = Account.builder()
                    .account(ThreadLocalRandom.current().nextInt())
                    .agency(ThreadLocalRandom.current().nextInt())
                    .accountDigit(ThreadLocalRandom.current().nextInt())
                    .bank(bank.get()).build();

        client.setAccount(accountRepository.save(account));

       return mapper.map(clientRepository.save(client), ClientResponseDTO.class);
    }
}
