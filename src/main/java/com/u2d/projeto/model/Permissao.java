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
@Table(name ="TB006_PERMISSAO")
public class Permissao implements Serializable {

    private static final long serialVersionUID = 5127969155472908165L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_PERMISSAO")
    private Long id;

    @Column(name = "DE_PERMISSAO")
    private String descricao;
}
