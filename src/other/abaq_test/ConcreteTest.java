package other.abaq_test;

public class ConcreteTest implements InterfaceB, InterfaceA{

    public static void main(String[] args) {
         ConcreteTest ct = new ConcreteTest();
         System.out.println(ct.addOne());
    }


    @Override
    public String addOne() {
        return InterfaceA.super.addOne();
    }
}
