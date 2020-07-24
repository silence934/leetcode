package xyz.nyist.asd;


/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/11 19:01
 */
public class Test10 {
    static abstract class Breakfast {
        abstract void cooking();
    }

    static class Cooker {
        public void make() {
            System.out.println("厨师做饭");
        }
    }

    static class Waiter extends Breakfast {
        private Cooker cooker = new Cooker();

        @Override
        void cooking() {
            System.out.println("服务员收到购买指令...");
            cooker.make();
            System.out.println("服务员将结果返回发起者");
        }
    }

    static class Customer {
        Breakfast breakfast;

        public Customer(Breakfast breakfast) {
            this.breakfast = breakfast;
        }

        public void buyBreakfast() {
            System.out.println("客户买早饭...");
            breakfast.cooking();
            System.out.println("客户买到早饭");
        }
    }

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Customer customer = new Customer(waiter);
        customer.buyBreakfast();
    }
}
