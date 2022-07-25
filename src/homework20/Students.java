package homework20;

import java.util.Objects;

public class Students {
    private long id;
    private String name;
    private String country;
    private String city;

    public Students(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Students)) return false;
        Students students = (Students) o;
        return getId() == students.getId() && getName().equals(students.getName()) && getCountry().equals(students.getCountry()) && getCity().equals(students.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountry(), getCity());
    }

    @Override
    public String toString() {
        return "homework20.Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
