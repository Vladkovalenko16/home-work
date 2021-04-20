package House;

public class Apartment {
    private int Number;
    private int floorNumber;
    private boolean checkingResident = true;
    private Room[] rooms;
    private Resident resident;

     public Apartment (int apartmentsNumber, int floorsNumber, Room[] rooms){
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

    public boolean isCheckingResident() {
        return checkingResident;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public Resident getResident() {
        return resident;
    }

    public double apartmentsSquare(){
         double square = 0;
         for (int i = 0; i < rooms.length; i++) {
             square = square + rooms[i].getRoomsSquare();
         }
         return square;
     }

    public boolean moveInResident(Resident resident) {
        if (this.resident == null) {
            System.out.println("Заселили " + resident.getName());
            this.resident = resident;
            checkingResident = false;
        } else System.out.println("Квартира занята");
        return checkingResident;
    }
    public boolean moveOutResident(){
        if (this.resident != null){
            System.out.println("Выселели " + resident.getName());
            this.resident = null;
            checkingResident = true;
        }else System.out.println("Квартира пуста");
        return checkingResident;
    }


}
