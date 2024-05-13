package se.reky.hakan.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

class GameUtilTest {

    @Test
    void testToLowerCaseButFirstLetterCapitalized_NullInput() {
        GameUtil gameUtil = new GameUtil();

        //Kontrollera att GameException körs vid null
        Assertions.assertThrows(GameException.class, () -> {
            gameUtil.toLowerCaseButFirstLetterCapitalized(null);
        });
    }


}