package SankesAndLadders;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class SimulationMain {
    public static void main(String[] args) {
        String input = "2\n2 3 5 8\n1 2 4 9\n2\n9 1 6 3\n8 5 2 1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        Game game = new Game(10, 1);
        game.addplayer(new player("Harsh"));
        game.addplayer(new player("Siddhesh"));
        game.start();
    }
}
