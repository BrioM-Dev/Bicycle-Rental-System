public class Bicycle {
    private String bicycleName;
    private String bicycleMake;
    private String bicycleType;
    private boolean availability;

    public Bicycle(String name, String make, String type){
        this.bicycleName = name;
        this.bicycleMake = make;
        this.bicycleType = type;
        this.availability = true;
    }

    public Bicycle(String name){
        this.bicycleName = name;
    }

    public String getBicycleName() {
        return bicycleName;
    }
    public String getBicycleMake() {
        return bicycleMake;
    }
    public String getBicycleType() {
        return bicycleType;
    }

    public boolean isAvaliable(){
        return availability;
    }
    public void setAvailability(boolean isAvailabile) {
        this.availability = isAvailabile;
    }

    public void showBicycleInfo(){
        System.out.printf("Name: %\tMake: %\tType: %\tAvailability: %", bicycleName, bicycleMake,bicycleType, availability);
    }
}
