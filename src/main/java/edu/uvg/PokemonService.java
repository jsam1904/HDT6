package edu.uvg;

import java.util.*;
import java.util.stream.Collectors;

public class PokemonService {
    private Map<String, Pokemon> pokemonData;
    private PokemonCollection userCollection;

    public PokemonService(Map<String, Pokemon> pokemonData, PokemonCollection userCollection) {
        this.pokemonData = pokemonData;
        this.userCollection = userCollection;
    }

    // Operación 1: Agregar un Pokémon a la colección del usuario
    public String addPokemonToUserCollection(String name) {
        Pokemon pokemon = pokemonData.get(name);
        if (pokemon == null) {
            return "Error: El Pokémon " + name + " no se encuentra en los datos.";
        }
        if (!userCollection.addPokemon(pokemon)) {
            return "El Pokémon " + name + " ya está en tu colección.";
        }
        return "Pokémon " + name + " agregado a tu colección.";
    }

    // Operación 2: Mostrar los datos completos de un Pokémon
    public String getPokemonDetails(String name) {
        Pokemon pokemon = pokemonData.get(name);
        if (pokemon == null) {
            return "Error: El Pokémon " + name + " no se encuentra en los datos.";
        }
        return pokemon.toString();
    }

    // Operación 3: Mostrar la colección del usuario (nombre y tipo1), ordenada por tipo1
    public List<String> getUserCollectionSortedByType1() {
        return userCollection.getAllPokemon().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .map(p -> "Nombre: " + p.getName() + ", Tipo1: " + p.getType1())
                .collect(Collectors.toList());
    }

    // Operación 4: Mostrar todos los Pokémon (nombre y tipo1) ordenados por tipo1  
    // Complejidad: Se obtiene la colección y se ordena usando sort, lo que tiene una complejidad O(n log n)
    public List<String> getAllPokemonSortedByType1() {
        return pokemonData.values().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .map(p -> "Nombre: " + p.getName() + ", Tipo1: " + p.getType1())
                .collect(Collectors.toList());
    }

    // Operación 5: Mostrar el nombre del Pokémon que tenga la habilidad indicada
    public List<String> getPokemonByAbility(String ability) {
        return pokemonData.values().stream()
                .filter(p -> p.getAbility().equalsIgnoreCase(ability))
                .map(p -> "Nombre: " + p.getName() + ", Habilidad: " + p.getAbility())
                .collect(Collectors.toList());
    }
}
