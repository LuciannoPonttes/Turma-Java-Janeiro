package util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CripSenha {
	
	public static String decodificar(String base64) {
		byte[] bytes = Base64.getDecoder().decode(base64);
		return new String(bytes, StandardCharsets.UTF_8);
	}
	
	public static String codificar(String texto) {
        return Base64.getEncoder().encodeToString(texto.getBytes(StandardCharsets.UTF_8));
    }

}
