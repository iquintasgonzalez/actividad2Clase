/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad2.clase;

/**
 *
 * @author nacho
 */
public class Actividad2Clase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ejercicio 1
    public static <E> boolean completo (ArbolBinario<E> a){
    	if (a.esVacio()) return true;
    	else if (a.hijoIzq().esVacio() && a.hijoDer().esVacio()) return true;
    	else if (a.hijoIzq().esVacio() || a.hijoDer().esVacio()) return false;
    	else return completo(a.hijoIzq()) && completo(a.hijoDer());
    }
    
    //Ejercicio 2
    public static <E> boolean identicos (ArbolBinario<E> a, ArbolBinario<E> b){
        if (!a.esVacio() && !b.esVacio())
            return a.raiz().equals(b.raiz()) && identicos(a.hijoIzq(), b.hijoIzq()) && identicos(a.hijoDer(), b.hijoDer());
        else return a.esVacio() && b.esVacio();
    }
       
        //Ejercicio 3
    public static <E> boolean esta (ArbolBinario<E> a, E elem){
        if (a.esVacio())
            return false;
        else if (a.raiz().equals(elem))
            return true;
        else return esta(a.hijoIzq(), elem) || esta(a.hijoDer(), elem);
    }
    
    //Ejercicio 4 
    public static <E> int contarNivel(ArbolBinario<E> a, int nivel){
        if (a.esVacio()) return 0;
        else if (nivel == 0) return 1;
            else return contarNivel(a.hijoIzq(), nivel-1) + contarNivel(a.hijoDer(), nivel-1);
    }
    
     //Ejercicio 5 
    public static <E> ArbolBinario<E> eliminarHojas(ArbolBinario<E> arbol){
    	if (arbol.esVacio()) return new EnlazadoArbolBinario<>(); 
    	else if (arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio())
    		return new EnlazadoArbolBinario<>();
    	   	else return new EnlazadoArbolBinario<>(arbol.raiz(), eliminarHojas(arbol.hijoIzq()),eliminarHojas(arbol.hijoDer()));
    	}
    
    //Ejercicio 6
    private static int maximo(int num1, int num2){
    	return num1>num2? num1:num2;
    }
    public static <E> int altura(ArbolBinario<E> a){
    	if (a.esVacio()) return -1;
        else if (a.hijoIzq().esVacio() && a.hijoDer().esVacio())
                    return 0;
              else return 1 + maximo(altura(a.hijoIzq()), altura(a.hijoDer()));   
    }
    }
    
}
