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
public class Movie {
 
    private String movieName;
    private double price;
    private int quantity;
    private String releaseDate;
    private int duration;
    
    public Movie(String name, double price, int quantity){ // Contructor
        this.movieName = name;
        this.price = price;
        this.quantity = quantity;
    }
    
     public Movie(String name, double price, int quantity, String r_date, int duration){ // Contructor
        this.movieName = name;
        this.price = price;
        this.quantity = quantity;
        this.releaseDate = r_date;
        this.duration = duration;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
     public void displayMovie(){
         
     }
     
}
