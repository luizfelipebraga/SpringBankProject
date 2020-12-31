package com.orange.talent.account.exception;

import com.orange.talent.account.domain.BaseExceptionDetails;
import com.orange.talent.account.enums.SeverityEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class ValidationFailedException extends BusinessException {

    private static final long serialVersionUID = 1L;

    @Getter
    @AllArgsConstructor
    public enum Message implements BaseExceptionDetails {
        DEFAULT("Verifique os parâmetros", "1011");

        private String title;
        private String internalErrorCode;

        @Override
        public String getMessage() {
            return null;
        }

    }

    public ValidationFailedException(Message message) {
        super(message.getMessage());
    }

    public ValidationFailedException(BaseExceptionDetails data,
                                     Object... params) {
        super(new CustomExceptionData(Message.DEFAULT.title,
                        Message.DEFAULT.internalErrorCode,
                        data.getMessage(),
                        Message.DEFAULT.getSeverity()),
                params);
    }

}

@Getter
@AllArgsConstructor
class CustomExceptionData implements BaseExceptionDetails {

    private String title;
    private String internalErrorCode;
    private String message;
    private SeverityEnum severity;

}
