package com.orange.talent.account.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeverityEnum {
    SUCCESS("success"),
    WARNING("warning"),
    DANGER("danger");

    private String label;

}
