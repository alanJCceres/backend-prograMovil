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
        String asunto="";
        String mensaje="";
        if(email.getIdPostulante() != null){
            postulanteConvocImpl.setEstado(email.getIdConvocatoria(), email.getIdPostulante(), email.getEstadoPostulante());

        }else{
            throw new MessagingException("El postulante no existe");
        }
        switch(email.getEstadoPostulante()){
            case "Preseleccionado":{
                asunto = "Resultado de la evaluación inicial para la convocatoria "+email.getTituloConvocatoria();
                mensaje = "Estimado/a Postulante,\n" +
                        "\n" +
                        "Nos complace informarle que, tras una revisión exhaustiva de su perfil y de su postulación, usted ha sido preseleccionado/a para continuar en el proceso de selección de la convocatoria "+email.getTituloConvocatoria()+".\n" +
                        "\n" +
                        "Como siguiente paso, se llevarán a cabo las etapas correspondientes a entrevistas, evaluaciones o cualquier otro requisito necesario. La empresa se pondrá en contacto con usted próximamente para proporcionarle detalles específicos sobre estas etapas y coordinar los pasos a seguir.\n" +
                        "\n" +
                        "Le agradecemos su interés y confianza en formar parte de esta oportunidad, y le deseamos mucho éxito en las siguientes fases del proceso.";
                break;
            }
            case "Rechazado":{
                asunto = "Resultado de la evaluación para la convocatoria "+email.getTituloConvocatoria();
                mensaje = "Estimado/a Postulante,\n" +
                        "\n" +
                        "Agradecemos su interés en participar en la convocatoria "+email.getTituloConvocatoria()+" y la confianza depositada en nosotros al postularse.\n" +
                        "\n" +
                        "Lamentamos informarle que, tras un análisis detallado de su perfil, no ha sido posible seleccionarlo/a para continuar en el proceso. La decisión no refleja de ninguna manera una falta de méritos, sino más bien la gran competitividad y el alto nivel de los postulantes.\n" +
                        "\n" +
                        "Le animamos a que siga participando en nuestras futuras convocatorias y le deseamos mucho éxito en sus próximos proyectos profesionales.";
                break;
            }
            case "Aceptado":{
                asunto = "Felicitaciones: ha sido seleccionado/a para la convocatoria "+email.getTituloConvocatoria();
                mensaje = "Estimado/a Postulante,\n" +
                        "\n" +
                        "Es un gusto informarle que, tras completar todas las etapas del proceso de selección, usted ha sido seleccionado/a para "+email.getTituloConvocatoria()+".\n" +
                        "\n" +
                        "En los próximos días, la empresa se pondrá en contacto con usted para brindarle detalles adicionales sobre su incorporación, incluyendo fechas, horarios y otros aspectos relevantes.\n" +
                        "\n" +
                        "Le agradecemos su esfuerzo y dedicación durante este proceso y le damos la bienvenida a nuestra organización. Estamos emocionados/as por lo que lograremos juntos/as.";
                break;
            }
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
