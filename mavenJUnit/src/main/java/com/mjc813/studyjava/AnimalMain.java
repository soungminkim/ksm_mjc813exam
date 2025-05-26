package com.mjc813.studyjava;

public class AnimalMain {
    public static void main(String[] agrs) {
        Animal animal = new Animal("동물", 3);
        animal.sleep();
        animal.eat(300);
        animal.move();
        Animal animalChild = animal.reproduce("동물자손");
        animalChild.sleep();
        animalChild.eat(3);
        animalChild.move();

        Bird bird = new Bird("새", 5, "새날개");
        bird.sleep();
        bird.eat("새모이");
        bird.move();
        bird.flap();
        bird.fly();
        Bird birdChild = (Bird)bird.reproduce("새아기");

        birdChild.sleep();
        birdChild.eat("새아기모이");
        birdChild.move();
        birdChild.flap();
        birdChild.fly();

        Eagle eagle = new Eagle("독수리", 3, "독수리날개");
        eagle.sleep();
        eagle.eat(birdChild);
        eagle.eat("새모이");
        eagle.move();
        eagle.flap();
        eagle.fly();
        Eagle eagleChild = (Eagle)eagle.reproduce("독수리새끼");
        eagleChild.eat(600);
        eagleChild.eat("600");
        eagleChild.eat(animalChild);
        eagle.fly();


        Herbivore rabbit = new Herbivore("토끼", 3);
        Herbivore rabbitChild = (Herbivore)rabbit.reproduce("토끼애기");

        Carnivore carnivore = new Carnivore("호랑이", 6);
        carnivore.sleep();
        carnivore.eat(rabbitChild);
        carnivore.eat("새모이");
        carnivore.move();
        Carnivore carnivoreChild = (Carnivore)carnivore.reproduce("호랑이새끼");
        carnivoreChild.eat(600);
        carnivoreChild.eat("600");
        carnivoreChild.eat(animalChild);
        carnivoreChild.move();
    }
}
