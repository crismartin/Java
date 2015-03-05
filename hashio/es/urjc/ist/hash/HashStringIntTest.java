package es.urjc.ist.hash;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashStringIntTest {

	@Test
	public void test() {

		// creo una tabla hash con 9 elementos
		HashStringInt tabla = new HashStringInt();
		String clave;
		for(int i = 1; i <= 9; i++){
			clave = "clave" + String.valueOf(i);
			tabla.insert(clave, i);
		}
		
		// escribo la tabla en un fichero ("/tmp/hashtest.out")
		String fichero = "/tmp/hashtest.out";
		tabla.writeTo(fichero);
		
		// creo una nueva tabla y la inicializo leyendo sus datos desde el fichero anterior
		HashStringInt tabla2 = HashStringInt.readFrom(fichero);
		
		// compruebo si 'tabla2' no es nula, para esto me creo una tabla sin elementos
		HashStringInt tabla_dummy = new HashStringInt();
		
		// Comparo si las tablas son iguales o no
		String str_tabla2 = tabla2.toString();
		String str_tablad = tabla_dummy.toString();
		
		if(str_tabla2.equals(str_tablad)){
			fail("Son iguales. Puede que el fichero este vacio o hay un error de lectura");
		}
		
		// Comparo si las tablas 'tabla' y 'tabla2' son iguales o no (deberian serlo)
		String str_tabla1 = tabla.toString();
		
		System.out.println(tabla);
		System.out.println(tabla2);
		
		if(!(str_tabla2.equals(str_tabla1))){
			fail("No son iguales. Hay un error de E/S (lectura/escritura)");
		}		
	}
}
