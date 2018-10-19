package data.repositories;

import data.models.Animal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnimalRepository implements Iterable<Animal> {
    private Map<String, Animal> animals;

    public AnimalRepository() {
        this.animals = new HashMap<>();
    }

    public void addAnimal(Animal animal) {
        this.animals.put(animal.getName(), animal);
    }

    @Override
    public Iterator<Animal> iterator() {
        Iterator<Animal> iAnimal = animals.values().iterator();
        return iAnimal;
    }
}
