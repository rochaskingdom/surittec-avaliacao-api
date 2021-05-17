package com.surittec.avaliacao.api.telefone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surittec.avaliacao.api.cliente.Cliente;
import com.surittec.avaliacao.api.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Telefone extends BaseEntity {

    @NotBlank
    @Column(name = "NUMERO")
    private String numero;

    @NotNull
    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;
}
