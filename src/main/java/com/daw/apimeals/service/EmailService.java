package com.daw.apimeals.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.daw.apimeals.user.User;

import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private Configuration freemarkerConfig;

	public void sendSimpleMessage(User user) throws MessagingException, IOException, TemplateException {

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

		Template t = freemarkerConfig.getTemplate("EmailTemplate.ftl");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", user.getName()); 
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		helper.setTo(user.getEmail());
		helper.setText(html, true);
		helper.setSubject("Gracias por registrarte en Apimeals");
		helper.setFrom("no-reply@hotmail.es");

		emailSender.send(message);
	}

}
