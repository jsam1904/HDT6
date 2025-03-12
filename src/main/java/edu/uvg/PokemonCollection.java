package edu.uvg;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa la colección de Pokémon del usuario.
 * 
 * @autor
 * Javier Alvarado - 24546
 */
public class PokemonCollection implements Serializable {
    private Map<String, Pokemon> userCollection;

    /**
     * Constructor para crear una nueva colección de Pokémon.
     */
    public PokemonCollection() {
        userCollection = new HashMap<>();
    }

    /**
     * Agrega un Pokémon a la colección del usuario.
     * 
     * @param pokemon El Pokémon a agregar.
     * @return true si el Pokémon fue agregado exitosamente, false si ya estaba en la colección.
     */
    public boolean addPokemon(Pokemon pokemon) {
        if (userCollection.containsKey(pokemon.getName())) {
            return false;
        }
        userCollection.put(pokemon.getName(), pokemon);
        return true;
    }

    /**
     * Obtiene todos los Pokémon en la colección del usuario.
     * 
     * @return Una colección de todos los Pokémon en la colección del usuario.
     */
    public Collection<Pokemon> getAllPokemon() {
        return userCollection.values();
    }

    /**
     * Guarda la colección de Pokémon en un archivo.
     * 
     * @param filename El nombre del archivo donde se guardará la colección.
     */
    public void saveToDisk(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(userCollection);
        } catch (IOException e) {
            System.err.println("Error al guardar la colección: " + e.getMessage());
        }
    }

    /**
     * Carga la colección de Pokémon desde un archivo.
     * 
     * @param filename El nombre del archivo desde donde se cargará la colección.
     */
    public void loadFromDisk(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            userCollection = (Map<String, Pokemon>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar la colección: " + e.getMessage());
        }
    }
}