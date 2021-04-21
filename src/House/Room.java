package House;

public class Room {
    private double roomsSquare;
    private String roomsName;

    public Room(String roomsName, double roomsSquare) {
        this.roomsName = roomsName;
        this.roomsSquare = roomsSquare;
    }

    public String getRoomsName() {
        return roomsName;
    }

    public double getRoomsSquare() {
        return roomsSquare;
    }
}
