public class Game {

    private int roll = 0;
    private int[] rolls = new int[21];

    public Game() {
    }

    public void roll(int pinDowns) {
        rolls[roll]=pinDowns;
        roll++;
    }

    public int score() {
        int score=0;
        int rollCursor=0;
        for (int frame = 0;frame<10;frame++){
            if (isStrike(rollCursor)){
                score = sumStrikeScore(score, rollCursor);
                rollCursor++;
            } else if (isSpare(rollCursor)){
                score = sumSpareScore(score, rollCursor);
                rollCursor+=2;
            } else{
                score = sumScore(score, rollCursor);
                rollCursor+=2;
            }
        }
        return score;
    }

    private int sumScore(int score, int cursor) {
        score += rolls[cursor] + rolls[cursor+1];
        return score;
    }

    private int sumSpareScore(int score, int cursor) {
        score += 10 + rolls[cursor+2];
        return score;
    }

    private int sumStrikeScore(int score, int cursor) {
        score += 10 + rolls[cursor+1] + rolls[cursor+2];
        return score;
    }

    private boolean isStrike(int cursor) {
        return rolls[cursor] == 10;
    }

    private boolean isSpare(int cursor) {
        return rolls[cursor] + rolls[cursor+1] == 10;
    }
}
