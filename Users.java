import java.util.*;
public class Users {
    private String userName;
    private int userID;
    private ArrayList<Bicycle>borrowedBicycles;// = new ArrayList<Bicycle>();
 //   private [] borrowedBicycles;
    private int numberOfBorrowedBicycles = 0;

    public Users(String name, int id){
        this.userName = name;
        this.userID = id;
        this.borrowedBicycles = new ArrayList<Bicycle>(2);
    }
    public void addToList(String bicycleName, String bMake, String bType) {
        if (numberOfBorrowedBicycles < 2){
            Bicycle borrowed = new Bicycle(bicycleName, bMake, bType);
            borrowedBicycles.add(borrowed);
            numberOfBorrowedBicycles++;
        }
        else
            System.out.println("You can only rent 2 bicycles at a time.");
    }
    public int getNumberOfBorrowedBicycles(){
        return numberOfBorrowedBicycles;
    }
    public ArrayList<Bicycle> getListOfBorrowedBicycles(){
        return borrowedBicycles;
    }
    public boolean returnBicycle(String bicycleName) {
        boolean found = false;
        for (Bicycle b : borrowedBicycles) {
            if (Objects.equals(b.getBicycleName(), bicycleName)) {
                numberOfBorrowedBicycles--;
                return true;
            }
        }
        return false;
    }

}
