package task06;

import java.util.*;

class AddressBook implements Iterable{
    private NameAddressPair [] addressBook;
    private int counter = 0;


    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }
    public boolean create (String firstName, String lastName, String address) {
        NameAddressPair addressPair = new NameAddressPair(
                new AddressBook.NameAddressPair.Person(firstName, lastName),address);

        for (int i = 0; i<this.counter;i++) {
            if (this.addressBook[i].person.equals(addressPair.person))
                return false;
        }
        if(!(counter<addressBook.length)) {
            AddressBook newAddressBook = new AddressBook(this.addressBook.length*2);
            for (int i = 0; i<addressBook.length; i++)
                newAddressBook.addressBook[i] =this.addressBook[i];
            this.addressBook = newAddressBook.addressBook;

        }
        addressBook[counter] = addressPair;
        counter++;
        return true;
    }

    public String read(String firstName, String lastName) {
        NameAddressPair addressPair = new NameAddressPair(
                new AddressBook.NameAddressPair.Person(firstName, lastName),"");
        for (int i= 0; i<this.counter; i++) {
            if(this.addressBook[i].person.equals(addressPair.person))
                return addressBook[i].address;

        }
        return null;

    }
    public boolean update (String firstName, String lastName, String address) {
        NameAddressPair addressPair = new NameAddressPair(
                new AddressBook.NameAddressPair.Person(firstName, lastName),address);

        for (int i= 0; i<this.counter; i++) {
            if(this.addressBook[i].person.equals(addressPair.person)) {
                this.addressBook[i].address = address;
                return true;
            }

        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        NameAddressPair addressPair = new NameAddressPair(
                new AddressBook.NameAddressPair.Person(firstName, lastName),"");

        for (int i= 0; i<this.counter; i++) {
            if(this.addressBook[i].person.equals(addressPair.person)) {
                this.addressBook[i]=null;
                this.counter--;
                AddressBook newAB = new AddressBook(counter);
                for (int j = 0, it =0; j < this.addressBook.length; j++) {
                    if (this.addressBook[j]!=null) {
                        newAB.addressBook[it] = this.addressBook[j];
                        it++;
                    }
                }
                this.addressBook = newAB.addressBook;
                return true;
            }


        }
        return false;
    }

    public int size() {
        return counter;
    }
    public void sortedBy(SortOrder order) {
        if(order==SortOrder.ASC) {
            Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
                @Override
                public int compare(NameAddressPair o1, NameAddressPair o2) {
                    if (o1.person.firstName.compareTo(o2.person.firstName) !=0)
                        return o1.person.firstName.compareTo(o2.person.firstName);
                    else
                        return o1.person.lastName.compareTo(o2.person.lastName);
                }
            });
        }
        if (order==SortOrder.DESC) {
            Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
                @Override
                public int compare(NameAddressPair o1, NameAddressPair o2) {
                    if (o1.person.firstName.compareTo(o2.person.firstName) !=0)
                        return -o1.person.firstName.compareTo(o2.person.firstName);
                    else
                        return -o1.person.lastName.compareTo(o2.person.lastName);
                }
            });
        }

    }

    @Override
    public Iterator iterator() {
        return new AddressBookIterator();
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;
        private NameAddressPair (Person person, String address) {
            this.person = new Person(person.firstName, person.lastName);
            this.address = address;
        }



         private static class Person {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person)) return false;
                Person person = (Person) o;
                return this.firstName.equals(person.firstName) &&
                        this.lastName.equals(person.lastName);
            }

        }
    }
    private class AddressBookIterator implements Iterator {
        private int counter = 0;
        @Override
        public boolean hasNext() {
            if (counter<size())
                return true;
            return false;
        }

        @Override
        public String next() {
            while (hasNext()) {
                counter++;
                return String.format("First name: %s, Last name: %s, Address: %s",
                        addressBook[counter-1].person.firstName,
                        addressBook[counter-1].person.lastName,
                        addressBook[counter-1].address);

            }
            return "";
        }
    }


}

enum SortOrder {
    ASC,DESC
}



public class Main {

  public static void main(String[] args) {

 String[] expected = {"First name: Karen, Last name: Davis, Address: Address #2",
         "First name: Steven, Last name: Taylor, Address: Address #3",
         "First name: Susan, Last name: Brown, Address: Address #4"};
 String[] actual = new String[3];
 AddressBook addressBook = new AddressBook(4);
 addressBook.create("John", "Brown", "Address #1");
 addressBook.create("Karen", "Davis", "Address #2");
 addressBook.create("Steven", "Taylor", "Address #1");
 addressBook.create("Susan", "Brown", "Address #4");
 addressBook.update("Steven", "Taylor", "Address #3");
 addressBook.delete("John", "Brown");
 int counter = 0;
 for (Object record : addressBook)
     actual[counter++] = record.toString();


      System.out.println(Arrays.toString(expected));
      System.out.println(Arrays.toString(actual));






  }


}
