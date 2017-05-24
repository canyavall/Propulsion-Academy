package config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Bean
	public String smtpHost(){
		return "smtp.gmail.com";
		
	}
	
	@Bean
	public int smtpPort(){
		return 587;		
	}
	
	@Bean
	public JavaMailSender mailSender(){
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
			javaMailSender.setHost(smtpHost());
			javaMailSender.setPort(smtpPort());

			
		Properties prop = javaMailSender.getJavaMailProperties();
			prop.put("mail.transport.protocol", "smtp");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.debug", "true");
			
			javaMailSender.setJavaMailProperties(prop);

			return javaMailSender;
	}
}
