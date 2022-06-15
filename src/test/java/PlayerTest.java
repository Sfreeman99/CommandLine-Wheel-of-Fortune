import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;

public class PlayerTest {

    Player p;

    @BeforeEach
    public void beforeEach() {
         p = new Player();
    }

    @Test
    public void test_PlayerInitsCorrectly(){
        Assert.assertEquals(0,p.score);
        Assert.assertNull(null, p.name);
    }
    @Test
    public void test_PlayerNameCanBeUpdated(){
        p.setName("test");
        Assert.assertEquals("test", p.name);
    }
    @Test
    public void test_PlayerScoreSetsCorrectly(){
        p.setScore(100);
        Assert.assertEquals(100, p.score);
    }
}
