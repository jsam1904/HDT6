package edu.uvg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Clase encargada de cargar los datos de Pokémon desde un archivo.
 * 
 * @autor 
 * Javier Alvarado - 24546
 */
public class PokemonDataLoader {

    /**
     * Carga los datos de Pokémon desde un archivo y los almacena en un Map.
     * 
     * @param filename  El nombre del archivo que contiene los datos de Pokémon.
     * @param mapOption La opción para seleccionar la implementación de Map.
     *                  1 para HashMap, 2 para TreeMap, 3 para LinkedHashMap.
     * @return Un Map que contiene los datos de Pokémon cargados.
     */
    public static Map<String, Pokemon> loadPokemonData(String filename, int mapOption) {
        Map<String, Pokemon> pokemonMap = MapFactory.getMapImplementation(mapOption);
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            line = br.readLine(); // Leer la primera línea (encabezado)
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String name = parts[0].trim();
                    String type1 = parts[1].trim();
                    String ability = parts[2].trim();
                    Pokemon pokemon = new Pokemon(name, type1, ability);
                    pokemonMap.put(name, pokemon);
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
        return pokemonMap;
    }
}