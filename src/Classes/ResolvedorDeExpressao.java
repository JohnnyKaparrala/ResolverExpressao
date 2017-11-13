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
	
	public String paraNotacaoPolonesa() throws Exception{
		 while( quebrador.hasMoreTokens()) {
			 String str = quebrador.nextToken();
			 
			 if( this.matriz.lista.contains(str)) {
                           
                             if(!(this.pilhaTmp.vazia())&& this.matriz.temPrioridade(this.pilhaTmp.getElemento().charAt(0), str.charAt(0)))
                                do{
                                    this.filaExpPolonesa.enfileire(this.pilhaTmp.getElemento());
                                    this.pilhaTmp.desempilhe();
                                }     
                                while (!(this.pilhaTmp.vazia())&& this.matriz.temPrioridade(this.pilhaTmp.getElemento().charAt(0), str.charAt(0)));

                            pilhaTmp.empilhe(str);
			}
                        else{
                            if( ehNumero(str)){
                                    filaExpPolonesa.enfileire(str);
                            }
                            else{
                                throw new Exception("Expressao invalida.");
                            }
                         }
			
		 }
                 
                 if(!(this.pilhaTmp.vazia())) 
                 do{
                     this.filaExpPolonesa.enfileire(this.pilhaTmp.getElemento());
                     this.pilhaTmp.desempilhe();
                 }
                 while (!(this.pilhaTmp.vazia()));
                    
                 return this.filaExpPolonesa.toString();
                 
	}
	
    protected void resolverNotacaoPolonesa() throws Exception{
         
            char op;   
            double num1;
            double num2;
            do
            {
                if(ehNumero(this.filaExpPolonesa.getElemento()))
                {
                    this.pilhaTmp.empilhe(this.filaExpPolonesa.getElemento());
                    this.filaExpPolonesa.desenfileire();
                }
                else
                {
                    op = this.filaExpPolonesa.getElemento().charAt(0);//string[0] = char
                    this.filaExpPolonesa.desenfileire();
                    num1 = Double.parseDouble(this.filaExpPolonesa.getElemento());
                    this.pilhaTmp.desempilhe();
                    num2 = Double.parseDouble(this.filaExpPolonesa.getElemento());
                    this.pilhaTmp.desempilhe();

                    this.pilhaTmp.empilhe(String.valueOf(calcular(num1,num2,op)));
                }
            }
            while(!(this.filaExpPolonesa.vazia())) ;
        }
          
       protected boolean ehNumero(String s){
           
           try{
                double teste = Double.parseDouble(s);
                return true;
           }
           catch(Exception erro)
           {   
           }
            return false;
        }
	protected double calcular(double num1,double num2,  char op) throws Exception
       {
           double ret = 0;
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
            ret =  ret*7 + this.filaExpPolonesa.hashCode();
            ret =  ret*7 + this.quebrador.hashCode();        
            ret =  ret*7 + this.exp.hashCode();
            
            return ret;
            
	}
	
	public String toString() {
		
		StringBuilder ret = new StringBuilder();
		ret.append("Expressao original:\n");
		ret.append(this.exp.toString() + "\n");
		ret.append("Resultado:\n");
		try {
			if(!this.pilhaTmp.vazia()) {
				ret.append(this.pilhaTmp.getElemento().charAt(0));
			}else {
				ret.append("Ainda nao calculado.");
			}
		} catch (Exception e) {
		}
		
		return ret.toString();
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
            if(!(this.filaExpPolonesa.equals(resolvE.filaExpPolonesa)))
                return false;
            if(!(this.quebrador.equals(resolvE.quebrador)))
                return false;
            if(!(this.exp.equals(resolvE.exp)))
                return false; 
            
            return true;
		
	}
	
}
