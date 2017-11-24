package br.com.fabricadeprogramador;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



public class TucApiApplicationTests {


	public static void main(String[] args) {
		
	
		
		Map<Integer, String> palavras =  new HashMap<>();
		palavras.put(49, "UM");
		palavras.put(50, "DOIS");
		palavras.put(32, " ");
		palavras.put(51, "TRES ");
		palavras.put(52, "QUATRO ");
		
		
		String n = "12 34" ;
		
		if(n.indexOf(" ") !=-1) {
					System.out.println("Palavra Invalida");
			
			
		}else {
			byte[] bytes = n.getBytes();
			
			for (int i = 0; i < bytes.length; i++) {
				System.out.println(palavras.get(new Integer(bytes[i])));
			}
		}
			
	
	
	}

}
