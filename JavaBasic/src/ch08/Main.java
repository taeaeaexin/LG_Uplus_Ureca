package ch08;

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println(name + "이/가 소리를 냅니다.");
    }

    void move() {
        System.out.println(name + "이/가 움직입니다.");
    }
}

// Subclass
class Mammal extends Animal {
    Mammal(String name) {
        super(name);
    }

    @Override
    void move() {
        System.out.println(super.name + "이/가 땅을 걷습니다.");
    }
}

// Another subclass
class Bird extends Animal {
    Bird(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(super.name + "이/가 지져귑니다.");
    }

    @Override
    void move() {
        System.out.println(super.name + "이/가 하늘을 납니다.");
    }
}

// Another subclass
class Fish extends Animal {
    Fish(String name) {
        super(name);
    }

    @Override
    void move() {
        System.out.println(super.name + "이/가 수영합니다.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal("동물");
        Mammal dog = new Mammal("개");
        Bird sparrow = new Bird("독수리");
        Fish salmon = new Fish("참치");

        genericAnimal.makeSound();
        genericAnimal.move();

        dog.makeSound();
        dog.move();

        sparrow.makeSound();
        sparrow.move();

        salmon.makeSound();
        salmon.move();
    }
}