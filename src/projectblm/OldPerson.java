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
public class OldPerson extends Person{
    
    private final int rentLimit= 10;
    
    public OldPerson(String name, String surname, double balance, int rentLimit) {
        super(name, surname, balance, rentLimit);
    }
    
    public void showLimits(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "OldPerson{" + "rentLimit=" + rentLimit + '}';
    }
    
    
}
