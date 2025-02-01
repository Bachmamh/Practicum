public class People {
    String ID;
    String FirstName;
    String LastName;
    String Title;
    int YearOfBirth;


    public People(String ID, String FirstName, String LastName, String Title, int YearOfBirth) {
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Title = Title;
        this.YearOfBirth = YearOfBirth;


    }

    public String toString() {
        return ID + ", " + FirstName + ", " + LastName + ", " + Title + ", " + YearOfBirth;
    }
}