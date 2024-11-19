package com.prograMovil.demo.services.implement;

import com.prograMovil.demo.dtos.EmailDTO;
import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Postulante;
import com.prograMovil.demo.models.PostulanteConvocatoria;
import com.prograMovil.demo.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    @Autowired
    private PostulanteConvocImpl postulanteConvocImpl;

    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }
    @Override
    public void sendMail(EmailDTO email) throws MessagingException {
        String asunto="Respuesta a la postulación de la convocatoria "+email.getTituloConvocatoria();;
        String mensaje="";
        if(email.getIdPostulante() != null){
            postulanteConvocImpl.setAceptado(email.getIdConvocatoria(), email.getIdPostulante(), email.isAceptado());

        }else{
            throw new MessagingException("El postulante no existe");
        }
        if(email.isAceptado()){
            mensaje = "Felicidades fuiste aceptado en la convocatoria "+email.getTituloConvocatoria()+". La empresa" +
                    " pronto se pondra en contacto con usted.";
        }else{
            mensaje = "Después de examinar cuidadosamente la hoja de vida que enviaste a la convocatoria "+email.getTituloConvocatoria()+
                    " optamos por continuar con otro candidato.";
        }
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mimeMessageHelper.setTo(email.getDestinatario());
            mimeMessageHelper.setSubject(asunto);
            Context context = new Context();
            context.setVariable("mensaje", mensaje);
            String contentHTML = templateEngine.process("email", context);
            mimeMessageHelper.setText(contentHTML, true);
            javaMailSender.send(mimeMessage);
        }catch (Exception e) {
            throw new RuntimeException("Error al enviar el email: "+e.getMessage(), e);
        }
    }
}
