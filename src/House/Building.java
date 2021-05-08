package House;

import java.util.ArrayList;
import java.util.Arrays;

public class Building {
    public static final double PRISE_PER_METER = 2;
    public ArrayList<Apartment> apartments;

    public Building() {
        apartments = new ArrayList<>();
    }

    public Building(ArrayList<Apartment> apartments) {
        this.apartments = apartments;
    }

    public ArrayList<String> returnResidentsName() {
        ArrayList<String> residents = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.getTryResident()) {
                residents.add(apartment.getResident().getName());
            }
        }
        return residents;
    }


    public String lookingResidentInApartment(int numberOfApartment) {
        for (Apartment apartment : apartments) {
            if (apartment.getNumber() == numberOfApartment && apartment.getTryResident()) {
                return apartment.getResident().getName();
            }
        }
        throw new RuntimeException("В квартире никто не живет");
    }

    public ArrayList<Apartment> sortsApartmentsBySquare(ArrayList<Apartment> apartments) {
        if (apartments.size() < 2) {
            return apartments;
        }
        for (int i = apartments.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (apartments.get(j).apartmentsSquare() < apartments.get(j + 1).apartmentsSquare()) {
                    Apartment apartment1 = apartments.get(j);
                    apartments.set(j, apartments.get(j + 1));
                    apartments.set(j + 1, apartment1);
                }
            }
        }
        return apartments;
    }

    public ArrayList<Resident> sortResidentsByMoney(ArrayList<Resident> residents) {
        if (residents.size() < 2) {
            return residents;
        }
        for (int i = residents.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (residents.get(j).getMoney() < residents.get(j + 1).getMoney()) {
                    Resident resident = residents.get(j);
                    residents.set(j, residents.get(j + 1));
                    residents.set(j + 1, resident);
                }
            }
        }
        return residents;
    }

    public ArrayList<Resident> moveInResidents(ArrayList<Resident> residents) {
        ArrayList<Apartment> sortingApartments = sortsApartmentsBySquare(apartments);
        ArrayList<Resident> sortingResidents = sortResidentsByMoney(residents);

        for (Apartment apartment : sortingApartments) {
            if (!apartment.getTryResident()) {
                if (sortingResidents.size() < 0) {
                    break;
                }
                apartment.moveInResident(sortingResidents.get(0));
                sortingResidents.remove(0);
            }
        }

        return sortingResidents;
    }

    public void addsApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public double priseOfApartment(double square) {
        return square * PRISE_PER_METER;
    }

    public double collectMoney() {
        double money = 0;
        for (Apartment apartment : apartments) {
            if (apartment.getTryResident()) {
                double price = priseOfApartment(apartment.apartmentsSquare());
                if (apartment.getResident().getMoney() < price) {
                    money += apartment.getResident().getMoney();
                    apartment.getResident().setMoney(apartment.getResident().getMoney());
                    apartment.moveOutResident();
                } else {
                    apartment.getResident().setMoney(price);
                    money += price;
                }
            }
        }
        return money;
    }
}
