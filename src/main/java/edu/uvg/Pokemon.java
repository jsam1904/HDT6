package edu.uvg;
import java.io.Serializable;

public class Pokemon implements Serializable {
    private String name;
    private String type1;
    private String ability;

    public Pokemon(String name, String type1, String ability) {
        this.name = name;
        this.type1 = type1;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }
    
    public String getType1() {
        return type1;
    }

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
