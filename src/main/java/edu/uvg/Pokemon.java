package edu.uvg;

import java.io.Serializable;

/**
 * Clase que representa un Pokémon.
 * 
 * @autor
 * Javier Alvarado - 24546
 */
public class Pokemon implements Serializable {
    private String name;
    private String type1;
    private String ability;

    /**
     * Constructor para crear un nuevo Pokémon.
     * 
     * @param name Nombre del Pokémon.
     * @param type1 Tipo principal del Pokémon.
     * @param ability Habilidad del Pokémon.
     */
    public Pokemon(String name, String type1, String ability) {
        this.name = name;
        this.type1 = type1;
        this.ability = ability;
    }

    /**
     * Obtiene el nombre del Pokémon.
     * 
     * @return Nombre del Pokémon.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Obtiene el tipo principal del Pokémon.
     * 
     * @return Tipo principal del Pokémon.
     */
    public String getType1() {
        return type1;
    }

    /**
     * Obtiene la habilidad del Pokémon.
     * 
     * @return Habilidad del Pokémon.
     */
    public String getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type1='" + type1 + '\'' +
                ", ability='" + ability + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return name.equalsIgnoreCase(pokemon.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}