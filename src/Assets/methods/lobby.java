package Assets.methods;

import static Assets.methods.Inventory.invOpen;
import static Assets.methods.combat.*;
import static Assets.methods.dialogue.*;
import static Assets.methods.gameSaves.*;
import static Assets.methods.shop.*;
import static Assets.vars.*;

public class lobby {
    public static void lobbyOptions() {
        clearScreen();
        print("What will you do?");
        option("1. [S] Save your game (if you don't do this, your progress cannot be recovered!)");
        option("2. [C$] Shop");
        option("3. [>] Adventure");
        option("4. [I] Inventory");
        print("\n");
        option("9. [x] Exit Game");
    }
    public static void entireLobby() {
        label:
        while(true) {

            lobbyOptions();

            String lobbyOption = scanner.next();

            /* ----- LOBBY OPTION 1 ----- */
            /* ----- Save Your Game ----- */

            switch (lobbyOption) {
                case "1":
                case "s":
                case "S":
                    clearScreen();
                    saveGame();
                    break;

                /* ----- LOBBY OPTION 2 ----- */
                /* ---- Open Shop Prompts ---- */
                case "2":
                case "C":
                case "$":
                case "C$":
                    clearScreen();
                    openShop();
                    break;

                /* ----- LOBBY OPTION 3 ----- */
                /* ------- Adventure -------- */
                case "3":
                case ">":
                    enemyHealth = (int) ((Math.random() * ((playerMaxHealth + 4) - (playerMaxHealth - 16))) + (playerMaxHealth - 16));
                    clearScreen();
                    if (findMaxStamina <= 2) {
                        print("You found a Max Stamina!");
                        playerMaxStamina += 4;
                        playerStamina = playerMaxStamina;
                        print("Your Max Stamina is now " + playerMaxStamina);
                        timer(5);
                    }
                    fullCombatLoop();
                    if (gameOver) {
                        break label;
                    }
                    break;

                /* ----- LOBBY OPTION 4 ----- */
                /* ----- Open Inventory ------ */
                case "4":
                case "i":
                case "I":
                    clearScreen();
                    invOpen();
                    break;

                /* ----- LOBBY OPTION 5 ----- */
                /* ------- Exit Game -------- */
                case "9":
                case "x":
                case "X":
                    clearScreen();
                    break label;
            }
        }
    }
}
