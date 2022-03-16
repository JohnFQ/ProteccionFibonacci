package co.com.proteccion.pruebaTecnica.PruebaTecnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class pruebaFibonacciImpl implements pruebaFibonacci{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public int[] serieFibonacci() {
		int minutos = LocalDateTime.now().getMinute();
        int segundos = LocalDateTime.now().getSecond();
        int posicionesIniciales=0, anterior = 0;
        int[] arrayNums = new int[segundos];
        String cadena = String.valueOf(minutos);
        
		for(int j = 0; j< cadena.length(); j++) {
			char digitoMinuto = cadena.charAt(j);
			int nMinutos = Character.getNumericValue(digitoMinuto);
			anterior = posicionesIniciales;//0,2
			posicionesIniciales = nMinutos;//2,9
		}
		arrayNums[0] = anterior;
		arrayNums[1] = posicionesIniciales;
		System.out.println(segundos);
		System.out.println(arrayNums[0]);
		System.out.println(arrayNums[1]);
		for(int x = 2; x < segundos; x++) {
			int ser = arrayNums[x-2] + arrayNums[x-1];
			arrayNums[x] = ser;
			System.out.println(arrayNums[x]);
		}
		
		SimpleMailMessage mailMessagePost = new SimpleMailMessage();
		
		mailMessagePost.setFrom("jhonfredyquiceno46@gmail.com");
		mailMessagePost.setTo("john_quiceno23191@elpoli.edu.co", "johnfquiceno3@gmail.com");
		mailMessagePost.setSubject("Metodo Fibonacci  " + LocalDateTime.now().getHour() +":" +minutos+":"+ segundos);
		mailMessagePost.setText("La serie ejecutada la puedes visualizar en el cliente");
		
		javaMailSender.send(mailMessagePost);
		
		return arrayNums;
	}

}
