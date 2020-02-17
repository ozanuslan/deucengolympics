class Sport{
    String sport;
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