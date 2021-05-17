package com.surittec.avaliacao.api.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class MessageConfig {

    @Value("${cliente.message001}")
    private String message001;

    @Value("${cliente.message002}")
    private String message002;
}
