package Assets.methods;

import static Assets.methods.dialogue.option;
import static Assets.methods.dialogue.print;
import static Assets.vars.*;

public class shop {
    public static void openShop() {
        print("[Shopkeeper] Hello! Welcome to my shop!");
        label:
            while (true) {
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

                int[] shopItemCost = new int[shopItems.length];
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
                for (int i = 0; i < shopItems.length; i++) {
                    option("Shop Item #" + i + ": " + "(C$" + shopItemCost[i] + ") " + shopItems[i]);
                }
                print("[x] Exit Shop");
                print("(You Have C$" + playerCaps + ")");
                String shopOption = scanner.next();
                if(playerCaps >= shopItemCost[Integer.parseInt(shopOption)]) {
                    purchase(shopItemCost[Integer.parseInt(shopOption)]);
                    inventory.add(shopItems[Integer.parseInt(shopOption)]);
                    print(inventory.toString());
                    if(Integer.parseInt(shopOption) == 4) {
                        discount(4);
                    }
                } else {
                    print("Not enough C$!");
                }
            }
        }

    public static void purchase(int cost) {
        playerCaps -= cost;
    }

    public static void discount(int sale) {
        playerCaps = playerCaps + sale;
    }
}
