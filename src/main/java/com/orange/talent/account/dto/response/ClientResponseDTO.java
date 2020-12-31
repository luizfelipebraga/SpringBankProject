package com.orange.talent.account.dto.response;

import com.orange.talent.account.dto.AccountDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString

public class ClientResponseDTO {

    private Long id;

    private AccountDTO account;

    private String name;

    private String email;

    private String document;

    private LocalDate birthDate;
}
