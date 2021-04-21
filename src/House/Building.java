package House;

import java.util.Arrays;

public class Building {
    public static final double PRISE_PER_METER = 2;
    public Apartment[] apartments;

    public Building() {
        apartments = new Apartment[0];
    }

    public Building(Apartment[] apartments) {
        this.apartments = apartments;
    }

    public String[] returnResidentsName() {
        String[] residents = new String[0];
        int i = 0;
        for (Apartment apartment : apartments) {
            if (apartment.getResident() != null) {
                i++;
                residents = Arrays.copyOf(residents, i);
                residents[i - 1] = apartment.getResident().getName();
            }
        }
        return residents;
    }


    public String lookingResidentInApartment(int numberOfApartment) {
        String residentName = null;
        for (Apartment apartment : apartments)
            try {
                if (apartment.getNumber() == numberOfApartment) {
                    residentName = apartment.getResident().getName();
                    break;
                }
            } catch (NullPointerException e) {
                residentName = "В квартире никто не живет";
            }
        return residentName;
    }

    public Apartment[] sortsApartmentsBySquare(Apartment[] apartments) {
        if (apartments.length < 2) {
            return apartments;
        }
        for (int i = apartments.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (apartments[j].apartmentsSquare() < apartments[j + 1].apartmentsSquare()) {
                    Apartment apartment1 = apartments[j];
                    apartments[j] = apartments[j + 1];
                    apartments[j + 1] = apartment1;
                }
            }
        }
        return apartments;
    }

    public Resident[] sortResidentsByMoney(Resident[] residents) {
        if (residents.length < 2) {
            return residents;
        }
        for (int i = residents.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (residents[j].getMoney() < residents[j + 1].getMoney()) {
                    Resident resident = residents[j];
                    residents[j] = residents[j + 1];
                    residents[j + 1] = resident;
                }
            }
        }
        return residents;
    }

    public Resident[] moveInResidents(Resident[] residents) {
        Apartment[] sortingApartments = sortsApartmentsBySquare(apartments);
        Resident[] sortingResidents = sortResidentsByMoney(residents);
        int i = 0;
        for (Apartment apartment : sortingApartments) {
            if (apartment.getResident() == null) {
                if (i >= sortingResidents.length) {
                    break;
                }
                apartment.moveInResident(sortingResidents[i]);
                i++;
            }
        }

        return Arrays.copyOfRange(sortingResidents, i, sortingResidents.length);
    }

    public void addsApartment(Apartment apartment) {
        apartments = Arrays.copyOfRange(apartments, 0, apartments.length + 1);
        apartments[apartments.length - 1] = apartment;

    }

    public double priseOfApartment(double square) {
        return square * PRISE_PER_METER;
    }

    public double collectMoney() {
        double money = 0;
        for (Apartment apartment : apartments) {
            if (apartment.getResident() != null) {
                if (apartment.getResident().getMoney() < priseOfApartment(apartment.apartmentsSquare())) {
                    money += apartment.getResident().getMoney();
                    apartment.getResident().setMoney(apartment.getResident().getMoney());
                    apartment.moveOutResident();
                } else {
                    apartment.getResident().setMoney(priseOfApartment(apartment.apartmentsSquare()));
                    money += priseOfApartment(apartment.apartmentsSquare());
                }
            }
        }
        return money;
    }
}
