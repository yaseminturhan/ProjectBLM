/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblm;

/**
 *
 * @author yaseminturhan
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private double balance;
    private int rentLimit;
    private Movie[] rentHistory = new Movie[100];
    
    public Person(String name, String surname, double balance, int rentLimit) {
        this.firstName = name;
        this.lastName = surname;
        this.balance = balance;
        this.rentLimit = rentLimit;
    }
    
    
    public void displayRentHistory(){
        
    }
    
    public void displayRentHistory(String movieType){
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getRentLimit() {
        return rentLimit;
    }


    public Movie[] getRentHistory() {
        return rentHistory;
    }

    public void setRentHistory(Movie[] rentHistory) {
        this.rentHistory = rentHistory;
    }

    public Movie[] getCurrentMovies() {
        return currentMovies;
    }

    public void setCurrentMovies(Movie[] currentMovies) {
        this.currentMovies = currentMovies;
    }
    private Movie[] currentMovies = new Movie[rentLimit];

   
    
}
