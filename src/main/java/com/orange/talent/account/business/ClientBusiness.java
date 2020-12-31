package com.orange.talent.account.business;

import com.orange.talent.account.dto.form.ClientFormDTO;
import com.orange.talent.account.dto.response.ClientResponseDTO;
import com.orange.talent.account.exception.BusinessException;
import com.orange.talent.account.exception.ValidationFailedException;

import java.util.List;

public interface ClientBusiness {
    List<ClientResponseDTO> findAllClientByName(String name);
    ClientResponseDTO insertClient(ClientFormDTO clientFormDTO) throws ValidationFailedException;
}
