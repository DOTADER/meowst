package Assets.methods;

import static Assets.methods.dialogue.*;
import static Assets.vars.*;

public class combat {
    public static void attackEnemy() {
        enemyHealth -= playerAttack;
        playerMana -= playerAttackCost;

        timer(1);

        if(playerMana < 8) {
            playerHealth = 0;
            playerMana = 0;
            print("You tried, but your mana has depleted!");
        } else {
            print(enemyName + " took " + playerAttack + " damage!");
        }
    }
    public static void healSelf() {
        if(playerHealth < 64){
            playerHealth += playerHeal;
            playerMana -= playerHealCost;
            boolean healPlayer = true;

        } else {
            print("Health already full!");
            boolean healPlayer = false;

        }
        if(playerMana < 8) {
            playerHealth = 0;
            playerMana = 0;
            print("You tried, but your mana has depleted!");
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
        print("You have: " + playerHealth + " HP, and " + playerMana + " mana.");
        print(enemyName + " has: " + enemyHealth + " HP, and " + enemyMana + " mana.");
    }
    public static void attackPlayer() {
        playerHealth -= playerAttack;
        enemyMana -= playerAttackCost;

        timer(1);

        if(enemyMana < 8) {
            enemyHealth = 0;
            enemyMana = 0;
            print(enemyName + " ran out of mana!");
        } else {
            print(enemyName + " attacked you for " + playerAttack + " damage!");
        }
    }
    public static void healEnemy() {
        if(enemyHealth < 64){
            enemyHealth += playerHeal;
            enemyMana -= playerHealCost;

        } else {
            print(enemyName + " healed for " + playerHeal + " HP");
            print("But their health is already full!");

        }
        if(enemyMana < 8) {
            enemyHealth = 0;
            enemyMana = 0;
            print(enemyName + " ran out of mana!");
        }
    }
    public static void postFightCheck() {
        if(playerHealth <= 0) {
            print("Game Over!");
            print("Meowst Match Streak: " + matchNum);
            boolean gameOver = true;
        } else if (enemyHealth <= 0) {
            print("Meowst Match " + matchNum + ": Win!");
            playerCaps += (playerMaxHealth / 2);
        }
    }
    public static void fullCombatLoop() {
        matchNum = matchNum + 1;
        print("Meowst Match " + matchNum + ": Begin!");

        timer(1);

        narrate("Looks like he's got "+ enemyHealth +" HP and "+ enemyMana +" Mana. Think you can handle it?");

        // Main Combat Loop
        while(playerHealth > 0 && enemyHealth > 0) {

            // Initial Prompt
            print("What will you do?:");
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
