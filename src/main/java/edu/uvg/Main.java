package edu.uvg;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase principal para la aplicación de gestión de Pokémon.
 * 
 * @autor
 * Javier Alvarado - 24546
 */
public class Main {
    private static final String DATA_FILE = "pokemon_data_pokeapi.csv";
    private static final String USER_COLLECTION_FILE = "userCollection.ser";

    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la implementación de Map a utilizar:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");
        int option = scanner.nextInt();
        scanner.nextLine();

        Map<String, Pokemon> pokemonData = PokemonDataLoader.loadPokemonData(DATA_FILE, option);
        System.out.println("Cantidad de Pokémon cargados: " + pokemonData.size());

        PokemonCollection userCollection = new PokemonCollection();

        PokemonService service = new PokemonService(pokemonData, userCollection);

        int choice;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Agregar un Pokémon a tu colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar tu colección (nombre y tipo1 ordenados por tipo1)");
            System.out.println("4. Mostrar todos los Pokémon (nombre y tipo1 ordenados por tipo1)");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Guardar colección y salir");
            System.out.print("Elige una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon a agregar: ");
                    String addName = scanner.nextLine().toLowerCase();
                    System.out.println(service.addPokemonToUserCollection(addName));
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon para ver sus datos: ");
                    String detailName = scanner.nextLine().toLowerCase();
                    System.out.println(service.getPokemonDetails(detailName));
                    break;
                case 3:
                    List<String> userList = service.getUserCollectionSortedByType1();
                    if (userList.isEmpty()) {
                        System.out.println("Tu colección está vacía.");
                    } else {
                        userList.forEach(System.out::println);
                    }
                    break;
                case 4:
                    List<String> allList = service.getAllPokemonSortedByType1();
                    if (allList.isEmpty()) {
                        System.out.println("No hay Pokémon cargados.");
                    } else {
                        allList.forEach(System.out::println);
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad a buscar: ");
                    String ability = scanner.nextLine().toLowerCase();
                    List<String> abilityList = service.getPokemonByAbility(ability);
                    if (abilityList.isEmpty()) {
                        System.out.println("No se encontraron Pokémon con la habilidad: " + ability);
                    } else {
                        abilityList.forEach(System.out::println);
                    }
                    break;
                case 6:
                    userCollection.saveToDisk(USER_COLLECTION_FILE);
                    System.out.println("Colección guardada. Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}