package Assets.methods;

import static Assets.vars.*;
import static Assets.methods.dialogue.*;

public class shop {
    public static void openShop() {
        print("[Shopkeeper] Hello! Welcome to my shop!");
        while(true) {
            print("[Shopkeeper] What can I get for you?");
            print("Shop Items:");
            print("1. Full Mana - C$10");
            print("2. + 16 Max Mana - C$150");
            print("3. Full Heal - C$10");
            print("4. + 16 Max Health - C$250");
            print("5. Full Health & Mana - C$16");
            print("9. Exit Shop");
            print("(You Have C$" + playerCaps + ")");
            String shopOption = scanner.next();
            if(shopOption.equals("1")) {
                buyFullMana();
            }
            else if(shopOption.equals("2")) {
                buyMaxMana();
            }
            else if(shopOption.equals("3")) {
                buyFullHeal();
            }
            else if(shopOption.equals("4")) {
                buyMaxHealth();
            }
            else if(shopOption.equals("5")) {
                buyFullHeal();
                buyFullMana();
                discount(4);
            }
            else if(shopOption.equals("9") || shopOption.equals("x")) {
                print("[Shopkeeper] See you around!");
                break;
            }
            else {
                print("Whoops! Invalid Option!");
            }
        }
    }
    public static void buyFullMana() {
        if(playerCaps >= 10) {
            playerCaps -= 10;
            playerMana = playerMaxMana;
            print("[Shopkeeper] Full Mana, Here you go!");
        } else {
            print("Not enough C$!");
        }
    }
    public static void buyMaxMana() {
        if(playerCaps >= 150) {
            playerCaps -= 150;
            playerMaxMana += 16;
            playerMana = playerMaxMana;
            print("[Shopkeeper] Max Mana, Here you go!");
        } else {
            print("Not enough C$!");
        }
    }
    public static void buyFullHeal() {
        if(playerCaps >= 10) {
            playerCaps -= 10;
            playerHealth = playerMaxHealth;
            print("[Shopkeeper] Full Heal, Here you go!");
        } else {
            print("Not enough C$!");
        }
    }
    public static void buyMaxHealth() {
        if(playerCaps >= 250) {
            playerCaps -= 250;
            playerMaxHealth += 16;
            playerHealth = playerMaxHealth;
            print("[Shopkeeper] Max Health, Here you go!");
        } else {
            print("Not enough C$!");
        }
    }
    public static void discount(int sale) {
        playerCaps = playerCaps + sale;
    }
}
