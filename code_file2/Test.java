public class Test {

    public static void main(String[] args){

        Address[] address = new Address[6];

        address[0] = new Address("Queen", 48, "K1P1N2");
        address[1] = new Address("King Edward", 800, "K1N6N5");

        Employee o1;

        o1 = new Employee("Falcao", 40, 15.50, address[0]);

        System.out.println(o1);
        System.out.println(address[0]);
        System.out.println(address[1]);
    }
    
}
