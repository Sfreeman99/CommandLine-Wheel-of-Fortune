
import junit.framework.Assert;
import org.example.Player;
import org.example.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player p1,p2,p3,p4;
    Game g;

    @BeforeEach
    public void beforeEach(){
        // Initialize the Players
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        p4 = new Player();
        // Give them names
        p1.setName("Shedlia");
        p2.setName("Saveon");
        p3.setName("Shaddai");
        p4.setName("Channing");
        // Initialize Game
        g = new Game();

    }

    @Test
    public void test_GameInitsWithTwoPlayers(){

        Assert.assertFalse(g.START_GAME);
        Assert.assertEquals(0, g.PLAYER_TURN);
    }

    @Test
    public void test_WhenTwoPlayersAreAdded_GameStarts(){
        g.addPlayer(p1,p2);
        // Check and see if the players are two
        Assert.assertEquals(2, g.PLAYER_COUNT);
        // The game should be able to start now
        Assert.assertTrue(g.START_GAME);
    }
    @Test
    public void test_WhenThreePlayersAreAdded_GameStarts(){
        g.addPlayer(p1,p2,p3);
        // Check and see if the players are two
        Assert.assertEquals(3, g.PLAYER_COUNT);
        // The game should be able to start now
        Assert.assertTrue(g.START_GAME);
    }
    @Test
    public void test_WhenFourPlayersAreAdded_GameStarts(){
        g.addPlayer(p1,p2,p3,p4);
        // Check and see if the players are two
        Assert.assertEquals(4, g.PLAYER_COUNT);
        // The game should be able to start now
        Assert.assertTrue(g.START_GAME);
    }
    @Test
    public void test_getPlayer_returnsPlayerCorrectInformation(){
        // Add the players
        g.addPlayer(p1,p2);
        // Call the getPlayerName Method
        g.getPlayerName();
        // it should return the name and score of the player who turn it is
        Assert.assertEquals(p1.name, g.getPlayerName());
        // Change the Player Turn
        g.PLAYER_TURN = 1;
        // It should be P2 name now
        Assert.assertEquals(p2.name, g.getPlayerName());

    }
}
