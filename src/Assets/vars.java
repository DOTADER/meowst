package Assets;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vars {
    /*--- Define Variables ---*/

    /*--- Player ---*/
    public static String playerName = "";
    public static int playerHealth = 64;
    public static int playerMaxHealth = 64;
    public static int playerMana = 64;
    public static int playerMaxMana = 64;
    public static int playerAttack = 8;
    public static int playerAttackCost = playerAttack / 2;
    public static int playerHeal = 16;
    public static boolean healPlayer = true;
    public static int playerHealCost = playerHeal * 2;
    public static int playerCaps = 64;
    public static int matchNum = 0;

    public static int hasMonkeyFist = 0;
    public static int hasBrassKnuckles = 0;
    public static int hasGoldStaff = 0;
    public static int hasMace = 0;

    public static List<String> inventory = new ArrayList<String>();


    /*--- Enemy ---*/
    public static String enemyName = "";
    public static int enemyHealth = (int) ((Math.random() * ((playerMaxHealth + 4) - (playerMaxHealth - 16))) + (playerMaxHealth - 16));
    public static int enemyMana = (int) ((Math.random() * ((playerMaxMana + 8) - (playerMaxMana))) + (playerMaxMana));
    public static int enemyWillAttack = (int) ((Math.random() * (10 - 1)) + 1);


    /*--- System ---*/
    public static Scanner scanner = new Scanner(System.in);
    public static int findMaxMana = (int) ((Math.random() * (10 - 1)) + 1);
    public static boolean fightOver = false;
    public static boolean gameOver = false;
    public static boolean loadConfirm = true;
    public static File playerData = new File("saves/" + playerName + "/playerData.txt");
}