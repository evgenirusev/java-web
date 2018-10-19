package data.repositories;

import data.models.Animal;

import java.util.HashMap;
import java.util.Map;

public class AnimalRepository {
    private Map<String, Animal> animals;

    public AnimalRepository() {
        this.animals = new HashMap<>();
    }

    public void addAnimal(Animal animal) {
        this.animals.put(animal.getName(), animal);
    }
}
