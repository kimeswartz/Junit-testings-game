package se.reky.hakan.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActorTest {

    @Test
    void testActorAttack() {

        // Vi skapar två motståndare
        Goblin attacker = new Goblin("Goblin Attacker", 20, 3);
        Guard opponent = new Guard("Guard Opponent", 30, 5);

        int originalOpponentHP = opponent.getHp();

        //Attackera motståndaren
        attacker.attack(opponent);

        //Beräkna förväntat HP för motståndaren efter attacken
        int expectedTargetHP = originalOpponentHP - attacker.getDamage();

        //Verifier att attacken minskade motståndarens HP
        Assertions.assertEquals(expectedTargetHP, opponent.getHp());
    }


}