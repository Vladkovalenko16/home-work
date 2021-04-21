package House;

public class Apartment {
    private int Number;
    private int floorNumber;
    private Room[] rooms;
    private Resident resident;

    public Apartment(int apartmentsNumber, int floorsNumber, Room[] rooms) {
        this.Number = apartmentsNumber;
        this.floorNumber = floorsNumber;
        this.rooms = rooms;
    }

    public int getNumber() {
        return Number;
    }

    public int getFloorNumber() {
        return floorNumber;
    }


    public Room[] getRooms() {
        return rooms;
    }

    public Resident getResident() {
        return resident;
    }

    public double apartmentsSquare() {
        double square = 0;
        for (int i = 0; i < rooms.length; i++) {
            square = square + rooms[i].getRoomsSquare();
        }
        return square;
    }

    public void moveInResident(Resident resident) {
        if (this.resident == null) {
            Main.print("Заселили " + resident.getName());
            this.resident = resident;
        } else {
            Main.print("Квартира занята");
        }

    }

    public void moveOutResident() {
        if (this.resident != null) {
            Main.print("Выселели " + resident.getName());
            this.resident = null;
        } else {
            Main.print("Квартира пуста");
        }
    }


}
