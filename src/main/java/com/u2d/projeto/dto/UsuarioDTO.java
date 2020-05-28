package com.u2d.projeto.dto;

import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 5420741256083441157L;

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotNull
    @NotBlank
    @Size(max = 14)
    private String cpf;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String email;
}


