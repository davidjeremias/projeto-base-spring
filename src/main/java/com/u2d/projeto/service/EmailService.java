package com.u2d.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	public JavaMailSender emailSender;

	public void sendSimpleMessage() {
		SimpleMailMessage message = new SimpleMailMessage(); 
		message.setTo("com1.com3@gmail.com","ubarreto21@gmail.com", "df.jorge@gmail.com"); 
		message.setSubject("EMAIL TESTE");
		message.setText("TESTANDO ENVIO DE EMAIL! TUDO COM DEDO NO CÚ MENOS EU!!!");
		emailSender.send(message);
	}
}