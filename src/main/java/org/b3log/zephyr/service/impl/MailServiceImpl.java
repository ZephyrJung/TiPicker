package org.b3log.zephyr.service.impl;

import freemarker.template.Template;
import org.b3log.zephyr.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zephyr on 2017/3/7.
 * http://blog.didispace.com/springbootmailsender/
 */

@Service
public class MailServiceImpl
//        implements MailService
{

//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Autowired
//    FreeMarkerConfigurer freeMarkerConfigurer;
//
//    @Override
//    public void sendSimpleMail() throws Exception {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("2895205695@qq.com");
//        message.setTo("zephyrjung@126.com");
//        message.setSubject("主题：简单邮件");
//        message.setText("测试邮件内容");
//        mailSender.send(message);
//    }
//
//    public void sendAttachmentsMail() throws Exception {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.setFrom("dyc87112@qq.com");
//        helper.setTo("dyc87112@qq.com");
//        helper.setSubject("主题：有附件");
//        helper.setText("有附件的邮件");
//        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
//        helper.addAttachment("附件-1.jpg", file);
//        helper.addAttachment("附件-2.jpg", file);
//        mailSender.send(mimeMessage);
//    }
//
//    public void sendInlineMail() throws Exception {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.setFrom("dyc87112@qq.com");
//        helper.setTo("dyc87112@qq.com");
//        helper.setSubject("主题：嵌入静态资源");
//        helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);
//        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
//        helper.addInline("weixin", file);
//        mailSender.send(mimeMessage);
//    }
//
//    public void sendTemplateMail() throws Exception {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.setFrom("dyc87112@qq.com");
//        helper.setTo("dyc87112@qq.com");
//        helper.setSubject("主题：模板邮件");
//        Map<String, Object> model = new HashMap();
//        model.put("username", "didi");
//        Template tpl=freeMarkerConfigurer.getConfiguration().getTemplate("registerUser.ftl");
//        String text = FreeMarkerTemplateUtils.processTemplateIntoString(tpl,model);
//        helper.setText(text, true);
//        mailSender.send(mimeMessage);
//    }
}
