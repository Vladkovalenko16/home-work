package House;

import java.util.ArrayList;

public class Apartment {
    private final int number;
    private final int floorNumber;
    private final ArrayList<Room> rooms;
    private Resident resident;
    private boolean tryResident;

    public Apartment(int apartmentsNumber, int floorsNumber, ArrayList<Room> rooms) {
        this.number = apartmentsNumber;
        this.floorNumber = floorsNumber;
        this.rooms = rooms;
    }

    public int getNumber() {
        return number;
    }

    public boolean getTryResident(){
        return tryResident;
    }

    public int getFloorNumber() {
        return floorNumber;
    }


    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Resident getResident() {
        return resident;
    }

    public double apartmentsSquare() {
        double square = 0;
        for (int i = 0; i < rooms.size(); i++) {
            square = square + rooms.get(i).getRoomsSquare();
        }
        return square;
    }

    public boolean moveInResident(Resident resident) {
        if (!tryResident) {
            Main.print("Заселили " + resident.getName());
            this.resident = resident;
            tryResident = true;
        } else {
            Main.print("Квартира занята");
        }
        return tryResident;

    }

    public boolean moveOutResident() {
        if (tryResident) {
            Main.print("Выселили " + resident.getName());
            tryResident = false;
        } else {
            Main.print("Квартира пуста");
        }
        return tryResident;
    }


}
