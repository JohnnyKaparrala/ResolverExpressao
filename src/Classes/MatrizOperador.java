package Classes;

public class MatrizOperador {
	public static final String lista = "(^*/+-)";
	
	protected static final boolean[][] matriz = { 
			//(      ^     *     /     +     -     )	
			{false,false,false,false,false,false,true },// )
			{false,false,true ,true ,true ,true ,true },// ^
			{false,false,true ,true ,true ,true ,true },// *
			{false,false,true ,true ,true ,true ,true },// /
			{false,false,false,false,true ,true ,true },// +
			{false,false,false,false,true ,true ,true },// -
			{false,false,false,false,false,false,false},// )
			};
	
	public MatrizOperador() {
		//
	}
	
	public boolean temPrioridade( char simbTopo, char simbSeq ) throws Exception{
		if( lista.indexOf(simbTopo) == -1) 
			throw new Exception("operador invalido: "+ simbTopo);
		if( lista.indexOf(simbSeq) == -1) 
			throw new Exception("operador invalido: "+ simbSeq);
		
		return matriz[lista.indexOf(simbTopo)][lista.indexOf(simbSeq)];
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
	
	public int hashCode() {
		int ret = 666;
		
		ret = ret * 7 + new Integer( lista.hashCode() );
		
		return ret;
	}
	
	public boolean equals(Object obj) {
		if ( this == obj)
            return true;
		
		if ( obj == null)
			return false;

	    if (!(obj instanceof MatrizOperador))
	            return false;
	    //se eh instancia de MatrizOperador, eh igual
	    return true;
	}
}
