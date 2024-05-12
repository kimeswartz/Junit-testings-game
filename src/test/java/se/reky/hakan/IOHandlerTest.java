package se.reky.hakan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import se.reky.hakan.IOHandler;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class IOHandlerTest {

    private IOHandler ioHandler(String dataForScanner) {
        Scanner scanner = new Scanner(dataForScanner);
        return new IOHandler(scanner);
    }

    @Test
    void testNextLine() {
        // Vi definerar strängen som ska testas
        String userInputString = "yes";

        // Vi skapar ett Scanner object med vår input
        IOHandler ioHandler = ioHandler(userInputString);

        // Vi anropar nextLine() metoden för scanner
        String result = ioHandler.nextLine();

        // Vi använder assertequals för att se om inputString och result är likvärdiga.
        Assertions.assertEquals(userInputString, result);
    }

    @Test
    void testHasNextInt() {
        String inputNumber = "123";

        IOHandler ioHandler = ioHandler(inputNumber);

        boolean result = ioHandler.hasNextInt();

        Assertions.assertTrue(result);
    }

}
