package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /*
       TODO:  1.	Find everyone that has firstName: “Erik” using findMany().
    */
    public static List<Person> exercise1(String message) {
        System.out.println(message);
        List<Person> eriks = storage.findMany(person -> person.getFirstName().equals("Erik"));

        System.out.println("----------------------");

        return eriks;
    }

    /*
        TODO:  2.	Find all females in the collection using findMany().
     */
    public static List<Person> exercise2(String message) {
        System.out.println(message);
        List<Person> females = storage.findMany(person -> person.getGender() == Gender.FEMALE);

        System.out.println("----------------------");

        return females;
    }

    /*
        TODO:  3.	Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static List<Person> exercise3(String message) {
        System.out.println(message);
        List<Person> bornAfter2000 = storage.findMany(person -> person.getBirthDate().isAfter(LocalDate.of(2000,1,1)));

        System.out.println("----------------------");
        return bornAfter2000;
    }

    /*
        TODO: 4.	Find the Person that has an id of 123 using findOne().
     */
    public static Person exercise4(String message) {
        System.out.println(message);
        Person personWithId123 = storage.findOne(person -> person.getId() == 123);

        System.out.println("----------------------");
        return personWithId123;

    }

    /*
        TODO:  5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static String exercise5(String message) {
        System.out.println(message);
        String personWithId455String = storage.findOneAndMapToString(
                person -> person.getId() == 455,
                person -> "Name: " + person.getFirstName() + " " + person.getLastName() + " born " + person.getBirthDate()
        );

        System.out.println("----------------------");
        return personWithId455String;
    }

    /*
        TODO:  6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static List<String> exercise6(String message) {
        System.out.println(message);
        List<String> malesWithNamesStartingWithE = storage.findManyAndMapEachToString(
                person -> person.getGender() == Gender.MALE && person.getFirstName().startsWith("E"),
                person -> person.getFirstName() + " " + person.getLastName()
        );

        System.out.println("----------------------");
        return malesWithNamesStartingWithE;
    }

    /*
        TODO:  7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static List<String> exercise7(String message) {
        System.out.println(message);
        List<String> peopleBelowAge10 = storage.findManyAndMapEachToString(
                person -> Period.between(person.getBirthDate(), LocalDate.now()).getYears() < 10,
                person -> person.getFirstName() + " " + person.getLastName() + " " +
                        (LocalDate.now().getYear() - person.getBirthDate().getYear()) + " years"
        );

        System.out.println("----------------------");
        return peopleBelowAge10;
    }

    /*
        TODO:  8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);
        storage.findAndDo(person -> person.getFirstName().equals("Ulf"), System.out::println);

        System.out.println("----------------------");
    }

    /*
        TODO:  9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println(message);
        storage.findAndDo(
                person -> person.getLastName().contains(person.getFirstName()),
                person -> System.out.println(person.getFirstName() + " " + person.getLastName())
        );

        System.out.println("----------------------");
    }

    /*
        TODO:  10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);
        storage.findAndDo(
                person -> isPalindrome(person.getFirstName()),
                person -> System.out.println(person.getFirstName() + " " + person.getLastName())

        );

        System.out.println("----------------------");
    }

    private static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        int length = cleanStr.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanStr.charAt(i) != cleanStr.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }


    /*
        TODO:  11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static List<Person> exercise11(String message) {
        System.out.println(message);
        List<Person> sortedPeopleWithFirstNameA = storage.findAndSort(
                person -> person.getFirstName().startsWith("A"),
                Comparator.comparing(Person::getBirthDate)
        );

        System.out.println("----------------------");
        return sortedPeopleWithFirstNameA;
    }

    /*
        TODO:  12.	Using findAndSort() find everyone born before 1950 sorted reversed by latest to earliest.
     */
    public static List<Person> exercise12(String message) {
        System.out.println(message);
        List<Person> sortedPeopleBornBefore1950 = storage.findAndSort(
                person -> person.getBirthDate().isBefore(LocalDate.of(1950,1,1)),
                Comparator.comparing(Person::getBirthDate).reversed()
        );

        System.out.println("----------------------");
        return sortedPeopleBornBefore1950;
    }

    /*
        TODO:  13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static List<Person> exercise13(String message) {
        System.out.println(message);
        List<Person> sortedPeople = storage.findAndSort(
                Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getFirstName)
                        .thenComparing(Person::getBirthDate)
        );

        System.out.println("----------------------");
        return sortedPeople;
    }
}
