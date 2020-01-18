import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Before
    public void init(){
        game = new Game();
    }

    @Test
    public void canScoreGutterGame(){
        roll(0,0 ,  0,0 ,   0,0 ,  0,0 ,  0,0 , 0,0 ,  0,0 ,   0,0 ,  0,0 ,  0,0);
        assertEquals(game.score(),0);
    }

    @Test
    public void canScoreAGamesOfOnes(){
        roll(1,1,  1,1 ,  1,1 ,  1,1 ,  1,1 , 1,1 ,  1,1 ,  1,1 ,  1,1 ,  1,1);
        assertEquals(game.score(),20);
    }

    @Test
    public void canScoreSpareFollowedByThree(){
        roll (5, 5, 3,0 ,  0,0 ,  0,0 ,  0,0 ,  0,0 , 0,0 ,  0,0 ,   0,0 ,  0,0);
        assertEquals(game.score(),16);
    }

    @Test
    public void canScoreStrikeFollowedByThreeThenThree(){
        roll(10 , 3,3 , 0,0 , 0,0 , 0,0 , 0,0 , 0,0 , 0,0 , 0,0 , 0,0);
        assertEquals(game.score(),22);
    }

    @Test
    public void canScorePefectGame(){
        roll(10,10,10,10,10,10,10,10,10,10,10,10);
        assertEquals(game.score(), 300);
    }



    private void roll (int ... rolls){
        for (int pinDowns : rolls){
            game.roll(pinDowns);
        }
    }

}
