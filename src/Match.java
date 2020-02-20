import java.util.Random;

public class Match {
    String sport;
    Athlete ath1;
    Athlete ath2;
    String winner;
    Random rnd = new Random();

    public Match(String sport, Athlete ath1, Athlete ath2) {
        this.sport = sport;
        this.ath1 = ath1;
        this.ath2 = ath2;
    }

    public String getSport() {
        return sport;
    }

    public String getWinner() {
        return winner;
    }

    private void setWinner(String winner) {
        this.winner = winner;
    }

    public void determineWinner() {
        if (ath1.skill > ath2.skill) {
            ath1.incrementPoint();
            setWinner(ath1.name);
        } else if (ath2.skill > ath1.skill) {
            ath2.incrementPoint();
            setWinner(ath2.name);
        } else {
            double dice = rnd.nextDouble();
            if (dice >= 0.50) {
                ath1.incrementPoint();
                setWinner(ath1.name);
            } else {
                ath2.incrementPoint();
                setWinner(ath2.name);
            }
        }
    }
}