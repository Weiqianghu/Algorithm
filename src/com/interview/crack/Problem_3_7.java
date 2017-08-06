package com.interview.crack;

import java.util.LinkedList;
import java.util.List;

public class Problem_3_7 {
    public static void main(String[] args) {
        Hospice hospice = new Hospice();

        Dog dog1 = new Dog("dog dog1");
        Dog dog2 = new Dog("dog dog2");

        Cat cat1 = new Cat("cat cat1");


        hospice.enqueue(dog1);
        hospice.enqueue(cat1);
        hospice.enqueue(dog2);

        System.out.println(hospice.dequeueAny());
        System.out.println(hospice.dequeueCat());
        System.out.println(hospice.dequeueDog());

    }

    private static class Hospice {
        private List<Animal> animals = new LinkedList<>();


        public Animal enqueue(Animal animal) {
            animals.add(animal);
            return animal;
        }

        public Animal dequeueAny() {
            if (animals.isEmpty()) {
                return null;
            }

            Animal animal = animals.get(0);
            animals.remove(animal);

            return animal;
        }

        public Dog dequeueDog() {
            Dog dog = null;
            for (Animal animal : animals) {
                if (animal instanceof Dog) {
                    dog = (Dog) animal;
                    break;
                }
            }

            if (dog != null) {
                animals.remove(dog);
            }
            return dog;
        }

        public Cat dequeueCat() {
            Cat cat = null;
            for (Animal animal : animals) {
                if (animal instanceof Cat) {
                    cat = (Cat) animal;
                    break;
                }
            }

            if (cat != null) {
                animals.remove(cat);
            }
            return cat;
        }
    }

    private static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private static class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }
    }

    private static class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }
    }
}
