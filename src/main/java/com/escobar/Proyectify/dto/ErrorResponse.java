package com.escobar.Proyectify.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Structure of error response")
public class ErrorResponse {

    @Schema(description = "Error message", example = "Unauthorized: wrong credentials")
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
