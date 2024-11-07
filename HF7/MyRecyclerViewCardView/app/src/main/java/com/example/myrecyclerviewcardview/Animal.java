package com.example.myrecyclerviewcardview;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private String info;
    private int imageDrawable;

    public Animal(String name, String info, int imageDrawable) {
        this.imageDrawable = imageDrawable;
        this.info = info;
        this.name = name;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Octopus", "8 tentacled monster", R.drawable.octopus));
        animals.add(new Animal("Pig", "Delicious in rolls", R.drawable.pig));
        animals.add(new Animal("Sheep", "Great for jumpers", R.drawable.sheep));
        animals.add(new Animal("Rabbit", "Nice in a stew", R.drawable.rabbit));
        animals.add(new Animal("Giraffe", "Great for shoes", R.drawable.giraffe));
        animals.add(new Animal("Dog", "", R.drawable.dog));
        animals.add(new Animal("Cat", "", R.drawable.cat));
        animals.add(new Animal("Horse", "", R.drawable.horse));
        animals.add(new Animal("Lion", "Scary", R.drawable.lion));

        return animals;
    }
}
