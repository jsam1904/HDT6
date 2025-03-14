package edu.uvg;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase fábrica para obtener diferentes implementaciones de Map.
 * 
 * @autor
 * Javier Alvarado - 24546
 */
public class MapFactory {

    /**
     * Obtiene una implementación de Map basada en la opción proporcionada.
     * 
     * @param option La opción para seleccionar la implementación de Map.
     *               1 para HashMap, 2 para TreeMap, 3 para LinkedHashMap.
     * @return La implementación de Map seleccionada.
     */
    public static Map<String, Pokemon> getMapImplementation(int option) {
        switch (option) {
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                System.out.println("Opción no válida, se utilizará HashMap por defecto");
                return new HashMap<>();
        }
    }
}