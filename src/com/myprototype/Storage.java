/**
 * Java program to store cloned objects.
 */

package com.myprototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *  Storage of cloned objects
 */
public class Storage {

    static List<User> list = new ArrayList<>();

    // JVM entry point.
    public static void main(String[] args) throws CloneNotSupportedException {

        // Creating Handler to clone and store users.
        HandlerImpl handler = new HandlerImpl();

        // Creating Users objects.
        User user = new User(1, "Stive", "LB");
        User user1 = new User(2, "Jane", "ST");
        User user2 = new User(3, "Barbara", "MA");
        User user3 = new User(4, "Duke", "MU");

        // Cloning and saving copies of users to a list.
        handler.sendData(user);
        handler.sendData(user1);
        handler.sendData(user2);
        handler.sendData(user3);

        // Printing cloned users to console.
        System.out.println(list);

    }
}

/**
 *  User class.
 */
class User implements Cloneable {

    // Fields of User entity.
    int id;
    String name;
    String address;

    // Constructor of the class.
    public User(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Setters and getters for field of User.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Method to compare Users.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(address, user.address);
    }

    // Method to return hash code of User.
    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    // Method to represent User in readable format.
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Method to clone an User object.
    User copy() throws CloneNotSupportedException {
        return (User) this.clone();
    }
}

// Interface Handler to clone and store objects.
interface Handler extends Cloneable {

    void sendData(User user) throws CloneNotSupportedException;
    User clone(User user) throws CloneNotSupportedException;

}

// Class Handler to clone and store objects.
class HandlerImpl implements Handler {

    // Storage for cloned users.
    Storage storage = new Storage();

    // Method to store cloned User to class Storage.
    @Override
    public void sendData(User user) throws CloneNotSupportedException {

        // Calling method clone and saving user to Storage.
         storage.list.add(clone(user));

    }

    // Method to clone User.
    @Override
    public User clone(User user) throws CloneNotSupportedException {

        // Clonning user.
        User userCloned = user.copy();

        // Return statement.
        return userCloned;

    }
}