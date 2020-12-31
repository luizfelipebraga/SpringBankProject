package com.orange.talent.account.exception;

import com.orange.talent.account.domain.BaseExceptionDetails;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public abstract class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    @Getter
    private BaseExceptionDetails data;

    private Object[] parameters;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    protected BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public BusinessException(BaseExceptionDetails message,
                             Object... params) {
        super(message.getMessage());
        this.parameters = params;
        this.data = message;
    }

    public BusinessException(BaseExceptionDetails message,
                             Throwable cause,
                             Object... params) {
        super(message.getMessage(), cause);
        this.parameters = params;
        this.data = message;
    }

    public BusinessException(BaseExceptionDetails message,
                             Throwable cause) {
        super(message.getMessage(), cause);
        this.data = message;
    }

    public BusinessException(Exception ex) {
        super(ex.getMessage(), ex);
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        return parameters == null ? message : MessageFormat.format(message, parameters);
    }
}
