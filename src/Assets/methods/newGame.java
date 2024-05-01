package Assets.methods;

import static Assets.methods.combat.*;
import static Assets.methods.dialogue.*;
import static Assets.methods.gameSaves.*;
import static Assets.vars.*;

public class newGame {
    public static void playerOnboard() {
        print("Name your character:");
        playerName = scanner.next();

        narrate("So, your name is " + playerName + ". Not bad!");

        timer(1);

        narrate("Anyway, you have the ability to fight in this world, and it's truly a sight to behold!");

        timer(3);

        narrate("Speaking of fighting, it looks like someone is coming to challenge you! Who is it?");
        enemyName = scanner.next();
        narrate("Oh... " + enemyName + "... fitting.");

        timer(1);

        narrate("Aaaand he's definitely coming for us. GET READY!");

        timer(3);
    }
    public static void postTutorialDialogue() {
        narrate("Phew, I was sure you were going to lose there.");
        timer(3);
        narrate("... What?");
        timer(1);
        narrate("Anyway! You're about to set out on quite the adventure!");
        timer(3);
        narrate("The more Meowst Matches you win, the more powerful you become!");
        timer(3);
        narrate("You have 3 options on what's next:");
        timer(3);
        narrate("1. [S] will save your game. You can change the saves folder whenever you use [S].");
        timer(3);
        narrate("2. [C$] is the shop. This is where you spend your hard-earned Caps to gain mana, max health, attack power, etc.");
        timer(3);
        narrate("3. [>] takes you where the fun is! This is your main way to get into Meowst Matches and earn those sweet sweet caps!");
        timer(10);
        narrate("Alright, I've waited long enough.");
    }
    public static void entireIntro() {
        while(true) {
            // Intro
            clearScreen();
            narrate("Welcome to Meowst!");
            narrate("Would you like to load a save? [y/n]");
            String loadSave = scanner.next();
            clearScreen();
            if(loadSave.equals("y")) {
                loadPrompt();
                if(loadConfirm) {
                    break;
                } else {
                    continue;
                }

            } else if(loadSave.equals("n"))  {

                clearScreen();

                playerOnboard();

                clearScreen();

                fullCombatLoop();

                clearScreen();

                postTutorialDialogue();

            } else {
                print("Whoops! Invalid Input!");
                continue;
            }
            break;
        }
    }
}
