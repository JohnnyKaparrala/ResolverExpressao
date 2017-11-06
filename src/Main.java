import Classes.*;
import java.io.*;


//17186, 17172, 17168
public class Main {
	
	public static void main(String[] args) {
		try {
			System.out.println("Por favor, digite uma expressao aritmetica:");
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String exp = new String(br.readLine());
	        ResolvedorDeExpressao resolvedor = new ResolvedorDeExpressao(exp);
	        
	        resolvedor.resolver();
	        System.out.println(resolvedor.toString());
		}
		catch(Exception erro) {
			erro.printStackTrace();
		}
	}
}
