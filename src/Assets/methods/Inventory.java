package Assets.methods;

import static Assets.methods.dialogue.*;
import static Assets.vars.*;

public class Inventory {

    private static String invOption = "";

    public static void invOpen() {
        label:
        while(true) {
            clearScreen();
            print("What would you like to use?");
            option("1. Consumables");
            option("2. Weapons");
            option("[x] Exit Inventory");
            invOption = scanner.next();
            clearScreen();
            switch (invOption) {
                case "1":
                    print("Your Consumables: " + invConsumables.toString());
                    print("What would you like to use?");
                    print("[x] Exit");
                    invOption = scanner.next();
                    if (invOption.contains("max")) {
                        max();
                        timer(5);
                    } else if (invOption.contains("full")) {
                        full();
                        timer(5);
                    }
                    clearScreen();
                    break;
                case "2":
                    print("Your weapons: " + invWeapons.toString());
                    print("What would you like to use?");
                    print("[x] Exit");
                    invOption = scanner.next();
                    switch (invOption) {
                        case "Monkey Fist", "monkey fist", "1":
                            useMonkeyFist();
                        case "Brass Knuckles", "brass knuckles", "2":
                            useBrassKnuckles();
                        case "Gold Staff", "gold staff", "3":
                            useGoldStaff();
                        case "Mace", "mace", "4":
                            useMace();
                    }
                    clearScreen();
                    break;
                case "x":
                    clearScreen();
                    break;
            }
            break;
        }
    }



    public static void useMonkeyFist() {
        enemyHealth -= 12;
        if (enemyHealth > (playerHealth + 4)) {
            invWeapons.remove("Monkey Fist");
            print("Your Monkey Fist broke!");
        }
    }

    public static void useBrassKnuckles() {
        enemyHealth -= 16;
        if (enemyHealth > playerHealth + 4) {
            invWeapons.remove("Brass Knuckles");
            print("Your Brass Knuckles broke!");
        }
    }

    public static void useGoldStaff() {
        enemyHealth -= 24;
        if (enemyHealth > playerHealth + 4) {
            invWeapons.remove("Gold Staff");
            print("Your Gold Staff broke!");
        }
    }

    public static void useMace() {
        enemyHealth -= 40;
        if (enemyHealth > playerHealth + 4) {
            invWeapons.remove("Mace");
            print("Your Mace broke!");
        }
    }



    public static void useFullStamina() {
        playerStamina = playerMaxStamina;
        invConsumables.remove("Full Stamina");
        print("Stamina restored to full!");
    }

    public static void useFullHeal() {
        invConsumables.remove("Full Heal");
        playerHealth = playerMaxHealth;
        print("Health restored to full!");
    }

    public static void useMaxStamina() {
        playerMaxStamina += 16;
        invConsumables.remove("Max Stamina");
        print("You Gained 16 Max Stamina!");
    }

    public static void useMaxHealth() {
        playerMaxHealth += 16;
        invConsumables.remove("Max Health");
        print("You Gained 16 Max Health!");
    }

    public static void full() {
        invOption = scanner.next();
        if(invOption.contains("stamina")) {
            useFullStamina();
        } else if(invOption.contains("heal")) {
            useFullHeal();
        } else if(invOption.contains("heal" + "stamina")) {
            useFullHeal();
            useFullStamina();
        }
    }

    public static void max() {
        invOption = scanner.next();
        if(invOption.contains("stamina")) {
            useMaxStamina();
        } else if(invOption.contains("health")) {
            useMaxHealth();
        } else if(invOption.contains("health" + "stamina")) {
            useMaxStamina();
            useMaxHealth();
        }
    }
}
