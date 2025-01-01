package tn.essat.boitemessagerie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tn.essat.boitemessagerie.config.GestionToken;
import tn.essat.boitemessagerie.config.JwtRequest;
import tn.essat.boitemessagerie.config.JwtResponse;
import tn.essat.boitemessagerie.model.User;
import tn.essat.boitemessagerie.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/auth")
public class RestAuth {

    @Autowired
    private GestionToken token_gen;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    public ResponseEntity<JwtResponse> signIn(@RequestBody JwtRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = userService.loadUserByUsername(request.getUsername());
            String token = token_gen.generateToken(user);
            return ResponseEntity.ok(new JwtResponse(token));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JwtResponse("Invalid credentials"));
        }
    }


    @PostMapping(value = "/signup")
    public User addUser(@RequestBody User u) {
        return userService.addUser(u);
    }

}
