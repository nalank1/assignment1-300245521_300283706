public class Employee{

    private String name;

    private int hours;

    private double rate;

    private Address address;

    /* Constructor used for initializing the employee */


    public Employee(String name, int hours, double rate, Address address){
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.address = address;
    }

    /* returns the employee's name */

    public String getName(){
        return name;
    }

    /* returns the amount of hours the employee worked. */
    public int getHours(){
        return hours;
    }

    /* Returns the rate at which employee is paid. */
    public double getRate(){
        return rate;
    }

    /* Returns the address */
    public Address getAddress(){
        return address;
    }

    /*Return a string format of the employee imformation 
    including name, hours, rate and the reference to the address. */
    public String toString(){
        return "name: " + name + ", hours: " + hours + ", rate: " + rate + ", address: " + address;
    }

}