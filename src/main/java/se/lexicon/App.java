package se.lexicon;

import java.util.List;
import java.util.Scanner;

import se.lexicon.model.Person;

import static se.lexicon.Exercises.*;



public class App {

    private static final Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    public static void displayPeople(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public static void displayPerson(Person person) {
        if (person !=null) {
            System.out.println(person.toString());
        } else {
            System.out.println("Person not found");
        }
    }

    public static void displayString(String str) {
        System.out.println(str);
    }

    public static void displayStrings(List<String> strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        boolean done = false;
        String message = "Running exercise...";
        do {
            System.out.println(menu());
            System.out.print("Choose from 1-13: ");
            int number = getInt();
            switch (number) {
                case 0:
                    done = true;
                    break;
                case 1:
                    List<Person> eriks = exercise1(message + number);
                    displayPeople(eriks);
                    break;
                case 2:
                    List<Person> females = exercise2(message + number);
                    displayPeople(females);
                    break;
                case 3:
                    List<Person> bornAfter2000 = exercise3(message + number);
                    displayPeople(bornAfter2000);
                    break;
                case 4:
                    Person personWithId123 = exercise4(message + number);
                    displayPerson(personWithId123);
                    break;
                case 5:
                    String personWithId455String = exercise5(message + number);
                    displayString(personWithId455String);
                    break;
                case 6:
                    List<String> malesWithNamesStartingWithE = exercise6(message + number);
                    displayStrings(malesWithNamesStartingWithE);
                    break;
                case 7:
                    List<String> peopleBelowAge10 = exercise7(message + number);
                    displayStrings(peopleBelowAge10);
                    break;
                case 8:
                    exercise8(message + number);
                    break;
                case 9:
                    exercise9(message + number);
                    break;
                case 10:
                    exercise10(message + number);
                    break;
                case 11:
                    List<Person> sortedPeopleWithFirstNameA = exercise11(message + number);
                    displayPeople(sortedPeopleWithFirstNameA);
                    break;
                case 12:
                    List<Person> sortedPeopleBornBefore1950 = exercise12(message + number);
                    displayPeople(sortedPeopleBornBefore1950);
                    break;
                case 13:
                    List<Person> sortedPeople = exercise13(message + number);
                    displayPeople(sortedPeople);
                    break;
            }


        } while (!done);
        SCANNER.close();
    }


    public static String menu() {
        StringBuilder stringBuilder = new StringBuilder("Please make a choice: \n");
        stringBuilder.append("0.\tQuit\n");
        stringBuilder.append("1.\tFind everyone that has firstName: “Erik” using findMany().\n");
        stringBuilder.append("2.\tFind all females in the collection using findMany().\n");
        stringBuilder.append("3.\tFind all who are born after (and including) 2000-01-01 using findMany().\n");
        stringBuilder.append("4.\tFind the Person that has an id of 123 using findOne().\n");
        stringBuilder.append("5.\tFind the Person that has an id of 455 and convert to String with following content:\n" +
                "            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().\n");
        stringBuilder.append("6.\tFind all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().\n");
        stringBuilder.append("7.\tFind all people who are below age of 10 and convert them to a String like this:\n" +
                "            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.\n");
        stringBuilder.append("8.\tUsing findAndDo() print out all people with firstName “Ulf”.\n");
        stringBuilder.append("9.\tUsing findAndDo() print out everyone who have their lastName contain their firstName.\n");
        stringBuilder.append("10.\tUsing findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.\n");
        stringBuilder.append("11.\tUsing findAndSort() find everyone whose firstName starts with A sorted by birthDate.\n");
        stringBuilder.append("12.\tUsing findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.\n");
        stringBuilder.append("13.\tUsing findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.\n");
        return stringBuilder.toString();
    }

    public static int getInt() {
        int number = 0;
        boolean validNumber = false;
        while (!validNumber) {
            try {
                number = Integer.parseInt(SCANNER.nextLine().trim());
                validNumber = number >= 0 && number < 14;
            } catch (NumberFormatException ex) {
                System.out.println("Not a integer");
            }
            if (!validNumber) {
                System.out.println("Try again");
            }
        }

        return number;
    }
}
