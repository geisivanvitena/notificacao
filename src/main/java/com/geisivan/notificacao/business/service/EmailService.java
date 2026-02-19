package com.geisivan.notificacao.business.service;

import com.geisivan.notificacao.business.dto.TarefaDTO;
import com.geisivan.notificacao.infraStructure.EmailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Value("${envio.email.remetente}")
    private String remetente;

    @Value("${envio.email.nomeRemetente}")
    private String nomeRemetente;

    // Método responsável por orquestrar o envio do e-mail.
    public void enviarEmail(TarefaDTO dto) {
        logger.info("Iniciando envio de e-mail para: {}", dto.getEmailUsuario());
        try {
            MimeMessage message = criarMensagem();
            configurarMensagem(message, dto);
            enviar(message);
            logger.info("E-mail enviado com sucesso para: {}", dto.getEmailUsuario());
        } catch (MessagingException | UnsupportedEncodingException exception) {
            throw new EmailException("Erro ao enviar e-mail. ", exception);
        }
    }

    // Cria a estrutura base da mensagem com suporte a HTML, anexos e codificação
    private MimeMessage criarMensagem(){
        return javaMailSender.createMimeMessage();
    }

    // Configura remetente, destinatário, assunto e corpo da mensagem.
    private void configurarMensagem(MimeMessage message, TarefaDTO dto)
            throws MessagingException, UnsupportedEncodingException {

        // Configuração do e-mail
        MimeMessageHelper helper = new MimeMessageHelper(
                message, true, StandardCharsets.UTF_8.name());

        // Define o remetente do e-mail
        helper.setFrom(new InternetAddress(remetente, nomeRemetente));
        // Define o destinatário do e-mail
        helper.setTo(dto.getEmailUsuario());
        // Define o assunto, titulo da mensagem
        helper.setSubject("Notificação: " + dto.getNomeTarefa());
        // Define o corpo do e-mail
        String templateHtml = gerarCorpoHtml(dto);
        helper.setText(templateHtml, true);
    }

    // Gera o HTML do e-mail utilizando Thymeleaf.
    private String gerarCorpoHtml(TarefaDTO dto) {
        Context context = new Context();
        context.setVariable("nomeTarefa", dto.getNomeTarefa());
        context.setVariable("dataEvento", dto.getDataEvento());
        context.setVariable("descricao", dto.getDescricao());
        context.setVariable("statusNotificacaoEnum", dto.getStatusNotificacaoEnum().name());
        return templateEngine.process("notificacao", context);
    }

    // Executa o envio do e-mail.
    private void enviar(MimeMessage message) {
        javaMailSender.send(message);
    }
}
