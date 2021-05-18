package com.surittec.avaliacao.api.cliente.email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surittec.avaliacao.api.cliente.Cliente;
import com.surittec.avaliacao.api.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Email extends BaseEntity {

    @NotEmpty
    @javax.validation.constraints.Email
    private String email;

    @ManyToOne
    @JsonIgnore
    private Cliente cliente;
}
