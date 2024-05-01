package Assets.methods;

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
        option("4. [x] Exit Game");
    }
    public static void entireLobby() {
        while(true) {

            lobbyOptions();

            String lobbyOption = scanner.next();

            /* ----- LOBBY OPTION 1 ----- */
            /* ----- Save Your Game ----- */

            if(lobbyOption.equals("1") || lobbyOption.equals("s") || lobbyOption.equals("S")) {
                clearScreen();
                saveGame();
            }

            /* ----- LOBBY OPTION 2 ----- */
            /* ---- Open Shop Prompts ---- */

            else if(lobbyOption.equals("2") || lobbyOption.equals("C") || lobbyOption.equals("$") || lobbyOption.equals("C$")) {
                clearScreen();
                openShop();
            }

            /* ----- LOBBY OPTION 3 ----- */
            /* ------- Adventure -------- */

            else if(lobbyOption.equals("3") || lobbyOption.equals(">")) {
                clearScreen();
                if(findMaxMana >= 7) {
                    print("You found a Max Mana!");
                    playerMaxMana += 4;
                    playerMana = playerMaxMana;
                    print("Your Max Mana is now " + playerMaxMana);
                }
                fullCombatLoop();
                if(gameOver) {
                    break;
                }
            }

            /* ----- LOBBY OPTION 4 ----- */
            /* ------- Exit Game -------- */

            else if(lobbyOption.equals("4") || lobbyOption.equals("x") || lobbyOption.equals("X")) {
                clearScreen();
                break;
            }
        }
    }
}
