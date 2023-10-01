package other.test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Program to demonstrate difference b/w equals and hashcode methods.
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return age == other.age && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Alice", 30);

        // equals() comparison
        System.out.println("person1.equals(person2): " + person1.equals(person2)); // false
        System.out.println("person1.equals(person3): " + person1.equals(person3)); // true

        // hashCode() comparison
        System.out.println("person1.hashCode(): " + person1.hashCode());
        System.out.println("person2.hashCode(): " + person2.hashCode());
        System.out.println("person3.hashCode(): " + person3.hashCode());

        // Storing in HashSet
        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);

        System.out.println("Size of personSet: " + personSet.size()); // Size will be 2 due to equality
    }
}

