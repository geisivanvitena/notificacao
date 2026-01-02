package com.geisivan.notificacao.business;

import com.geisivan.notificacao.business.dto.TarefaDTO;
import com.geisivan.notificacao.infraStructure.EmailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Value("${envio.email.remetente}")
    public String remetente;

    @Value("${envio.email.nomeRemetente}")
    private String nomeRemetente;

    public void enviarEmail(TarefaDTO dto){
        try {

            // Cria o objeto que permite enviar e-mails complexos (HTML, anexos, encoding, etc.)
            MimeMessage message = javaMailSender.createMimeMessage();

            // Configuração do e-mail
            MimeMessageHelper messageHelper = new MimeMessageHelper(
                    message, true, StandardCharsets.UTF_8.name());

            // Define o remetente do e-mail
            messageHelper.setFrom(new InternetAddress(remetente, nomeRemetente));

            // Define o destinatário do e-mail
            messageHelper.setTo(InternetAddress.parse(dto.getEmailUsuario()));

            // Define o assunto do e-mail
            messageHelper.setSubject("Notificação de tarefa");

            // Cria o contexto do Thymeleaf
            Context context = new Context();

            // Variáveis que serão acessadas no template "notificacao.html"
            context.setVariable("nomeTarefa", dto.getNomeTarefa());
            context.setVariable("dataEvento", dto.getDataEvento());
            context.setVariable("descricao", dto.getDescricao());

            // Processa o template Thymeleaf chamado "notificacao"
            String template = templateEngine.process("notificacao", context);

            // Define o corpo do e-mail
            messageHelper.setText(template, true);

            // Envia o e-mail usando o JavaMailSender
            javaMailSender.send(message);

        }catch (MessagingException | UnsupportedEncodingException e){
            throw new EmailException("Erro ao enviar email. ", e.getCause());
        }
    }

}
