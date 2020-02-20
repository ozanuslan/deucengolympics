public class Sport{
    String sport;
    Athlete[] ATHLETES_BY_SPORT = new Athlete[InputFile.METADATA.length];
    int playerCount;

    public Sport(String sport){
        this.sport = sport;
        this.playerCount = 1;
    }

    public String getSport(){
        return sport;
    }

    public int getPlayerCount(){
        return playerCount;
    }

    public void incrementPlayerCount(){
        playerCount++;
    }
}