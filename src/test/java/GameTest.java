
import junit.framework.Assert;
import org.example.Player;
import org.example.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
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
    public void test_gettingCurrentPlayerName(){
        // load players in game
        g.addPlayer(p1,p2,p3);
        // Shows first player information first
        String name = g.getCurrentPlayerName();
        Assert.assertEquals(name, p1.name);
        // Change the player turn to last player
        g.PLAYER_TURN = 2;
        // name should be last player name
        name = g.getCurrentPlayerName();
        Assert.assertEquals(name, p3.name);
    }
    @Test
    public void test_gettingCurrentPlayerScoreReturnsCorrectly(){
        //set scores
        p1.setScore(2000);
        p2.setScore(3000);
        p3.setScore(4000);
        // load players in game
        g.addPlayer(p1,p2,p3);

        // Shows first player information first
        long score = g.getCurrentPlayerScore();
        Assert.assertEquals(score, p1.score);
        // Change the player turn to last player
        g.PLAYER_TURN = 2;
        // score should be last player score
        score = g.getCurrentPlayerScore();
        Assert.assertEquals(score, p3.score);
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
        // Call the getCurrentPlayerName Method
        g.getCurrentPlayerName();
        // it should return the name and score of the player who turn it is
        Assert.assertEquals(p1.name, g.getCurrentPlayerName());
        // Change the Player Turn
        g.PLAYER_TURN = 1;
        // It should be P2 name now
        Assert.assertEquals(p2.name, g.getCurrentPlayerName());

    }
    @Test
    public void test_spinWheelReturnIntBetween100And1000In100Increments(){
        g.addPlayer(p1,p2);
        int wheelNumber = g.spinWheel();
        assert wheelNumber >= 100 && wheelNumber <= 1000;

    }
    @Test
    public void test_ifWheelSpinIs250_isBankruptSetCurrentPlayerScoreTo0(){
        g.addPlayer(p1,p2);
        // Change the score of player one
        p1.setScore(2000);
        p2.setScore(3000);
        // Spin the wheel return 250 or 350 which are Bankrupt numbers
        int wheelNumber = 250;
        // Pass the number to isBankrupt and it should set the score of the player to 0
        g.isBankrupt(wheelNumber);
        // p1 score is set to 0
        Assert.assertEquals(0, p1.score);
        // p2 score is still the same
        Assert.assertEquals(3000,p2.score);
    }
    @Test
    public void test_ifWheelSpinIs350_isBankruptSetsCurrentPlayerScoreTo0AndNextPlayerTurn(){
        g.addPlayer(p1,p2);
        // Change the score of player one
        p1.setScore(2000);
        p2.setScore(3000);
        // Spin the wheel return 250 or 350 which are Bankrupt numbers
        int wheelNumber = 350;
        // Pass the number to isBankrupt and it should set the score of the player to 0
        g.isBankrupt(wheelNumber);
        // p1 score is set to 0
        Assert.assertEquals(0, p1.score);
        // p2 score is still the same
        Assert.assertEquals(3000,p2.score);
        Assert.assertEquals(1,g.PLAYER_TURN);

    }
    @Test
    public void test_ifWheelSpinIsNot250Or350_isBankruptDoesNotSetCurrentPlayerScoreTo0(){
        g.addPlayer(p1,p2);
        // Change the score of player one
        p1.setScore(2000);
        p2.setScore(3000);
        // Spin the wheel return 250 or 350 which are Bankrupt numbers
        int wheelNumber = 200;
        // Pass the number to isBankrupt and it should set the score of the player to 0
        g.isBankrupt(wheelNumber);
        // p1 score is set to 0
        Assert.assertEquals(2000, p1.score);
        // p2 score is still the same
        Assert.assertEquals(3000,p2.score);
        Assert.assertEquals(0,g.PLAYER_TURN);
    }
    @Test
    public void test_ifWheelspinIs150_CurrentPlayerLoosesTheirTurn(){
        // Code for this tomorrow
        // add players
        g.addPlayer(p1,p2);
        // set their scores
        p1.setScore(2000);
        p2.setScore(3000);
        // set the wheel number to 150
        int wheelNumber = 150;
        // the current turn should be changed to the next player
        g.loseTurn(wheelNumber);
        Assert.assertEquals(1,g.PLAYER_TURN);
    }
    @Test
    public void test_ifWheelspinIsNot150_loseTurnDoesNotGoToNextPlayer(){
        // Code for this tomorrow
        // add players
        g.addPlayer(p1,p2);
        // set their scores
        p1.setScore(2000);
        p2.setScore(3000);
        // set the wheel number to 150
        int wheelNumber = 0;
        // the current turn should be changed to the next player
        g.loseTurn(wheelNumber);
        Assert.assertEquals(0,g.PLAYER_TURN);
        assert true;
    }
    @Test
    public void test_ifWheelspinIs150ForLastPlayer_loseTurnCorrectlySetsTheTurnToFirstPlayer(){
        // Code for this tomorrow
        // add players
        g.addPlayer(p1,p2);
        // set their scores
        p1.setScore(2000);
        p2.setScore(3000);
        // set the wheel number to 150
        int wheelNumber = 150;
        g.loseTurn(wheelNumber);
        g.loseTurn(wheelNumber);
        Assert.assertEquals(0,g.PLAYER_TURN);
    }
}
