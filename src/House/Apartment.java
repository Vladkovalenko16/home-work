package House;

public class Apartment {
    public int apartmentsNumber;
    public int floorsNumber;
    public boolean checkingResident = true;
    public Room[] rooms;
    public Resident resident;

     public Apartment (int apartmentsNumber, int floorsNumber, Room[] rooms){
         this.apartmentsNumber = apartmentsNumber;
         this.floorsNumber = floorsNumber;
         this.rooms = rooms;


     }
     public double apartmentsSquare(){
         double square = 0;
         for (int i = 0; i < rooms.length; i++) {
             square = square + rooms[i].roomsSquare;
         }
         return square;
     }

    public boolean moveInResident(Resident resident) {
        if (checkingResident) {
            System.out.println("Заселили " + resident.name);
            this.resident = resident;
            checkingResident = false;
        } else System.out.println("Квартира занята");
        return checkingResident;
    }
    public boolean moveOutResident(){
        if (!checkingResident){
            System.out.println("Выселели " + resident.name);
            this.resident = null;
            checkingResident = true;
        }else System.out.println("Квартира пуста");
        return checkingResident;
    }


}
