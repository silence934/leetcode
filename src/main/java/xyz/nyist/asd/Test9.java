package xyz.nyist.asd;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/11 20:48
 */
public class Test9 {
    static abstract class Farm {
        abstract void newAnimal();

        abstract void newPlant();
    }

    static abstract class Product {
        abstract void behavior();
    }

    static class horse extends Product {

        @Override
        void behavior() {
            System.out.println("我是马🐎,生产中....");
        }
    }

    static class cow extends Product {

        @Override
        void behavior() {
            System.out.println("我是牛🐂,生产中....");
        }
    }

    static class Food extends Product {

        @Override
        void behavior() {
            System.out.println("我是蔬菜,生产中....");
        }
    }

    static class Fruit extends Product {

        @Override
        void behavior() {
            System.out.println("我是水果,生产中....");
        }
    }


    static class GuangzhouFarm extends Farm {
        private Product animal;
        private Product plant;

        public GuangzhouFarm(Product animal, Product plant) {
            this.animal = animal;
            this.plant = plant;
        }

        @Override
        void newAnimal() {
            System.out.println("广州工厂，开始生产动物...");
            animal.behavior();
            System.out.println("生产完毕");
        }

        @Override
        void newPlant() {
            System.out.println("广州工厂，开始生产种菜...");
            plant.behavior();
            System.out.println("生产完毕");
        }
    }

    static class BeijingFarm extends Farm {
        private Product animal;
        private Product plant;

        public BeijingFarm(Product animal, Product plant) {
            this.animal = animal;
            this.plant = plant;
        }

        @Override
        void newAnimal() {
            System.out.println("北京工厂，开始生产动物...");
            animal.behavior();
            System.out.println("生产完毕");
        }

        @Override
        void newPlant() {
            System.out.println("北京工厂，开始生产种菜...");
            plant.behavior();
            System.out.println("生产完毕");
        }
    }

    public static void main(String[] args) {
        Product horse = new horse();
        Product cow = new cow();
        Product food = new Food();
        Product fruit = new Fruit();
        Farm guangzhouFarm = new GuangzhouFarm(cow, fruit);
        guangzhouFarm.newAnimal();
        System.out.println("----------");
        guangzhouFarm.newPlant();
        System.out.println("----------");
        Farm beijingFarm = new BeijingFarm(horse, food);
        beijingFarm.newAnimal();
        System.out.println("----------");
        beijingFarm.newPlant();
        System.out.println("----------");
    }

}
