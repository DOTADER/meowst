import static Assets.methods.*;
import static Assets.vars.loadConfirm;
import static Assets.vars.scanner;

public class Main {

    public static void main(String[] args) {

        while(true) {
            // Intro
            narrate("Welcome to Meowst!");
            narrate("Would you like to load a save? [y/n]");
            String loadSave = scanner.next();
            if(loadSave.equals("y")) {
                loadPrompt();
                if(loadConfirm) {
                    break;
                } else {
                    continue;
                }

            } else if(loadSave.equals("n"))  {

                playerOnboard();

                fullCombatLoop();

                postTutorialDialogue();

            } else {
                System.out.println("Whoops! Invalid Input!");
                continue;
            }
            break;
        }

        /*----- Real Game Starts Here -----*/

        while(true) {
            // Pick what to do next
            System.out.println("What will you do?");
            System.out.println("1. [S] Save your game (if you don't do this, your progress cannot be recovered!)");
            System.out.println("2. [C$] Shop");
            System.out.println("3. [>] Adventure");
            System.out.println("4. [x] Exit Game");

            int lobbyOption = scanner.nextInt();

            /* ----- LOBBY OPTION 1 ----- */
            /* ----- Save Your Game ----- */

            if(lobbyOption == 1) {
                saveGame();
            }

            /* ----- LOBBY OPTION 2 ----- */
            /* ---- Open Shop Prompts ---- */

            else if(lobbyOption == 2) {
                openShop();
            }

            /* ----- LOBBY OPTION 3 ----- */
            /* ------- Adventure -------- */

            else if(lobbyOption == 3) {
                fullCombatLoop();
            }

            /* ----- LOBBY OPTION 4 ----- */
            /* ------- Exit Game -------- */

            else if(lobbyOption == 4) {
                break;
            }
        }
    }
}