package House;

import java.util.Arrays;

public class Building {
    public final double PRISE_PER_METER = 2;
    public Apartment[] apartments;

    public Building() {
    }

    public Building(Apartment[] apartments) {
        this.apartments = apartments;
    }

    public void makeListAllResidents() {
        for (int i = 0; i < apartments.length; i++) {
            System.out.println(apartments[i].resident.name);
        }
    }

    public String lookingResidentInApartment(int numberOfApartment) {
        String residentName = null;
        for (int i = 0; i < apartments.length; i++) {
            if (apartments[i].apartmentsNumber == numberOfApartment) {
                residentName = apartments[i].resident.name;
                break;
            }
        }
        return residentName;
    }

    public Apartment[] sortsApartmentsBySquare(Apartment[] apartment) {
        for (int i = apartment.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (apartment[j].apartmentsSquare() > apartment[j + 1].apartmentsSquare()) {
                    Apartment apartment1 = apartment[j];
                    apartment[j] = apartment[j + 1];
                    apartment[j + 1] = apartment1;
                }
            }
        }
        return apartment;
    }

    public Resident[] sortResidentsByMoney(Resident[] residents) {
        for (int i = residents.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (residents[j].money > residents[j + 1].money) {
                    double money = residents[j].money;
                    residents[j].money = residents[j + 1].money;
                    residents[j + 1].money = money;
                }
            }
        }
        return residents;
    }


}
