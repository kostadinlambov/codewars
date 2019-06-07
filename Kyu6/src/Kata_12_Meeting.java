import java.util.Arrays;

public class Kata_12_Meeting {
    public static void main(String[] args) {
//        testing("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn",
//                "(ARNO, ANN)(BELL, JOHN)(CORNWELL, ALEX)(DORNY, ABBA)(KERN, LEWIS)(KORN, ALEX)(META, GRACE)(SCHWARZ, VICTORIA)(STAN, MADISON)(STAN, MEGAN)(WAHL, ALEXIS)");
//        testing("John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell",
//                "(BELL, MEGAN)(CORNWELL, AMBER)(DORNY, JAMES)(DORRIES, PAUL)(GATES, JOHN)(KERN, ANN)(KORN, ANNA)(META, ALEX)(RUSSEL, ELIZABETH)(STEVE, LEWIS)(WAHL, MICHAEL)");
//        testing("Alex:Arno;Alissa:Cornwell;Sarah:Bell;Andrew:Dorries;Ann:Kern;Haley:Arno;Paul:Dorny;Madison:Kern",
//                "(ARNO, ALEX)(ARNO, HALEY)(BELL, SARAH)(CORNWELL, ALISSA)(DORNY, PAUL)(DORRIES, ANDREW)(KERN, ANN)(KERN, MADISON)");

//        System.out.println(meeting("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"));
//        System.out.println(meeting("John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell"));
//        System.out.println(meeting("Alex:Arno;Alissa:Cornwell;Sarah:Bell;Andrew:Dorries;Ann:Kern;Haley:Arno;Paul:Dorny;Madison:Kern"));
        System.out.println(meeting("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"));

    }

    public static String meeting(String s) {
        System.out.println(s);

        String[] names = s.split(";");

        Person[] persons = new Person[names.length];

        for (int i = 0; i < names.length; i++) {
            String[] tokens = names[i].split(":");
            String firstName = tokens[0];
            String lastName = tokens[1];
            Person person = new Person(firstName, lastName);

            persons[i] = person;
        }

        StringBuilder result = new StringBuilder();

        Object[] sortedArray = Arrays.stream(persons).sorted((x, y) -> {
            if (x.getLastName().compareTo(y.getLastName()) > 0) {
                return 1;
            } else if (x.getLastName().compareTo(y.getLastName()) < 0) {
                return -1;
            } else {
                if (x.getFirstName().compareTo(y.getFirstName()) > 0) {
                    return 1;
                } else if (x.getFirstName().compareTo(y.getFirstName()) < 0) {
                    return -1;
                }

                return 0;
            }
        }).toArray();

        for (int i = 0; i < sortedArray.length; i++) {
            Person person = (Person) sortedArray[i];
            result.append(String.format("(%s, %s)", person.getLastName().toUpperCase(), person.getFirstName().toUpperCase()));
        }

        return result.toString().trim();
    }
}

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
