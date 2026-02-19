package com.geisivan.notificacao.controller;

import com.geisivan.notificacao.business.service.EmailService;
import com.geisivan.notificacao.business.dto.TarefaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    public final EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> enviarEmail(@RequestBody TarefaDTO dto){
        emailService.enviarEmail(dto);
        return ResponseEntity.ok().build();
    }
}
