package com.surittec.avaliacao.api.exception.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ErrorResponse {

    @JsonProperty("error")
    private final String errorCode;

    @JsonProperty("error_description")
    private final String errorDescription;

}
