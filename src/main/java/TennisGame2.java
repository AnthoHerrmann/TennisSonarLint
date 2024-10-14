import java.util.Objects;

public class TennisGame2 implements TennisGame
{
    private int p1Point = 0;
    private int p2Point = 0;

    public TennisGame2(String player1Name, String player2Name) {
    }

    public String getScore(){
        String score = "";
        String p1Res = "";
        String p2Res = "";
        String love = "Love";
        String fifteen = "Fifteen";
        String thirty = "Thirty";
        String forty = "Forty";

        if (p1Point == p2Point) {
            if (p1Point < 3) {
                score = switch (p1Point) {
                    case 0 -> love;
                    case 1 -> fifteen;
                    case 2 -> thirty;
                    default -> "";
                };
                score += "-All";
            }
            else {
                score = "Deuce";
            }
        }
        else {
            p1Res = switch (p1Point) {
                case 0 -> love;
                case 1 -> fifteen;
                case 2 -> thirty;
                case 3 -> forty;
                default -> "";
            };

            p2Res = switch (p2Point) {
                case 0 -> love;
                case 1 -> fifteen;
                case 2 -> thirty;
                case 3 -> forty;
                default -> "";
            };

            score = p1Res + "-" + p2Res;
        }

        if (p1Point > p2Point && p2Point >= 2) {
            if ((p1Point - p2Point) >= 2) {
                score = "Win for player1";
            }
            else {
                score = "Advantage player1";
            }
        }

        if (p2Point > p1Point && p1Point >= 2) {
            if ((p2Point - p1Point) >= 2) {
                score = "Win for player2";
            }
            else {
                score = "Advantage player2";
            }
        }
        return score;
    }
    
    public void setP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            p1Score();
        }
            
    }
    
    public void setP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            p2Score();
        }
            
    }
    
    public void p1Score(){
        p1Point++;
    }
    
    public void p2Score(){
        p2Point++;
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, "player1"))
            p1Score();
        else
            p2Score();
    }
}