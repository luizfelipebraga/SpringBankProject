package com.orange.talent.account.enums;

import com.orange.talent.account.domain.BaseExceptionDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientValidationEnum implements BaseExceptionDetails {
    DOCUMENT_REGISTRED("CPF já cadastrado."),
    EMAIL_REGISTRED("Email já cadastrado.");

    private String message;

}
