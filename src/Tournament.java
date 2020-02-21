public class Tournament{
    Sport sport;
    Match[] MATCHES;

    public Tournament(Sport sport){
        this.sport = sport;
        int matchCount= (sport.ATHLETES_BY_SPORT.length*sport.ATHLETES_BY_SPORT.length-1)/2;
        MATCHES = new Match[matchCount];
    }

    public Match[] generateMatches(){
        return MATCHES;
    }
}