package com.u4.springquiz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/*
 Ejemplo de clase para mantener un mapa de puntuaciones, cargarlo de disco en el constructor
 y guardar en disco tras cada cambio.

 De esta manera vuestro controlador puede definir una variable global RepositorioPuntuaciones

 Al ser un mapa no permite repetidos
*/

public class RepositorioPuntuaciones {
    protected Map<String, Integer> puntuaciones;
    protected final static String RUTA_FICHERO =""+ new File("datos.data").getAbsolutePath() ;
    public RepositorioPuntuaciones() {
        super();
        puntuaciones = new HashMap<String, Integer>();
        carga();
        System.out.println(RUTA_FICHERO);

    }

    public void carga() {
        // TRAZA PARA SABER DÓNDE RESUELVE LA RUTA RELATIVA:
        // System.out.println((new File(RUTA_FICHERO)).getAbsolutePath());
        // intentamos leer el mapa del archivo, si no podemos quedará vacío
        try (
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(RUTA_FICHERO))
        ) {
            puntuaciones = (HashMap<String, Integer>) entrada.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Problema leyendo archivo " + RUTA_FICHERO);
            this.guardar();
        }
    }

    public boolean guardar() {
        try (
                ObjectOutputStream cierre = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO))
        ) {
            cierre.writeObject(puntuaciones);
        } catch (IOException e1) {
            System.err.println("ERROR GUARDANDO PUNTUACIONES");
            return false;
        }
        return true;
    }

    public Map<String, Integer> getAll() {
        return puntuaciones;
    }

    public Integer getPuntuación(String nombre) {
        return puntuaciones.get(nombre);
    }

    public void anadir(String nombre, Integer puntos) {
        puntuaciones.put(nombre, puntos);
        guardar();
    }

    public void eliminar(String nombre) {
        puntuaciones.remove(nombre);
        guardar();
    }

    public void modificar(String nombre, Integer puntos) {
        puntuaciones.put(nombre, puntos);
        guardar();
    }

    // Prueba de concepto para ejecutar desde Eclipe o Visual
    /*
	public static void main(String[] args) {
		RepositorioPuntuaciones repo = new RepositorioPuntuaciones();
		System.out.println(repo.getAll());
		//repo.anadir("Javi",10);
		//repo.anadir("Luisa", 12);
		//repo.guardar();

	}
    */

}
