package com.prograMovil.demo.controllers;

import com.prograMovil.demo.dtos.EmailDTO;
import com.prograMovil.demo.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/send-email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailDTO email) throws MessagingException {
        emailService.sendMail(email);
        return new ResponseEntity<>("Correo "+"enviado exitosamente ", HttpStatus.OK);
    }
}
