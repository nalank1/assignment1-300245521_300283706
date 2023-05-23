public class Address{

    private String street;

    private int number;

    private String postal;

    //constructor
    public Address(String street, int number, String postal){
        this.street = street;
        this.number = number;
        this.postal = postal;
    }

    //getters and setter
    public String getStreet(){
        return street;
    }

    public int getNumber(){
        return number;
    }

    public String getPostal(){
        return postal;
    }

    public String toString(){
        return "Street: " + street + ", number: " + number + ", postal: "+ postal;
    }
}