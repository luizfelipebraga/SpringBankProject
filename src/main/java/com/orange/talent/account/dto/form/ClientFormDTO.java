package com.orange.talent.account.dto.form;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ClientFormDTO {
    @NotBlank(message = "Campo 'Nome' é obrigatório")
    private String name;

    @NotBlank(message = "Campo 'Email' é obrigatório")
    @Pattern(regexp = "^(.+)@(.+)$", message = "Campo 'Email' é inválido.")
    private String email;

    @NotBlank(message = "Campo 'Cpf' é obrigatório")
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "Campo 'Cpf' deve estar no formato 999.999.999-99")
    private String document;

    @NotNull
    private LocalDate birthDate;

	public String getDocument() {
		return null;
	}
}
