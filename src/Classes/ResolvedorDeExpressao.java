package Classes;
import java.util.StringTokenizer;

/**
 * 
 * @author 17186, 17172, 17168
 *
 */
public class ResolvedorDeExpressao {
	protected MatrizOperador matriz = new MatrizOperador();
	protected Pilha pilhaTmp;
	protected Fila filaTmp;
	protected StringTokenizer quebrador;
	protected String exp;
	
	public ResolvedorDeExpressao(String expOriginal) throws Exception{
		this.exp = expOriginal;
	}
	
	public void resolver() throws Exception {
		this.paraNotacaoPolonesa();
		this.resolverNotacaoPolonesa();
	}
	
	protected void paraNotacaoPolonesa() throws Exception{
		quebrador = new StringTokenizer(this.exp, this.matriz.lista, true);
		
	}
	
	protected void resolverNotacaoPolonesa() throws Exception{
		
	}
	
	public int hashCode() {
		
	}
	
	public String toString() {
		
	}
	
	public boolean equals(Object obj) {
		
	}
	
}
