import java.util.Arrays;
import java.util.Scanner;

class MetodosOrdenamiento{
	int[] contador = new int[3];
	
	public void ordenarInsercion(int [] numeros) {
		int aux;
		int comp = 0, inter = 0, recorr = 0;
		for(int i = 1; i < numeros.length; i++) {
			recorr++;
			aux = numeros[i];
			for(int j = i-1; j > 0 && numeros[j] > aux; j--) {
				comp++;
				recorr++;
				inter++;
				numeros[j+1] = numeros[j];
				numeros[j] = aux;
			}
		}
		System.out.println("Num. recorridos: " + recorr);
		System.out.println("Num. intercambios: " + inter);
		System.out.println("Num. comparaciones: " + comp);
	}
	
	public void ordenarSeleccion(int[] numeros) {
		for(int i = 0; i < numeros.length - 1; i++) {
			for(int j = i + 1; j < numeros.length; j++) {
				if(numeros[i] > numeros[j]) {
					int orden = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = orden;
				}
			}
		}
	}
		
	public int[] quicksort(int[] array, int izq, int der) {
		int pivote = array[izq];
		int i = izq, j = der;
		int aux;
		while(i < j) {
			while(array[i] <= pivote && i < j) i++;
			while(array[j] > pivote) j--;
			if(i < j) {
				aux = array[i];
				array[i] = array[j];
				array[j] = aux;
			}
		}
		array[izq] = array[j];
		array[j] = pivote;
		if(izq < j - 1) {
			quicksort(array, izq, j - 1);
		}
		if(j + 1 < der) {
			quicksort(array, j + 1, der);
		}
		return array;
	}
	
	public void ordenShellsort(int[] numeros) {
		int intervalo = numeros.length / 2;
		
		while(intervalo > 0) {
			for(int i = intervalo; i < numeros.length; i++) {
				int j = i - intervalo;
				while(j >= 0) {
					int k = j + intervalo;
					if(numeros[j] <= numeros[k]) {
						j = -1;
					}else {
						int aux = numeros[j];
						numeros[j] = numeros[k];
						numeros[k] = aux;
						j -= intervalo;
					}
				}
			}
			intervalo = intervalo/2;
		}
	}//metodo Shellsort
		
	public void ordenRadix(int[]numeros) {
        if(numeros.length == 0)
            return;
            int[][] np = new int[numeros.length][2];
            int[] q = new int[0x100];
            int i,j,k,l,f = 0;
            for(k=0;k<4;k++) {
               for(i=0;i<(np.length-1);i++)
               np[i][1] = i+1;
               np[i][1] = -1;
               for(i=0;i<q.length;i++)
               q[i] = -1;
               for(f=i=0;i<numeros.length;i++) {
                  j = ((0xFF<<(k<<3))&numeros[i])>>(k<<3);
                  if(q[j] == -1)
                  l = q[j] = f;
               else {
                  l = q[j];
                  while(np[l][1] != -1)
                  l = np[l][1];
                  np[l][1] = f;
                  l = np[l][1];
               }
               f = np[f][1];
               np[l][0] = numeros[i];
               np[l][1] = -1;
            }
            for(l=q[i=j=0];i<0x100;i++)
            for(l=q[i];l!=-1;l=np[l][1])
                numeros[j++] = np[l][0];
         }//for
  }//metodo
	
	
	public void contadorRecInterComp() {
		System.out.println("Numero de recorridos realizados: " + contador[0]);
		System.out.println("Numero de intercambios realizados: " + contador[1]);
		System.out.println("Numero de comparaciondes realizadas: " + contador[2]);
		contador[0] = 0;
		contador[1] = 0;
		contador[2] = 0;
	}
}
public class PruebasEstres {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int[] numeros = {7, 11, 28, 4, 22, 21, 1, 4, 2, 2, 48};
		long tInicio, tFin;
		MetodosOrdenamiento mo = new MetodosOrdenamiento();
		int op1 = 0;
		int op2 = 0;
		
		int[] milElementos = new int[1000];
		for(int i = 0; i < milElementos.length; i++) {
			milElementos[i] = (int)(Math.random() * 1000 + 1);
		}
		int[] diezMilElementos = new int[10000];
		for(int i = 0; i < diezMilElementos.length; i++) {
			diezMilElementos[i] = (int)(Math.random() * 10000 + 1);
		}
		int[] cienMilElementos = new int[100000];
		for(int i = 0; i < cienMilElementos.length; i++) {
			cienMilElementos[i] = (int)(Math.random() * 100000 + 1);
		}
		do {
			System.out.println("--- Menú ---");
			System.out.println("1.- Ordenación por inserción");
			System.out.println("2.- Ordenación por selección");
			System.out.println("3.- Ordenación por Quicksort");
			System.out.println("4.- Ordenación por ShellSort");
			System.out.println("5.- Ordenación por Radix");
			System.out.println("6.- Salir");
			
			System.out.println("Elija una opción: ");
			op1 = entrada.nextInt();
				switch(op1) {
				
				case 1: do {
						System.out.println("1.- Ordenar numeros ya ingresados");
				        System.out.println("2.- Ordenar 1000 elementos");
				        System.out.println("3.- Ordenar 10000 elementos");
				        op2 = entrada.nextInt();
				        switch(op2) {
				        case 1: int[] numerosI = {7, 11, 28, 4, 22, 21, 1, 4, 2, 2, 48};
								System.out.println("Numeros desordenados: " + Arrays.toString(numerosI));
								mo.ordenarInsercion(numerosI);
								System.out.println("Numeros ordenados: " + Arrays.toString(numerosI));
						break;
				        case 2: tFin = tInicio = 0;
				        		System.out.println("--- Ordenar 1000 elementos ---");
				        		tInicio = System.nanoTime();
				        		mo.ordenarInsercion(milElementos);
				        		tFin = System.nanoTime();
				        		System.out.println("Tardó en ordenar: " + (tFin - tInicio));
				        break;
				        case 3: tFin = tInicio = 0;
				        		System.out.println("--- Ordenar 10000 elementos ---");
				        		tInicio = System.nanoTime();
				        		mo.ordenarInsercion(diezMilElementos);
				        		tFin = System.nanoTime();
				        		System.out.println("Tardó en ordenar: " + (tFin - tInicio));
				        }
				}while(op2 != 4);
				break;
				case 2: int[] numerosS = {7, 11, 28, 4, 22, 21, 1, 4, 2, 2, 48};
					System.out.println("Numeros desordenados: " + Arrays.toString(numerosS));
						mo.ordenarSeleccion(numerosS);
						System.out.println("Numeros ordenados: " + Arrays.toString(numerosS));
				break;
				case 3: int[] numerosQ = {7, 11, 28, 4, 22, 21, 1, 4, 2, 2, 48};
					System.out.println("Numeros desordenados: " + Arrays.toString(numerosQ));
					mo.quicksort(numerosQ, 0, numeros.length - 1);
						System.out.println("Numeros ordenados: " + Arrays.toString(numerosQ));
				break;
				case 4: int[] numerosSh = {7, 11, 28, 4, 22, 21, 1, 4, 2, 2, 48}; 
					System.out.println("Numeros desordenados: " + Arrays.toString(numerosSh));
						mo.ordenShellsort(numerosSh);
						System.out.println("Numeros ordenados: " + Arrays.toString(numerosSh));
				break;
				case 5: int[] numerosR = {7, 11, 28, 4, 22, 21, 1, 4, 2, 2, 48}; 
					System.out.println("Numeros desordenados: " + Arrays.toString(numerosR));
						mo.ordenRadix(numerosR);
						System.out.println("Numeros ordenados: " + Arrays.toString(numerosR));
				break;
				case 6: break;
				}
		} while (op1 != 6);
	}

}
