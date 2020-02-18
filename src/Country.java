public class Country{
    String country;
    int point;
    Match MATCHES[];

    public Country(String country){
        this.country = country;
        point = 0;
    }
    
    public void incrementPoint(){
        point++;
    }
}