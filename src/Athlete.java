class Athlete {
    String country;
    String sport;
    String name;
    String birthdate;
    String gender;
    double skill;
    int point;
    
    public Athlete(){
        country = "";
        sport = "";
        name = "";
        birthdate = "";
        gender = "";
        skill = 0;
        point = 0;
    }

    public String getCountry() {
        return country;
    }

    public String getSport() {
        return sport;
    }

    public String getName() {
        return name;
    }

    
    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthdate;
    }

    public double getSkill() {
        return skill;
    }

    public int getPoint() {
        return point;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setSkill(String skill) {
        this.skill = Double.parseDouble(skill);
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void incrementPoint() {
        point++;
    }
}