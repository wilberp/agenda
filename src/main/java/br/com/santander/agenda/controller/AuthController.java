package br.com.santander.agenda.controller;

import br.com.santander.agenda.model.dto.FormLoginDto;
import br.com.santander.agenda.model.dto.TokenDto;
import br.com.santander.agenda.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> authentica(@RequestBody FormLoginDto formDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(formDto.getEmail(), formDto.getSenha()));
        String token = tokenService.geraToken(authenticate);
        return ResponseEntity.ok(new TokenDto(token,"Bearer"));
    }
}
