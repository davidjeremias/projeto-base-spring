package com.u2d.projeto.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @Column(name = "CO_SENHA")
    private String senha;

    @OneToOne
    @JoinColumn(name = "EMPRESA_CO")
    private Empresa empresa;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USUARIO_PERMISSAO", joinColumns = @JoinColumn(name = "USUARIO_CO"), inverseJoinColumns = @JoinColumn(name = "PERMISSAO_CO") )
    private List<Permissao> permissoes;
}
