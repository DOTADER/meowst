package Assets;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static Assets.vars.*;

public class methods {

    /*--- New Game ---*/

    public static void playerOnboard() {
        System.out.println("Name your character:");
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

    /*--- Combat ---*/

    public static void attackEnemy() {
        enemyHealth -= playerAttack;
        playerMana -= playerAttackCost;

        timer(1);

        if(playerMana < 8) {
            playerHealth = 0;
            playerMana = 0;
            System.out.println("You tried, but your mana has depleted!");
        } else {
            System.out.println(enemyName + " took " + playerAttack + " damage!");
        }
    }
    public static void healSelf() {
        if(playerHealth < 64){
            playerHealth += playerHeal;
            playerMana -= playerHealCost;
            boolean healPlayer = true;

        } else {
            System.out.println("Health already full!");
            boolean healPlayer = false;

        }
        if(playerMana < 8) {
            playerHealth = 0;
            playerMana = 0;
            System.out.println("You tried, but your mana has depleted!");
        }
    }
    public static void checkFightOver() {
        if(playerHealth <= 0) {
            boolean fightOver = true;
        } else if(enemyHealth <= 0) {
            boolean fightOver = true;
        }
    }
    public static void interRoundCheck() {
        System.out.println("You have: " + playerHealth + " HP, and " + playerMana + " mana.");
        System.out.println(enemyName + " has: " + enemyHealth + " HP, and " + enemyMana + " mana.");
    }
    public static void attackPlayer() {
        playerHealth -= playerAttack;
        enemyMana -= playerAttackCost;

        timer(1);

        if(enemyMana < 8) {
            enemyHealth = 0;
            enemyMana = 0;
            System.out.println(enemyName + " ran out of mana!");
        } else {
            System.out.println(enemyName + " attacked you for " + playerAttack + " damage!");
        }
    }
    public static void healEnemy() {
        if(enemyHealth < 64){
            boolean healEnemy = true;
            enemyHealth += playerHeal;
            enemyMana -= playerHealCost;

        } else {
            boolean healEnemy = false;
            System.out.println(enemyName + " healed for " + playerHeal);
            System.out.println("But their health is already full!");

        }
        if(enemyMana < 8) {
            enemyHealth = 0;
            enemyMana = 0;
            System.out.println(enemyName + " ran out of mana!");
        }
    }
    public static void postFightCheck() {
        if(playerHealth <= 0) {
            System.out.println("Game Over!");
            System.out.println("Meowst Match Streak: " + matchNum);
            boolean gameOver = true;
        } else if (enemyHealth <= 0) {
            System.out.println("Meowst Match " + matchNum + ": Win!");
            playerCaps += (playerMaxHealth / 2);
        }
    }
    public static void fullCombatLoop() {
        matchNum = matchNum + 1;
        System.out.println("Meowst Match " + matchNum + ": Begin!");

        timer(1);

        narrate("Looks like he's got "+ enemyHealth +" HP and "+ enemyMana +" Mana. Think you can handle it?");

        // Main Combat Loop
        while(playerHealth > 0 && enemyHealth > 0) {

            // Initial Prompt
            System.out.println("What will you do?:");
            option("1. Attack (8 damage, -4 mana)");
            option("2. Heal (+16 health, -32 mana)");

            int combatOption = scanner.nextInt();

            if(combatOption == 1) {
                attackEnemy();

            } else if(combatOption == 2) {
                if(healPlayer) {
                    healSelf();
                } else if (!healPlayer) {
                    continue;
                }
            }

            checkFightOver();
            if(fightOver) {
                break;
            }

            timer(1);

            interRoundCheck();

            System.out.println("Now, it's " + enemyName + "'s turn!");

            timer(1);

            if(enemyWillAttack > 5) {
                attackPlayer();
            } else {
                healEnemy();
            }

            checkFightOver();
            if(fightOver) {
                break;
            }

            timer(1);

            interRoundCheck();

            // Replay until fight is over
            continue;

        } postFightCheck();
    }

    /*--- Shop Loop ---*/

    public static void openShop() {
        System.out.println("[Shopkeeper] Hello! Welcome to my shop!");
        while(true) {
            System.out.println("[Shopkeeper] What can I get for you?");
            System.out.println("Shop Items: (You Have C$" + playerCaps + ")");
            System.out.println("1. Full Mana - C$10");
            System.out.println("2. + 16 Max Mana - C$150");
            System.out.println("3. Full Heal - C$10");
            System.out.println("4. + 16 Max Health - C$250");
            System.out.println("5. Full Health & Mana - C$16");
            System.out.println("9. Exit Shop");
            int shopOption = scanner.nextInt();
            if(shopOption == 1) {
                if(playerCaps >= 10) {
                    playerCaps -= 10;
                    playerMana = playerMaxMana;
                    System.out.println("[Shopkeeper] Full Mana, Here you go!");
                } else {
                    System.out.println("Not enough C$!");
                }
            } else if(shopOption == 2) {
                if(playerCaps >= 150) {
                    playerCaps -= 150;
                    playerMaxMana += 16;
                    System.out.println("[Shopkeeper] Max Mana, Here you go!");
                } else {
                    System.out.println("Not enough C$!");
                }
            } else if(shopOption == 3) {
                if(playerCaps >= 10) {
                    playerCaps -= 10;
                    playerHealth = playerMaxHealth;
                    System.out.println("[Shopkeeper] Full Heal, Here you go!");
                } else {
                    System.out.println("Not enough C$!");
                }
            } else if(shopOption == 4) {
                if(playerCaps >= 250) {
                    playerCaps -= 250;
                    playerMaxHealth += 16;
                    System.out.println("[Shopkeeper] Max Health, Here you go!");
                } else {
                    System.out.println("Not enough C$!");
                }
            } else if(shopOption == 5) {
                if(playerCaps >= 16) {
                    playerCaps -= 16;
                    playerMana = playerMaxMana;
                    playerHealth = playerMaxHealth;
                    System.out.println("[Shopkeeper] Full Health & Mana, Here you go!");
                } else {
                    System.out.println("Not enough C$!");
                }
            } else if(shopOption == 9) {
                System.out.println("[Shopkeeper] See you around!");
                break;
            } else {
                System.out.println("Whoops! Invalid Option!");
            }
        }
    }

    /*--- Saving The Game ---*/

    public static void loadSave() {
        try {
            BufferedReader saveReader = new BufferedReader(new FileReader("saves/" + playerName + "/playerData.txt"));
            playerName = saveReader.readLine();
            enemyName = saveReader.readLine();
            playerHealth = Integer.parseInt(saveReader.readLine());
            playerMaxHealth = Integer.parseInt(saveReader.readLine());
            playerMana = Integer.parseInt(saveReader.readLine());
            playerMaxMana = Integer.parseInt(saveReader.readLine());
            playerAttack = Integer.parseInt(saveReader.readLine());
            playerCaps = Integer.parseInt(saveReader.readLine());
            matchNum = Integer.parseInt(saveReader.readLine());

            saveReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void loadPrompt() {
        System.out.println("What file? (type character name)");
        playerName = scanner.next();

        loadSave();

        System.out.println("You have: C$" + playerCaps + ", " + playerHealth + " HP, and " + playerMana + " mana.");

        System.out.println("Do you want to load \"" + playerName + "\"? [y/n]");
        if (scanner.next().equals("y")) {
            loadConfirm = true;
        } else if (scanner.next().equals("n")) {
            loadConfirm = false;
        }
    }
    public static void saveGame() {
        File saves = new File("saves/" + playerName);
        if (!saves.exists()){
            saves.mkdirs();
        }
        try {
            File playerData = new File("saves/" + playerName + "/playerData.txt");
            FileWriter playerSave = new FileWriter("saves/" + playerName + "/playerData.txt");
            playerSave.write(
                    playerName + "\n" +
                            enemyName + "\n" +
                            playerHealth + "\n" +
                            playerMaxHealth + "\n" +
                            playerMana + "\n" +
                            playerMaxMana + "\n" +
                            playerAttack + "\n" +
                            playerCaps + "\n" +
                            matchNum + "\n"
            );
            playerSave.close();
        } catch (IOException e) {
            System.out.println("Uh oh! An error ocurred.");
            e.printStackTrace();
        }
        System.out.println("Game saved!");
    }

    /*--- Dialogue ---*/

    public static void narrate(String str) {
        System.out.println("[NARRATOR] " + str);
    }
    public static void option(String str) {
        System.out.println("[OPTION] " + str);
    }
    public static void timer(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        narrate("2. [C$] is the shop. This is where you spend your hard-earned Caps to gain mana, max health, attack power, or fully heal.");
        timer(3);
        narrate("3. [>] takes you where the fun is! This is your main way to get into Meowst Matches and earn those sweet sweet caps!");
        timer(10);
        narrate("Alright, I've waited long enough.");
    }
}