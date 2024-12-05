package org.softwaretechnologies;

public final class Elevator {


    private int currentFloor;


    private final int highestFloor;


    private final int lowestFloor;


    public Elevator(int lowestFloor, int highestFloor) {
        this.currentFloor = lowestFloor;
        this.highestFloor = highestFloor;
        this.lowestFloor = lowestFloor;
    }


    private void goDown() {

        currentFloor--;
    }


    private void goUp() {
        currentFloor++;
    }


    public void goToExactFloor(int floor) {

        if (floor > highestFloor || floor < lowestFloor) {
            System.out.println("Указан неверный этаж");
            return;
        }
        while(currentFloor != floor) {
                System.out.println("Текущий этаж: " + currentFloor);
                if(currentFloor > floor) {
                    goDown();
                }
                else {
                    goUp();
                }
        }
        System.out.println("Вы достигли указанного этажа: " + currentFloor);
    }


    public int getCurrentFloor() {

        return currentFloor;
    }
}
