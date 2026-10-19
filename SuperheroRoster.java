
import java.util.Arrays;
import java.util.Comparator;

public class SuperheroRoster {

    public static void main(String[] args) {

        // 1. Declare and initialize arrays
        String[] heroNames = {
            "Spider-Man",
            "Iron Man",
            "Black Widow",
            "Thor",
            "Hulk"
        };

        String[] abilities = {
            "Web-slinging",
            "Flying and high-tech armor",
            "Stealth and combat",
            "Thunder and lightning",
            "Superhuman strength"
        };

        int[] powerLevels = {85, 90, 80, 98, 95};

        // 2. Display each hero's details using a loop
        System.out.println("=== Marvel Superhero Roster ===");

        for (int i = 0; i < heroNames.length; i++) {
            System.out.println("Name: " + heroNames[i]);
            System.out.println("Ability: " + abilities[i]);
            System.out.println("Power Level: " + powerLevels[i]);
            System.out.println("----------------------------");
        }

        // 3. Search for a specific hero
        System.out.println("\n=== Search for a Hero ===");
        searchHero(heroNames, abilities, powerLevels, "Iron Man");

        // Try searching for a hero who is not in the roster
        searchHero(heroNames, abilities, powerLevels, "Captain America");

        // 4. Calculate and display average power level
        double average = calculateAveragePower(powerLevels);
        System.out.printf("%nAverage Power Level: %.2f%n", average);

        // 5. Create an array of Superhero objects
        Superhero[] heroes = new Superhero[heroNames.length];

        for (int i = 0; i < heroNames.length; i++) {
            heroes[i] = new Superhero(
                heroNames[i],
                abilities[i],
                powerLevels[i]
            );
        }

        // Display heroes using Superhero objects
        System.out.println("\n=== Superhero Objects ===");

        for (Superhero hero : heroes) {
            hero.displayHero();
        }

        // 6. Bonus: Sort heroes by power level (descending)
        Arrays.sort(heroes,
            Comparator.comparingInt(
                (Superhero hero) -> hero.getPowerLevel()
            ).reversed()
        );

        System.out.println("\n=== Heroes Sorted by Power Level ===");

        for (Superhero hero : heroes) {
            hero.displayHero();
        }
    }

    // Method: searchHero
    public static void searchHero(
            String[] names,
            String[] abilities,
            int[] powerLevels,
            String target) {

        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println("Hero Found!");
                System.out.println("Name: " + names[i]);
                System.out.println("Ability: " + abilities[i]);
                System.out.println("Power Level: " + powerLevels[i]);
                return;
            }
        }

        System.out.println("Hero not found: " + target);
    }

    // Method: calculateAveragePower
    public static double calculateAveragePower(int[] powerLevels) {

        if (powerLevels.length == 0) {
            return 0.0;
        }

        int sum = 0;

        for (int power : powerLevels) {
            sum += power;
        }

        return (double) sum / powerLevels.length;
    }
}

// Superhero class
class Superhero {

    // Attributes
    private String name;
    private String ability;
    private int powerLevel;

    // Constructor
    public Superhero(String name, String ability, int powerLevel) {
        this.name = name;
        this.ability = ability;
        this.powerLevel = powerLevel;
    }

    // Getter for sorting by power level
    public int getPowerLevel() {
        return powerLevel;
    }

    // Method: displayHero
    public void displayHero() {
        System.out.println("Name: " + name);
        System.out.println("Ability: " + ability);
        System.out.println("Power Level: " + powerLevel);
        System.out.println("----------------------------");
    }
}