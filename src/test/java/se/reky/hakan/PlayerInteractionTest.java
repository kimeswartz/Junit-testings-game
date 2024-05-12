package se.reky.hakan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class PlayerInteractionTest {

    private SimplePlayerInteraction createPlayerInteraction(String playerName) {
        InputStream inputStream = new ByteArrayInputStream(playerName.getBytes());
        Scanner scanner = new Scanner(inputStream);
        IOHandler ioHandler = new IOHandler(scanner);
        return new SimplePlayerInteraction(ioHandler);
    }

    @Test
    void testSetupPlayer() {
        //Vi definerar spelarens namn
        String playerName = "testPlayer";

        // Skapar en instans av SimplePlayerInteraction med en scanner innehållande spelarens namn
        SimplePlayerInteraction playerInteraction = createPlayerInteraction(playerName);

        // Skapar en instans av en spelare
        Player player = new Player();

        // Anropar setupPlayer metoden
        playerInteraction.setupPlayer(player);

        // Verifierar att spelarens namn motsvarar vårt test-namn
        Assertions.assertEquals(playerName, player.getName());
    }

    @Test
    void testUpdatePlayerHealth() {
        //Vi skapar en instansering av simplePlayerInteraction med scanner
        SimplePlayerInteraction playerInteraction = createPlayerInteraction("testPlayer");

        // Instansiering av en testspelare
        Player player = new Player();
        player.setHp(10);

        // Kalla på uådatePlayerHealth() metoden med ett positivt och negativt värde
        playerInteraction.updatePlayerHealth(player, 5);
        playerInteraction.updatePlayerHealth(player, -3);

        // Kontrollera att spelarens hälsa har uppdaterats korrekt
        Assertions.assertEquals(12, player.getHp());

    }


}