package com.example.meudinheiro.modules.user.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.meudinheiro.modules.security.jwt.JwtUtils;
import com.example.meudinheiro.modules.user.dto.AcessDTO;
import com.example.meudinheiro.modules.user.dto.CreateUserDTO;

@Service
public class AuthUseCase {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(CreateUserDTO authDto) {

        try {
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword());

            Authentication authentication = authenticationManager.authenticate(userAuth);

            UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUser(userAuthenticate);

            AcessDTO acessDTO = new AcessDTO(token);

            return acessDTO;
            
        } catch(Exception e) {
            System.out.println("Login ou senha inválido(s)");
        }
        
        return new AcessDTO("Acesso negado");
    }
}
