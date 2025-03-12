package edu.uvg;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase que proporciona servicios relacionados con Pokémon, incluyendo la gestión de la colección del usuario.
 * 
 * @autor
 * Javier Alvarado - 24546
 */
public class PokemonService {
    private Map<String, Pokemon> pokemonData;
    private PokemonCollection userCollection;

    /**
     * Constructor para crear un nuevo servicio de Pokémon.
     * 
     * @param pokemonData     Los datos de Pokémon disponibles.
     * @param userCollection  La colección de Pokémon del usuario.
     */
    public PokemonService(Map<String, Pokemon> pokemonData, PokemonCollection userCollection) {
        this.pokemonData = pokemonData;
        this.userCollection = userCollection;
    }

    /**
     * Agrega un Pokémon a la colección del usuario.
     * 
     * @param name El nombre del Pokémon a agregar.
     * @return Un mensaje indicando el resultado de la operación.
     */
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

    /**
     * Obtiene los detalles completos de un Pokémon.
     * 
     * @param name El nombre del Pokémon.
     * @return Una cadena con los detalles del Pokémon o un mensaje de error si no se encuentra.
     */
    public String getPokemonDetails(String name) {
        Pokemon pokemon = pokemonData.get(name);
        if (pokemon == null) {
            return "Error: El Pokémon " + name + " no se encuentra en los datos.";
        }
        return pokemon.toString();
    }

    /**
     * Muestra la colección del usuario (nombre y tipo1), ordenada por tipo1.
     * 
     * @return Una lista de cadenas con el nombre y tipo1 de cada Pokémon en la colección del usuario.
     */
    public List<String> getUserCollectionSortedByType1() {
        return userCollection.getAllPokemon().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .map(p -> "Nombre: " + p.getName() + ", Tipo1: " + p.getType1())
                .collect(Collectors.toList());
    }

    /**
     * Muestra todos los Pokémon (nombre y tipo1) ordenados por tipo1.
     * 
     * @return Una lista de cadenas con el nombre y tipo1 de cada Pokémon en los datos.
     */
    public List<String> getAllPokemonSortedByType1() {
        return pokemonData.values().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .map(p -> "Nombre: " + p.getName() + ", Tipo1: " + p.getType1())
                .collect(Collectors.toList());
    }

    /**
     * Muestra el nombre del Pokémon que tenga la habilidad indicada.
     * 
     * @param ability La habilidad a buscar.
     * @return Una lista de cadenas con el nombre y habilidad de cada Pokémon que tenga la habilidad indicada.
     */
    public List<String> getPokemonByAbility(String ability) {
        return pokemonData.values().stream()
                .filter(p -> p.getAbility().equalsIgnoreCase(ability))
                .map(p -> "Nombre: " + p.getName() + ", Habilidad: " + p.getAbility())
                .collect(Collectors.toList());
    }
}