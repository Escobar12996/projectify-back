package com.escobar.Proyectify.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Structure of ok response")
public class OkResponse {

    @Schema(description = "Ok message", example = "Ok")
    private String message;

    public OkResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
