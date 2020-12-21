/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.util.HashMap;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

/**
 *
 * @author asus
 */
@Service
public class EmailService {
    
    @Autowired
    private Configuration freemaker;
    @Autowired
    private JavaMailSender javaMailSender;

//	@Autowired
//	private FreeMarkerConfigurer freemarkerConfig;
//
//	public void sendWelcomeEmail(EmailDTO emailDTO) {
//		System.out.println("##### Started sending welcome email ####");
//
//		MimeMessage mimeMessage = mailSender.createMimeMessage();
//		try {
//
//			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,
//					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//					StandardCharsets.UTF_8.name());
//
//			String templateContent = FreeMarkerTemplateUtils
//					.processTemplateIntoString(freemarkerConfig.getConfiguration()
//							.getTemplate("/email/welcome.ftlh"),
//							emailDTO.getEmailData());
//
//			helper.setTo(emailDTO.getTo());
//			helper.setSubject(emailDTO.getSubject());
//			helper.setText(templateContent, true);
//			mailSender.send(mimeMessage);
//
//			System.out.println("######## Welcome email sent ######");
//		} catch (Exception e) {
//			System.out.println("Sending welcome email failed, check log...");
//			e.printStackTrace();
//		}
//	}
//    public void sendMail(String toEmail, String subject, String message) {
//        mailMessage = new SimpleMailMessage();
//
//        mailMessage.setTo(toEmail);
//        mailMessage.setTo(subject);
//        mailMessage.setTo(message);
//
//        mailMessage.setFrom("melati@gmail.com");
//
//        javaMailSender.send(mailMessage);
//
//    }

    public void notif(String kirimemail, String subject, String from, Map<String, Object> tulisan) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        Map<String, Object> model = new HashMap();
//        model.put("name", "Bambang");
//        model.put("tujuandinas", "Kunjungan");
//        model.put("kendaraan", "Kereta");
//        model.put("kotaasal", "Yogyakarta");
//        model.put("kotatujuan", "Semarang");
//        model.put("waktuberangkat", "08.36");
//        model.put("waktupulang", "22.20");
//        model.put("tanggalberangkat", "11 Desember 2020");
//        model.put("tanggalpulang", "13 Desember 2020");
//        model.put("hotel", "Hotel Satu kasur dengan AC");

        freemaker.setClassForTemplateLoading(this.getClass(), "/templates/");

        Template t = freemaker.getTemplate("template.ftlh");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, tulisan);
//        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

        helper.setTo(kirimemail);
        helper.setText(text, true);
        helper.setFrom(from);
        helper.setSubject(subject);
//        helper.addAttachment(email, file);
        javaMailSender.send(message);

    }


    
    
}
