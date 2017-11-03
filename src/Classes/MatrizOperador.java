package Classes;

public class MatrizOperador {
	protected static final String lista = "(^*/+-)";
	
	protected static final boolean[][] matriz = { 
			{false,false,false,false,false,false,true},
			{false,false,true ,true ,true ,true ,true},
			{false,false,true ,true ,true ,true ,true},
			{false,false,true ,true ,true ,true ,true},
			{false,false,false,false,true ,true ,true},
			{false,false,false,false,true ,true ,true},
			{false,false,false,false,false,false,false},
			};
	
	public MatrizOperador() {
		//
	}
	
	public boolean temPrioridade( char op1, char op2 ) throws Exception{
		if( lista.indexOf(op1) == -1) 
			throw new Exception("operador invalido: "+ op1);
		if( lista.indexOf(op2) == -1) 
			throw new Exception("operador invalido: "+ op2);
		
		return matriz[lista.indexOf(op1)][lista.indexOf(op2)];
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("  ( ^ * / + - )");
		ret.append('\n');
		
		for ( int i=0; i <= 6; i++) {
			ret.append(lista.charAt(i));
			ret.append(' ');
			for ( int j=0 ; j <= 6; j++) {
				if(matriz[i][j])
					ret.append("T ");
				else
					ret.append("F ");
				
			}
			ret.append('\n');
		}
		
		return ret.toString();
	}
	/*
	public int hashCode() {
		
	}
	
	public boolean equals() {
		
	}*/
}
