package prb1603;
/**
  * ParkingSystem.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class ParkingSystem {

    int big,small,medium;

    public ParkingSystem(int small, int medium, int big) {
        this.small = small;
        this.medium = medium;
        this.big = big;
    }

    public boolean addCar(int carType) {
        if(carType==1 && this.small!=0) {
            this.small--;
            return true;
        } else if( carType==2 && this.medium!=0 ) {
            this.medium--;
            return true;
        } else if(carType==3 && this.big!=0){
            this.big--;
            return true;
        }
        return false;
    }

    public static void main( String[] args ) {
        ParkingSystem parkingSystem = new ParkingSystem(0, 0, 2);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar( 2 ));
        System.out.println(parkingSystem.addCar( 3 ));
    }
}
