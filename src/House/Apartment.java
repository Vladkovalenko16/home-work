package House;

public class Apartment {
    public int apartmentsNumber;
    public int floorsNumber;
    public boolean checkingResident = true;

     public Apartment (int apartmentsNumber, int floorsNumber, String[] rooms){
         this.apartmentsNumber = apartmentsNumber;
         this.floorsNumber = floorsNumber;


     }

    public boolean moveInResident(String name) {
        if (checkingResident) {
            System.out.println("Заселили " + name);
            checkingResident = false;
        } else System.out.println("Квартира занята");
        return checkingResident;
    }
    public boolean moveOutResident(String name){
        if (!checkingResident){
            System.out.println("Выселели " + name);
            checkingResident = true;
        }else System.out.println("Квартира пуста");
        return checkingResident;
    }


}
