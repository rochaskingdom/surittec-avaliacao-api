package com.surittec.avaliacao.api.usuario;

import com.surittec.avaliacao.api.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoles userRole;
}
