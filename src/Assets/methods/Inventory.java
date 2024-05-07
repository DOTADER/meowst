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
                    invOpenConsumables();
                    break;
                case "2":
                    invOpenWeapons();
                    break;
                case "x":
                    clearScreen();
                    break;
            }
            break;
        }
    }



    public static void invOpenWeapons() {
        print("Your weapons: " + invWeapons.toString());
        print("What would you like to use?");
        print("[x] Exit");
        invOption = scanner.next().toLowerCase().replace(" ", "");
        switch (invOption) {
            case "monkeyfist" -> useMonkeyFist();
            case "brassknuckles" -> useBrassKnuckles();
            case "goldstaff" -> useGoldStaff();
            case "mace" -> useMace();
        }
        clearScreen();
    }

    public static void invOpenConsumables() {
        print("Your Consumables: " + invConsumables.toString().toLowerCase());
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
    }



    public static void useMonkeyFist() {
        enemyHealth -= playerAttack + 4;
        playerStamina -= playerAttackCost;

        timer(1);

        if(playerStamina < 8) {
            playerHealth = 0;
            playerStamina = 0;
            print("You tried, but your stamina has depleted!");
        } else {
            print(enemyName + " took " + (playerAttack + 4) + " damage!");
        }
        if (enemyHealth > (playerHealth + 4)) {
            invWeapons.remove("MonkeyFist");
            print("Your Monkey Fist broke!");
        }
        timer(1);
    }

    public static void useBrassKnuckles() {
        enemyHealth -= playerAttack + 8;
        playerStamina -= playerAttackCost;

        timer(1);

        if(playerStamina < 8) {
            playerHealth = 0;
            playerStamina = 0;
            print("You tried, but your stamina has depleted!");
        } else {
            print(enemyName + " took " + (playerAttack + 8) + " damage!");
        }
        if (enemyHealth > (playerHealth + 4)) {
            invWeapons.remove("BrassKnuckles");
            print("Your Brass Knuckles broke!");
        }
        timer(1);
    }

    public static void useGoldStaff() {
        enemyHealth -= playerAttack + 16;
        playerStamina -= playerAttackCost;

        timer(1);

        if(playerStamina < 8) {
            playerHealth = 0;
            playerStamina = 0;
            print("You tried, but your stamina has depleted!");
        } else {
            print(enemyName + " took " + (playerAttack + 16) + " damage!");
        }
        if (enemyHealth > (playerHealth + 4)) {
            invWeapons.remove("GoldStaff");
            print("Your Gold Staff broke!");
        }
        timer(1);
    }

    public static void useMace() {
        enemyHealth -= playerAttack + 32;
        playerStamina -= playerAttackCost;

        timer(1);

        if(playerStamina < 8) {
            playerHealth = 0;
            playerStamina = 0;
            print("You tried, but your stamina has depleted!");
        } else {
            print(enemyName + " took " + (playerAttack + 32) + " damage!");
        }
        if (enemyHealth > (playerHealth + 4)) {
            invWeapons.remove("Mace");
            print("Your Mace broke!");
        }
        timer(1);
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
