package org.gkswargam.controllers;

import org.gkswargam.dtos.IssueTokenRequestDTO;
import org.gkswargam.dtos.IssueTokenResponseDTO;
import org.gkswargam.dtos.ResponseStatus;
import org.gkswargam.models.Token;
import org.gkswargam.services.TokenService;

public class TokenController {
    private TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public IssueTokenResponseDTO issueToken(IssueTokenRequestDTO issueTokenRequestDTO) {
        IssueTokenResponseDTO issueTokenResponseDTO = new IssueTokenResponseDTO();

        try {
            Token token = tokenService.issueToken(
                    issueTokenRequestDTO.getVehicleNumber(),
                    issueTokenRequestDTO.getVehicleOwnerName(),
                    issueTokenRequestDTO.getGateId(),
                    issueTokenRequestDTO.getVehicleType()
            );

            issueTokenResponseDTO.setToken(token);
            issueTokenResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            issueTokenResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            issueTokenResponseDTO.setFailureMessage(ex.getMessage());
        }

        return issueTokenResponseDTO;
    }
}
