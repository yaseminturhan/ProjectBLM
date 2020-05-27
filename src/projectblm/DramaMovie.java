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
public class DramaMovie extends Movie{
    
    private String dramaType;
    
    public DramaMovie(String dramaType, String name, double price, int quantity, String r_date, int duration) {
        super(name, price, quantity, r_date, duration);
        this.dramaType = dramaType;
    }

    public String getDramaType() {
        return dramaType;
    }

    public void setDramaType(String dramaType) {
        this.dramaType = dramaType;
    }
    
}
