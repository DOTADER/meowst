package Assets.methods;

import static Assets.methods.Inventory.invOpen;
import static Assets.methods.dialogue.*;
import static Assets.vars.*;

public class combat {
    public static void attackEnemy() {
        enemyHealth -= playerAttack;
        playerStamina -= playerAttackCost;

        timer(1);

        if(playerStamina < 8) {
            playerHealth = 0;
            playerStamina = 0;
            print("You tried, but your stamina has depleted!");
        } else {
            print(enemyName + " took " + playerAttack + " damage!");
        }
    }
    public static void healSelf() {
        if(playerHealth < 64){
            playerHealth += playerHeal;
            playerStamina -= playerHealCost;
            boolean healPlayer = true;

        } else {
            print("Health already full!");
            boolean healPlayer = false;

        }
        if(playerStamina < 8) {
            playerHealth = 0;
            playerStamina = 0;
            print("You tried, but your stamina has depleted!");
        }
    }
    public static void checkFightOver() {
        if(playerHealth < 1) {
            fightOver = true;
        } else if(enemyHealth < 1) {
            fightOver = true;
        }
    }
    public static void interRoundCheck() {
        print("You have: " + playerHealth + " HP, and " + playerStamina + " stamina.");
        print(enemyName + " has: " + enemyHealth + " HP, and " + enemyStamina + " stamina.");
    }
    public static void attackPlayer() {
        playerHealth -= playerAttack;
        enemyStamina -= playerAttackCost;

        timer(1);

        if(enemyStamina < 8) {
            enemyHealth = 0;
            enemyStamina = 0;
            print(enemyName + " ran out of stamina!");
        } else {
            print(enemyName + " attacked you for " + playerAttack + " damage!");
        }
    }
    public static void healEnemy() {
        if(enemyHealth < 64){
            enemyHealth += playerHeal;
            enemyStamina -= playerHealCost;

        } else {
            print(enemyName + " healed for " + playerHeal + " HP");
            print("But their health is already full!");

        }
        if(enemyStamina < 8) {
            enemyHealth = 0;
            enemyStamina = 0;
            print(enemyName + " ran out of stamina!");
        }
    }
    public static void postFightCheck() {
        if(playerHealth <= 0) {
            print("Game Over!");
            print("Meowst Match Streak: " + matchNum);
            print("You lost 10 Caps!");
            playerCaps -= playerMaxHealth / 4;
            boolean gameOver = true;
        } else if (enemyHealth <= 0) {
            print("Meowst Match " + matchNum + ": Win!");
            playerCaps += playerMaxHealth / 2;
            boolean gameOver = true;
        }
    }
    public static void fullCombatLoop() {
        gameOver = false;
        matchNum = matchNum + 1;
        print("Meowst Match " + matchNum + ": Begin!");

        timer(3);

        narrate("Looks like he's got "+ enemyHealth +" HP and "+ enemyStamina +" stamina. Think you can handle it?");

        // Main Combat Loop
        while(playerHealth > 0 && enemyHealth > 0) {

            // Initial Prompt
            print("What will you do?:");
            option("1. Attack (8 damage, -4 stamina)");
            option("2. Heal (+16 health, -32 stamina)");
            option("3. Inventory");

            String combatOption = scanner.next();

            switch (combatOption) {
                case "1" -> attackEnemy();
                case "2" -> {
                    if (healPlayer) {
                        healSelf();
                    } else if (!healPlayer) {
                        continue;
                    }
                }
                case "3" -> invOpen();
            }

            checkFightOver();
            if(fightOver) {
                break;
            }

            timer(1);

            interRoundCheck();

            print("Now, it's " + enemyName + "'s turn!");

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
}
