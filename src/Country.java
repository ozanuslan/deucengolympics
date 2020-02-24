public class Country {
    String country;
    int point;

    public Country(String country) {
        this.country = country;
        point = 0;
    }

    public String getCountry() {
        return country;
    }

    public int getPoint() {
        return point;
    }

    public void incrementPoint() {
        point++;
    }
}