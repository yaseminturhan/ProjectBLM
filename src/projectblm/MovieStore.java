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
public class MovieStore {
    
    private String storeName;
    private int filmCount;
    private Person owner;
    private int rentLimit;
    private double income;
    private  Movie[] movieList = new Movie[100];
    private Movie[] rentedMovies = new Movie[rentLimit];
    private Person[] customersList = new Person[200];

    public MovieStore(String name, Person owner, int rentLimit) {
        this.storeName = name;
        this.owner = owner;
        this.rentLimit = rentLimit;
    }
    
    public static boolean rentMovieToPerson(Person [] customersList, String movieName){
        
       return false;
        
    } 
    
     public static boolean returnMovieToStore(Person [] customersList, String movieName){
        
       return false;
        
    } 
    
     public static double calculateStoreTotalBalance(){
          return 1;
     }
     
     public void printCurrentRentedMovies(){
         
     }
     
     public void printCurrentRentedMovies(String firstName, String lastName){
         
     }
     
     public void printStoreMovies(){
         
     }
     
     public void printMovie(String movieName){
         
     }
     
     public static boolean addnewMovie(Movie movie){
        
       return false;
        
    } 
     
     
}
