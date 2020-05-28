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
    private Movie[] currentMovies = new Movie[rentLimit];
    
    public Person(String name, String surname, double balance, int rentLimit) {
        this.firstName = name;
        this.lastName = surname;
        this.balance = balance;
        this.rentLimit = rentLimit;
    }
    
    
    public void displayRentHistory(){
        
        System.out.println("Kiralanıp teslim edilen filmler");
        for(int i=0; i<rentHistory.length; i++){
            System.out.println(rentHistory[i].toString());
        }
        
    }
    
    public void displayRentHistory(String movieType){
        
        System.out.println(" Kiralanıp teslim edilen "+movieType+" filmleri");
        movieType+="Movie";
        for(int i=0; i<rentHistory.length; i++){
            if(rentHistory[i].getClass().getSimpleName().toLowerCase().contains(movieType.toLowerCase())){
                System.out.println(rentHistory[i].toString());
            }
        }
        
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
    
}
