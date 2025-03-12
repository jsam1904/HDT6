package edu.uvg;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase de pruebas para la clase Main.
 * 
 * @autor
 * Javier Alvarado - 24546
 */
public class MainTest {
    private PokemonService service;
    private Map<String, Pokemon> pokemonData;
    private PokemonCollection userCollection;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {
        pokemonData = new HashMap<>();
        pokemonData.put("Pikachu", new Pokemon("Pikachu", "Electric", "Static"));
        pokemonData.put("Charmander", new Pokemon("Charmander", "Fire", "Blaze"));
        pokemonData.put("Squirtle", new Pokemon("Squirtle", "Water", "Torrent"));
        userCollection = new PokemonCollection();
        service = new PokemonService(pokemonData, userCollection);
    }

    /**
     * Prueba para el método addPokemonToUserCollection.
     */
    @Test
    public void testAddPokemonToUserCollection() {
        String response1 = service.addPokemonToUserCollection("Pikachu");
        assertEquals("Pokémon Pikachu agregado a tu colección.", response1);
        String response2 = service.addPokemonToUserCollection("Pikachu");
        assertEquals("El Pokémon Pikachu ya está en tu colección.", response2);
        String response3 = service.addPokemonToUserCollection("Bulbasaur");
        assertEquals("Error: El Pokémon Bulbasaur no se encuentra en los datos.", response3);
    }

    /**
     * Prueba para el método getPokemonDetails.
     */
    @Test
    public void testGetPokemonDetails() {
        String details = service.getPokemonDetails("Charmander");
        assertTrue(details.contains("Charmander"));
        String notFound = service.getPokemonDetails("Bulbasaur");
        assertEquals("Error: El Pokémon Bulbasaur no se encuentra en los datos.", notFound);
    }
}