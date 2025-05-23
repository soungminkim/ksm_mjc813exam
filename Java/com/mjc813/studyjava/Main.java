package com.mjc813.studyjava;

/**
 * Main 클래스 - 테스트용
 * 각 클래스 인스턴스 생성 후 메서드 실행 예시
 */
public class Main {

    public static void main(String[] args) {

        // Animal 인스턴스
        Animal animal = new Animal("동물", 5);
        animal.eat("사료");
        animal.sleep();
        animal.move();
        Animal babyAnimal = animal.reproduce("새끼동물");
        babyAnimal.eat("풀");

        System.out.println();

        // Bird 인스턴스
        Bird bird = new Bird("참새", 2);
        bird.flap();
        bird.fly();
        Bird babyBird = bird.reproduce("새끼참새");
        babyBird.fly();

        System.out.println();

        // Parrot 인스턴스
        Parrot parrot = new Parrot("앵무새", 3);
        parrot.fly();                      // 재정의된 fly
        parrot.eat("곡식");                // String 타입 eat
        parrot.eat(new Animal("생쥐", 1)); // Animal 타입 eat는 부모 메서드 무시됨 (아무 출력 없음)
        Parrot babyParrot = parrot.reproduce("새끼앵무새");
        babyParrot.eat("옥수수");

        System.out.println();

        // Eagle 인스턴스
        Eagle eagle = new Eagle("독수리", 12);
        eagle.fly();                      // 재정의된 fly
        eagle.eat("생쥐");                // String 타입 eat 무시됨
        eagle.eat(new Animal("생쥐", 0)); // Animal 타입 eat 처리됨
        Eagle babyEagle = eagle.reproduce("새끼독수리");
        babyEagle.eat(new Animal("토끼", 1));

        System.out.println();

        // Mammalia 인스턴스
        Mammalia mammalia = new Mammalia("젖소", 7);
        mammalia.feedingMilk();
        mammalia.eat("건초");               // String 타입 eat 처리
        mammalia.eat(new Animal("생쥐", 0)); // String 이외 무시
        Mammalia babyMammalia = mammalia.reproduce("젖소아기");
        babyMammalia.eat("우유");

        System.out.println();

        // Herbivore 인스턴스
        Herbivore herbivore = new Herbivore("염소", 4);
        herbivore.eat("풀");
        Herbivore babyHerbivore = herbivore.reproduce("새끼염소");
        babyHerbivore.eat("나뭇잎");

        System.out.println();

        // Carnivore 인스턴스
        Carnivore carnivore = new Carnivore("사자 2", 3);
        carnivore.eat("염소");                // String 무시
        carnivore.eat(new Herbivore("염소", 0)); // Herbivore 타입 eat 처리
        Carnivore babyCarnivore = carnivore.reproduce("사자 3");
        babyCarnivore.eat(new Herbivore("얼룩말", 2));
    }
}
