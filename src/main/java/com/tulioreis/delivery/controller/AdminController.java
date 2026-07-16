package com.tulioreis.delivery.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String senha = body.get("senha");

        Map<String, Object> resposta = new HashMap<>();

        if (
                email.equals("admin@bnburguer.com") &&
                        senha.equals("123456")
        ) {
            resposta.put("autenticado", true);
        } else {
            resposta.put("autenticado", false);
        }

        return resposta;
    }
}