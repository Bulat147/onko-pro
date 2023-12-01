package ru.onko.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/generate")
@Tag(name = "AccessLinkGenerator API")
public interface AccessLinkGeneratingApi {
    @Operation(summary = "GET link", description = "return access-link like string", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully got"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping("/link")
    @ResponseStatus(HttpStatus.OK)
    String generateAccessLink();
    @Operation(summary = "GET qr-code", description = "return qr-code in image/png", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully got image"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping("/qr")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> generateAccessQrCode();
}
