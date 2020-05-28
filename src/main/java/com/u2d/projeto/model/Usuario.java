package com.u2d.projeto.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name ="TB001_USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 3558747835610744963L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_USUARIO")
    private Long id;

    @Column(name = "NO_NOME")
    private String nome;

    @Column(name = "NU_CPF", unique = true)
    private String cpf;

    @Column(name = "DES_EMAIL")
    private String email;
}
