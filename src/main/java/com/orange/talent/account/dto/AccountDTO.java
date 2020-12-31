package com.orange.talent.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class AccountDTO {

    private Long id;

    private BankDTO bank;

    private Integer account;

    private Integer agency;

    private Integer accountDigit;
}
