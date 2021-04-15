package House;

import java.util.Arrays;

public class Building {
    public final double PRISE_PER_METER = 2;
    public  Apartment[] apartments;

    public Building (){
    }

    public Building (Apartment[] apartments){
        this.apartments = apartments;
    }

    public void  makeListAllResidents(){
        for (int i = 0; i < apartments.length; i++) {
            System.out.println(apartments[i].resident.name);
        }
    }

    public  String lookingResidentInApartment(int numberOfApartment){
        String residentName = null;
        for (int i = 0; i < apartments.length; i++) {
            if(apartments[i].apartmentsNumber == numberOfApartment){
                residentName = apartments[i].resident.name;
                break;
            }
        }
        return residentName;
    }
    public Apartment[] sortsApartmentsBySquare(Apartment[] apartments){
        if(apartments.length < 2){
            return  apartments;
        }
        for (int i = apartments.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                double a = apartments[j].apartmentsSquare();
                double b = apartments[j + 1].apartmentsSquare();
                if (apartments[j].apartmentsSquare() < apartments[j +1].apartmentsSquare()){
                    Apartment apartment1 = apartments[j];
                    apartments[j] = apartments[j +1];
                    apartments[j + 1] = apartment1;
                }
            }
        }
        return apartments;
    }
    public Resident[] sortResidentsByMoney(Resident[] residents){
        if (residents.length < 2) {
            return residents;
        }
        for (int i = residents.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (residents[j].money < residents[j + 1].money){
                    Resident resident = residents[j];
                    residents[j] = residents[j + 1];
                    residents[j + 1] = resident;
                }
            }
        }
        return residents;
    }
    public Resident[] moveInResidents(Resident[] residents){
        apartments = sortsApartmentsBySquare(apartments);
        residents = sortResidentsByMoney(residents);
        for (int i = 0; i < apartments.length ; i++) {
            if (apartments[i].checkingResident){
                    if (residents.length == 0) break;
                    apartments[i].moveInResident(residents[0]);
                    residents = Arrays.copyOfRange(residents, 1, residents.length);
            }
        }
        return residents;
    }






}
