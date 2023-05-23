import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Person {
    private String fullName;
    private String address;
    private Date birthday;
    private boolean sentence;
    private int prisonTime;

    private String[] friends;


    public Person() {}

    public Person(String fullName, String address, Date birthday, boolean sentence, int prisonTime) {
        this.fullName = fullName;
        this.address = address;
        this.birthday = birthday;
        this.sentence = sentence;
        this.prisonTime = prisonTime;
    }

    public Person(String fullName, String address, Date birthday, boolean sentence, int prisonTime,String[] friends) {
        this.fullName = fullName;
        this.address = address;
        this.birthday = birthday;
        this.sentence = sentence;
        this.prisonTime = prisonTime;
        this.friends = friends;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isSentence() {
        return sentence;
    }

    public void setSentence(boolean sentence) {
        this.sentence = sentence;
    }

    public int getPrisonTime() {
        return prisonTime;
    }

    public void setPrisonTime(int prisonTime) {
        this.prisonTime = prisonTime;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", sentence=" + sentence +
                ", prisonTime=" + prisonTime +
                '}';
    }

    public String actorToString(){
        return toString()+"\nFriends : "+friends;
    }
}
