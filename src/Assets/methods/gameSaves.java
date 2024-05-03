package Assets.methods;

import java.io.*;

import static Assets.methods.dialogue.*;
import static Assets.vars.*;

public class gameSaves {
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
            hasMonkeyFist = Integer.parseInt(saveReader.readLine());
            hasBrassKnuckles = Integer.parseInt(saveReader.readLine());
            hasGoldStaff = Integer.parseInt(saveReader.readLine());
            hasMace = Integer.parseInt(saveReader.readLine());

            saveReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        print("Your save path: " + playerData.getAbsolutePath());
        print("File size: " + playerData.length() + " bytes");
    }
    public static void loadPrompt() {
        print("What file? (type character name)");
        playerName = scanner.next();

        loadSave();

        print("You have: C$" + playerCaps + ", " + playerHealth + " HP, and " + playerMana + " mana.");

        print("Do you want to load \"" + playerName + "\"? [y/n]");
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
                            matchNum + "\n" +
                            hasMonkeyFist + "\n" +
                            hasBrassKnuckles + "\n" +
                            hasGoldStaff + "\n" +
                            hasMace
            );
            print("Your save path: " + playerData.getAbsolutePath());
            print("File size: " + playerData.length() + " bytes");
            print("Game saved!");
            timer(5);
            playerSave.close();
        } catch (IOException e) {
            print("Uh oh! An error ocurred.");
            e.printStackTrace();
        }
    }
}
