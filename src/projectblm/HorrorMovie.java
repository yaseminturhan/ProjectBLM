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
public class HorrorMovie extends Movie{
    
    private int ageLimit;
    
    public HorrorMovie(int ageLimit, String name, double price, int quantity, String r_date, int duration) { //constructor
        super(name, price, quantity, r_date, duration);
        this.ageLimit = ageLimit;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }
    
    
}
