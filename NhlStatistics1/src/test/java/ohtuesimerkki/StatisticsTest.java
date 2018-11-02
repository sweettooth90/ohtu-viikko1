package ohtuesimerkki;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }

    @Test
    public void testPlayerFound() {
        Player player = stats.search("Semenko");
        assertEquals("Semenko", player.getName());
    }

    @Test
    public void testPlayerNotFound() {
        Player player = stats.search("Test");
        assertEquals(null, player);
    }
   
    @Test
    public void testTopScorers() {
        assertEquals(1, stats.topScorers(0).size());
    }

    @Test
    public void testTeam() {
        assertEquals(3, stats.team("EDM").size());
    }
}