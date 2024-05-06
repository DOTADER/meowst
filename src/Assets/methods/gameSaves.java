package Assets.methods;

import java.io.*;

import static Assets.methods.dialogue.*;
import static Assets.vars.*;

public class gameSaves {
    public static void loadSave() {
        loadPlayerData();
        loadPlayerInv();
        print("Your playerData save path: " + playerData.getAbsolutePath() + " | File size: " + playerData.length() + " bytes");
        print("Your inventory save path: " + playerInv.getAbsolutePath() + " | File size: " + playerInv.length() + " bytes");
    }

    public static void loadPlayerData() {
        try {
            BufferedReader saveReader = new BufferedReader(new FileReader("saves/" + playerName + "/playerData.txt"));
            playerName = saveReader.readLine();
            enemyName = saveReader.readLine();
            playerHealth = Integer.parseInt(saveReader.readLine());
            playerMaxHealth = Integer.parseInt(saveReader.readLine());
            playerStamina = Integer.parseInt(saveReader.readLine());
            playerMaxStamina = Integer.parseInt(saveReader.readLine());
            playerAttack = Integer.parseInt(saveReader.readLine());
            playerCaps = Integer.parseInt(saveReader.readLine());
            matchNum = Integer.parseInt(saveReader.readLine());

            saveReader.close();
        } catch (IOException e) {
            print("Uh oh! An error occurred.");
            e.printStackTrace();
        }
    }

    public static void loadPlayerInv() {
        try {
            BufferedReader saveReader = new BufferedReader(new FileReader("saves/" + playerName + "/playerInv.txt"));
            invConsumables.add(saveReader.readLine());
            invWeapons.add(saveReader.readLine());

            saveReader.close();
        } catch (IOException e) {
            print("Uh oh! An error occurred.");
            e.printStackTrace();
        }
    }

    public static void loadPrompt() {
        print("What file? (type character name)");
        playerName = scanner.next();

        loadSave();

        print("You have: C$" + playerCaps + ", " + playerHealth + " HP, and " + playerStamina + " stamina.");

        print("Do you want to load \"" + playerName + "\"? [y/n]");
        if (scanner.next().equals("y")) {
            loadConfirm = true;
        } else if (scanner.next().equals("n")) {
            loadConfirm = false;
        }
    }

    public static void saveGame() {
        savePlayerData();
        savePlayerInv();
        print("Your playerData save path: " + playerData.getAbsolutePath() + " | File size: " + playerData.length() + " bytes");
        print("Your inventory save path: " + playerInv.getAbsolutePath() + " | File size: " + playerInv.length() + " bytes");
        print("Game saved!");
        timer(5);
    }

    public static void savePlayerData() {
        File saves = new File("saves/" + playerName);
        if (!saves.exists()){
            saves.mkdirs();
        }
        try {
            FileWriter playerSave = new FileWriter("saves/" + playerName + "/playerData.txt");
            playerSave.write(
                    playerName + "\n" +
                            enemyName + "\n" +
                            playerHealth + "\n" +
                            playerMaxHealth + "\n" +
                            playerStamina + "\n" +
                            playerMaxStamina + "\n" +
                            playerAttack + "\n" +
                            playerCaps + "\n" +
                            matchNum
            );
            playerSave.close();
        } catch (IOException e) {
            print("Uh oh! An error occurred.");
            e.printStackTrace();
        }
    }
    public static void savePlayerInv() {
        File saves = new File("saves/" + playerName);
        if (!saves.exists()){
            saves.mkdirs();
        }
        try {
            FileWriter playerSave = new FileWriter("saves/" + playerName + "/playerInv.txt");
            playerSave.write(
                    invConsumables.toString().replace("]", "").replace("[", "") + "\n" +
                            invWeapons.toString().replace("]", "").replace("[", "")
            );
            playerSave.close();
        } catch (IOException e) {
            print("Uh oh! An error occurred.");
            e.printStackTrace();
        }
    }
}
