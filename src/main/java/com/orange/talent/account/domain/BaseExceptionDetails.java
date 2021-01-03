package com.orange.talent.account.domain;

import com.orange.talent.account.enums.SeverityEnum;

public interface BaseExceptionDetails {

    String getMessage();

    default String getTitle() {
        return "Erro";
    }

    default String getInternalErrorCode() {
        return null;
    }

    default SeverityEnum getSeverity(){
        return SeverityEnum.DANGER;
    }
}
