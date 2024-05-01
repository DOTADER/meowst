package Assets.methods;

import java.util.concurrent.TimeUnit;

public class dialogue {
    public static void print(String str) {
        System.out.println(str);
    }
    public static void narrate(String str) {
        print("[NARRATOR] " + str);
    }
    public static void option(String str) {
        print("[OPTION] " + str);
    }
    public static void timer(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
