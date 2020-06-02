/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectblm;

import java.util.Scanner;


public class Test {
    
    public static void main(String[] args) {
        Person owner = new Person("Seyit Ali","Yaman",999,100);
        MovieStore movieStore = new MovieStore("MovieStore",owner,10);
        
        HorrorMovie horrorMovie = new HorrorMovie(18,"horror movie1",15,5,"5 rate",120);
        DramaMovie dramaMovie = new DramaMovie("drama type","drama movie1",10,3,"4 rate",100);
        ActionMovie actionMovie = new ActionMovie("action type",1,"action movie1",20,4,"7 rate",120);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Film dükkanına hoşgeldiniz!");
        
        while(true){
            
            
        }
    }
    
    public static void menu(){
        System.out.println("");
    }

}
