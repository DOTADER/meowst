package Assets.methods;

import static Assets.vars.*;
import static Assets.methods.dialogue.*;

public class shop {
    public static void openShop() {
        print("[Shopkeeper] Hello! Welcome to my shop!");
        while(true) {
            String[] shopItems = new String[9];
            shopItems[0] = "Full Mana                           ";
            shopItems[1] = "+ 16 Max Mana                       ";
            shopItems[2] = "Full Heal                           ";
            shopItems[3] = "+ 16 Max Health                     ";
            shopItems[4] = "Full Health & Mana                  ";
            shopItems[5] = "Monkey Fist (+4 attack power)       ";
            shopItems[6] = "Brass Knuckles (+8 attack power)    ";
            shopItems[7] = "Gold Staff (+16 attack power)       ";
            shopItems[8] = "Mace (+ 32 attack power)            ";

            int[] shopItemCost = new int[9];
            shopItemCost[0] = 10;
            shopItemCost[1] = 128;
            shopItemCost[2] = 10;
            shopItemCost[3] = 256;
            shopItemCost[4] = 16;
            shopItemCost[5] = 32;
            shopItemCost[6] = 64;
            shopItemCost[7] = 128;
            shopItemCost[8] = 256;

            print("[Shopkeeper] What can I get for you?");
            for(int i = 0; i < 9; i++) {
                print("Shop Item #" + i + ": " + "(C$" + shopItemCost[i] + ") " + shopItems[i]);
            }
            print("[x] Exit Shop");
            print("(You Have C$" + playerCaps + ")");
            String shopOption = scanner.next();
            if(shopOption.equals("0")) {
                purchase(shopItemCost[0]);
                giveFullMana();
            }
            else if(shopOption.equals("1")) {
                purchase(shopItemCost[1]);
                giveMaxMana();
            }
            else if(shopOption.equals("2")) {
                purchase(shopItemCost[2]);
                giveFullHeal();
            }
            else if(shopOption.equals("3")) {
                purchase(shopItemCost[3]);
                giveMaxHealth();
            }
            else if(shopOption.equals("4")) {
                purchase(shopItemCost[4]);
                giveFullHeal();
                giveFullMana();
                discount(4);
            }
            else if(shopOption.equals("5")) {
                if(hasMonkeyFist > 0) {
                    purchase(shopItemCost[5]);
                    giveMonkeyFist();
                } else {
                    print("Sorry, you already have that!");
                }
            }
            else if(shopOption.equals("x")) {
                print("[Shopkeeper] See you around!");
                break;
            }
            else {
                print("Whoops! Invalid Option!");
            }
        }
    }
    public static void giveFullMana() {
        playerMana = playerMaxMana;
    }
    public static void giveMaxMana() {
        playerMaxMana += 16;
        playerMana = playerMaxMana;
    }
    public static void giveFullHeal() {
        playerHealth = playerMaxHealth;
    }
    public static void giveMaxHealth() {
        playerMaxHealth += 16;
        playerHealth = playerMaxHealth;
    }
    public static void giveMonkeyFist() {
        if(hasMonkeyFist > 0) {
            playerAttack += 4;
            boolean hasMonkeyFist = true;
        } else {
            print("Sorry, you already have that!");
        }
    }
    public static void purchase(int cost) {
        if(playerCaps >= cost) {
            playerCaps -= cost;
        } else {
            print("Not enough C$!");
        }
    }
    public static void discount(int sale) {
        playerCaps = playerCaps + sale;
    }
}
