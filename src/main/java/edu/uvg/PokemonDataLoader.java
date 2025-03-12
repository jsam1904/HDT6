package edu.uvg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class PokemonDataLoader {
    public static Map<String, Pokemon> loadPokemonData(String filename, int mapOption) {
        Map<String, Pokemon> pokemonMap = MapFactory.getMapImplementation(mapOption);
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            line = br.readLine();
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
