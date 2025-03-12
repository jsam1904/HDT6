package edu.uvg;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PokemonCollection implements Serializable {
    private Map<String, Pokemon> userCollection;

    public PokemonCollection() {
        userCollection = new HashMap<>();
    }

    public boolean addPokemon(Pokemon pokemon) {
        if (userCollection.containsKey(pokemon.getName())) {
            return false;
        }
        userCollection.put(pokemon.getName(), pokemon);
        return true;
    }

    public Collection<Pokemon> getAllPokemon() {
        return userCollection.values();
    }

    public void saveToDisk(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(userCollection);
        } catch (IOException e) {
            System.err.println("Error al guardar la colección: " + e.getMessage());
        }
    }

    public void loadFromDisk(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            userCollection = (Map<String, Pokemon>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar la colección: " + e.getMessage());
        }
    }
}
