package com.prograMovil.demo.services;

import com.prograMovil.demo.dtos.EmailDTO;
import jakarta.mail.MessagingException;

public interface EmailService {
    public void sendMail(EmailDTO email) throws MessagingException;
}
