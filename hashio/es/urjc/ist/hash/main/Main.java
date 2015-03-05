package es.urjc.ist.hash.main;
import es.urjc.ist.hash.HashStringInt;


public class Main {
			
	public static void agregarEnHash(HashStringInt tabla, int num_elementos, int num_min) {		
		int valor;
		String clave;
		boolean insertado;
		int num_random;
		
		System.out.println("-> Agregando tuplas");
		for(int i = 1; i <= num_elementos; i++){
			num_random = ((int) Math.floor(Math.random()*(num_elementos-num_min+1)+num_min));
			clave = String.valueOf(num_random);
			valor = num_random;
			insertado = tabla.insert(clave, valor);
			
			if(insertado == false){
				System.out.println("no se ha insertado el elemento: {" + clave + " = "+ valor +"}");
			}
		}
		
	}
	
	public static void main(String[] args) {		
		
		HashStringInt tabla = new HashStringInt();
		int num_min = 1;
		int num_elementos = 10;
		
		agregarEnHash(tabla, num_elementos, num_min);

		System.out.println("\n** tabla hash **\n" + tabla);		
		tabla.writeTo("/tmp/hash.out");
		
		HashStringInt tabla2 = HashStringInt.readFrom("/tmp/hash.out");
		
		System.out.println("\n** tabla hash 2 **\n" + tabla2);
	}
}
