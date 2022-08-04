package org.asterisk.ums.server.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.asterisk.ums.server.service.MessageMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * @author yihaosun
 * @date 2022/8/3 15:17
 */
@Service
@Slf4j
public class MessageMailServiceImpl implements MessageMailService {
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public void sendSimpleEmail(String receiver, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    @Override
    public void sendComplexEmail(String receiver, String subject, String text) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(text, true);
            //设置邮件静态资源
            // FileSystemResource res=new FileSystemResource(new File(rscPath));
            // helper.addInline(rscId, res);
            // 设置附件地址
            // FileSystemResource file=new FileSystemResource(new File(filePath));
            // String fileName=filePath.substring(filePath.lastIndexOf(File.separator));
            // helper.addAttachment(fileName, file);
            mailSender.send(message);
            log.info("邮件发送成功");
        } catch (MessagingException | javax.mail.MessagingException e) {
            log.info("邮件发送失败 : {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
