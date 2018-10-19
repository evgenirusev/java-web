package data.models;

public class Animal {
    private String name;
    private String breed;
    private String color;
    private int numberOfLegs;

    public Animal(String name, String breed, String color, int legs) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.numberOfLegs = legs;
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

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
}
