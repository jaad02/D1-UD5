package com.u4.springquiz;

public class CalcularResultados {


    public static int CalcularResultadoP1(String seleccion) {
        if (seleccion.equals("Francia")) {
            return 20;
        }
        return 0;
    }

    public static int CalcularResultadoP2(String[] seleccion) {
        int size = 0;
        int respuestasCorrectas = 0;
        int respuestasIncorrectas = 0;
        for (String opcion : seleccion) {
            if (opcion.equals("Luka") || opcion.equals("CR7")) {
                respuestasCorrectas++;

            } else {
                respuestasIncorrectas++;
            }
            size++;
        }
        int totalRespuestas = respuestasCorrectas - respuestasIncorrectas;
        if (totalRespuestas == 2) {
            return 20;
        }
        if (totalRespuestas == 1) {
            return 10;
        }
        return 0;
    }

    public static int CalcularResultadoP3(String seleccion) {
        String[] opcionesValidas = {"andriy", "shevchenko", "ronaldinho", "fabio", "cannavaro", "kaka", "cristiano", "ronaldo", "lionel", "messi"};
        String[] selecciones = seleccion.split(",");

        int size = 0;
        int respuestasCorrectas = 0;
        int respuestasIncorrectas = 0;
        boolean correcta = false;
        for (String opcion : selecciones) {
            String opcionMinuscula = opcion.toLowerCase();
            for (String opcioValida : opcionesValidas) {
                if (opcionMinuscula.contains(opcioValida)) {
                    correcta = true;
                    break;
                }

            }
            if (correcta) {
                respuestasCorrectas++;
            } else {
                respuestasIncorrectas++;
            }
            correcta = false;
            size++;
        }


        int totalRespuestas = respuestasCorrectas - respuestasIncorrectas;
        int puntos = 0;
        if (totalRespuestas > 0) {
            puntos = totalRespuestas * 10;
        }
        return puntos;
    }

    public static int CalcularResultadoP4(String seleccion) {
        if (seleccion.equals("CR7")) return 20;
        return 0;
    }

    public static int CalcularResultadoP5(String seleccion) {
        if (seleccion.equals("Sudafrica")) {
            return 20;
        }
        return 0;
    }

    public static int CalcularResultadoP6(String seleccion) {
        String[] respuesta = {"real madrid", "real", "madrid"};
        seleccion = seleccion.toLowerCase();
        for (String respuestaValida : respuesta) {
            if (seleccion.contains(respuestaValida)) {
                return 20;

            }
        }
        return 0;
    }

    public static int CalcularResultadoP7(String[] seleccion) {

        for (String respuesta : seleccion) {
            if (respuesta.equals("Luis") ) {
                return 20;
            }

        }
        return 0;

    }
    public static Categoria determinarCategoria(int puntuacion) {
        if (puntuacion == 0) {
            return Categoria.FC_NEGREIRA;
        } else if (puntuacion > 0 && puntuacion <= 50) {
            return Categoria.CLUB_DEL_PUEBLO;
        } else if (puntuacion > 50 && puntuacion <= 100) {
            return Categoria.LOS_SEGUNDONES;
        } else {
            return Categoria.LOS_REYES_DE_EUROPA;
        }
    }
}
