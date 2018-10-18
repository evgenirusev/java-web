package entities;

public class Animal {
    private String name;
    private String breed;
    private String color;
    private String numberOfLegs;

    public Animal(String name, String breed, String color, String numberOfLegs) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(String numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
}
