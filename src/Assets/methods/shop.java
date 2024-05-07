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
                shopItems[0] = "Full Stamina";
                shopItems[1] = "+16 Max Stamina";
                shopItems[2] = "Full Heal";
                shopItems[3] = "+16 Max Health";
                shopItems[4] = "Full Health & Stamina";
                shopItems[5] = "Monkey Fist";
                shopItems[6] = "Brass Knuckles";
                shopItems[7] = "Gold Staff";
                shopItems[8] = "Mace";

                int[] shopItemCost = new int[shopItems.length];
                shopItemCost[0] = 10;
                shopItemCost[1] = 128;
                shopItemCost[2] = 10;
                shopItemCost[3] = 256;
                shopItemCost[4] = 20;
                shopItemCost[5] = 32;
                shopItemCost[6] = 64;
                shopItemCost[7] = 128;
                shopItemCost[8] = 256;

                print("[Shopkeeper] What can I get for you?");
                for (int i = 0; i < shopItems.length; i++) {
                    option("Shop Item " + i + ": " + "(C$" + shopItemCost[i] + ") " + shopItems[i]);
                }
                print("[x] Exit Shop");
                print("Your inventory: " + invConsumables + " | " + invWeapons);
                print("(You Have C$" + playerCaps + ")");
                String shopOption = scanner.next();
                switch (shopOption) {
                    case "x":
                        print("[Shopkeeper] Alright, see you later!");
                        break label;
                    case "4":
                    case "3":
                    case "2":
                    case "1":
                    case "0":
                        if (playerCaps >= shopItemCost[Integer.parseInt(shopOption)]) {
                            purchase(shopItemCost[Integer.parseInt(shopOption)]);
                            print(shopItems[Integer.parseInt(shopOption)]);
                            invConsumables.add(shopItems[Integer.parseInt(shopOption)]);
                            print("Your Consumables: " + invConsumables);
                            print("Your Weapons: " + invWeapons.toString());
                            if (Integer.parseInt(shopOption) == 4) {
                                discount(4);
                            }
                        } else {
                            print("Not enough C$!");
                        }
                        break;
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                        if (playerCaps >= shopItemCost[Integer.parseInt(shopOption)]) {
                            purchase(shopItemCost[Integer.parseInt(shopOption)]);
                            invWeapons.add(shopItems[Integer.parseInt(shopOption)]);
                            print("Your Consumables: " + invConsumables.toString());
                            print("Your Weapons: " + invWeapons.toString());

                        } else {
                            print("Not enough C$!");
                        }
                        break;
                    default:
                        throw new IllegalStateException(shopOption + " isn't an option!");
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
