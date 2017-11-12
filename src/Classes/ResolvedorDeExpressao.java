package Classes;
import java.util.StringTokenizer;

/**
 * 
 * @author 17186, 17172, 17168
 *
 */
public class ResolvedorDeExpressao {
	protected MatrizOperador matriz = new MatrizOperador();
	protected Pilha<String> pilhaTmp;
	protected Fila<String>  filaExpPolonesa;
	protected StringTokenizer quebrador;
	protected String exp;

	public ResolvedorDeExpressao(String expOriginal) throws Exception{
		this.exp = expOriginal;
		quebrador = new StringTokenizer(this.exp, MatrizOperador.lista, true);
		pilhaTmp = new Pilha<String>();
		filaExpPolonesa = new Fila<String>();
	}
	
	public void resolver() throws Exception {
		this.paraNotacaoPolonesa();
		this.resolverNotacaoPolonesa();
	}
	
	protected void paraNotacaoPolonesa() throws Exception{
		 while( quebrador.hasMoreTokens()) {
			 String str = quebrador.nextToken();
			 
			 if( this.matriz.lista.contains(str)) {
				 filaExpPolonesa.enfileire(str);
			 }else{
				 pilhaTmp.empilhe(str);
			 }
			
		 }
	}
	
	protected void resolverNotacaoPolonesa() throws Exception{
        char op;
        double num1;
        double num2;    

        while() {
            if()
            {
                this.pilhaTmp.empilhe(this.filaTmp.getElemento());
                this.filaTmp.desenfileire();
            }
            else
            {
                op = (char)this.filaTmp.getElemento();
                this.filaTmp.desenfileire();
                num1 = (Integer)this.pilhaTmp.getElement();
                this.pilhaTmp.desempilhe();
                num2 = (Integer)this.pilhaTmp.getElement();
                this.pilhaTmp.desempilhe();
                    
                this.pilhaTmp.empilhe(fazOperacao(num1,num2,op));
                           
            }
        }
	}
	protected double fazOperacao(double num1,double num2,  char op) throws Exception
       {
           double ret = 0;//ele ira ser inicializado de qualqer jeito mas nao sabe disso
           switch(op){
               
                case'+': ret =num1 + num2;
                        break;
                case'-': ret =num1 - num2;
                        break;
                case'/': ret =num1 / num2;
                        break;        
                case'*': ret =num1 * num2;
                        break;        
                case'^': ret = Math.pow(num1, num2);
                        break;     
                default: throw new Exception("Operador invalido.");
           }
           return ret;      
       }
       
       
	public int hashCode() {
            
            int ret = 666;
            
            ret =  ret*7 + this.matriz.hashCode();
            ret =  ret*7 + this.pilhaTmp.hashCode();
            ret =  ret*7 + this.filaTmp.hashCode();
            ret =  ret*7 + this.quebrador.hashCode();        
            ret =  ret*7 + this.exp.hashCode();
            
            return ret;
            
	}
	
	public String toString() {
		
	}
	
	public boolean equals(Object obj) {
            
            if(this==obj)
                return true;
            if(obj==null)
                return false;
            if(!(obj instanceof ResolvedorDeExpressao))
                return false;
            
            ResolvedorDeExpressao resolvE = (ResolvedorDeExpressao)obj;
            
            if(!(this.matriz.equals(resolvE.matriz)))
                return false;
            if(!(this.pilhaTmp.equals(resolvE.pilhaTmp)))
                return false;
            if(!(this.filaTmp.equals(resolvE.filaTmp)))
                return false;
            if(!(this.quebrador.equals(resolvE.quebrador)))
                return false;
            if(!(this.exp.equals(resolvE.exp)))
                return false; 
            
            return true;
		
	}
	
}