/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectblm;

import java.util.Arrays;
import java.util.List;


public class TestClass {
    
    public static void main(String[] args) {
        
        Person person = new Person("ali","test",999,100);
        Person customer = new Person("seyit","bey",99999,100);
        MovieStore movieStore = new MovieStore("store",person,100);
        
        Movie movie1 = new Movie("deneme",1,1);
        Movie movie2 = new Movie("denemee",11,11);
        Movie movie3 = new Movie("denemeee",111,111);
        Movie movie4 = new Movie("denemeeee",1111,1111);
        
        Movie[] moviel = new Movie[100];
        
        moviel[0] = movie1;
        moviel[1] = movie1;
        moviel[2] = movie1;
        moviel[3] = movie1;
        
        movieStore.addNewMovie(movie1);
        movieStore.addNewMovie(movie2);
        movieStore.addNewMovie(movie3);
        movieStore.addNewMovie(movie4);
        
        

        movieStore.rentMovieToPerson(customer,"deneme");
        movieStore.rentMovieToPerson(customer,"denemee");
        movieStore.rentMovieToPerson(customer,"denemeee");
        System.out.println("--------------------------");
        movieStore.printStoreMovies();
        System.out.println("--------------------------");
        movieStore.updateMovie("deneme", 312312, 31);
        System.out.println("--------------------------");


        System.out.println(person.getLastName());
        
        
        
        System.out.println("--------------------------");
        movieStore.returnMovieToStore(customer, "deneme");
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        
        //person.setRentHistory(moviel);
        customer.displayRentHistory();
        System.out.println("--------------------------"+movieStore.calculateStoreTotalBalance());
        
        
 
    }
}
