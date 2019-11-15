package com.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailDemoApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;

    //springboot升级了以后，导致这个类没有了
    /*@Autowired
    private VelocityEngine velocityEngine;*/

    private static Logger logger = LoggerFactory.getLogger(EmailDemoApplicationTests.class);

    /**
     * 简单邮件
     */
    @Test
    public void sendSimpleMeaasge() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("it-saas@weherepost.com");
        simpleMailMessage.setTo("2488068563@qq.com");
        simpleMailMessage.setSubject("主题：测试");
        simpleMailMessage.setText("内容：简单邮件测试");
        javaMailSender.send(simpleMailMessage);
    }

    /**
     * 附件邮件
     */
    @Test
    public void sendAttachmentsMail() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("it-saas@weherepost.com");
            helper.setTo("2488068563@qq.com");
            helper.setSubject("主题：测试");
            helper.setText("内容：附件邮件测试");
            FileSystemResource file = new FileSystemResource(new File("D:\\downloads\\a.txt"));
            helper.addAttachment("附件-1.txt", file);
            helper.addAttachment("附件-2.txt", file);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error("发送附件邮件失败" + e.getMessage());
        }
    }

    /**
     * 嵌入静态文件
     */
    @Test
    public void sendInlineMail() {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("it-saas@weherepost.com");
            helper.setTo("2488068563@qq.com");
            helper.setSubject("主题：嵌入静态资源");
            helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

            FileSystemResource file = new FileSystemResource(new File("D:\\downloads\\2.png"));
            helper.addInline("weixin", file);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error("发送静态文件失败" + e.getMessage());
        }
    }


   /* @Test
    public void sendTemplateMail(){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("it-saas@weherepost.com");
            mimeMessageHelper.setTo("2488068563@qq.com");
            mimeMessageHelper.setSubject("模板主题");

            Map<String, Object> model = new HashMap<>();
            model.put("username", "didi");
            String text = VelocityEngineUtils.mergeTemplateIntoString(
                    velocityEngine, "template.vm", "UTF-8", model);
            mimeMessageHelper.setText(text,true);

            javaMailSender.send(mimeMessage);
        }catch (Exception e){

        }
    }*/

}
