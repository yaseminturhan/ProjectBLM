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
public class ActionMovie extends Movie{
    
    private String actionType;
    private int movieNo;
    
    public ActionMovie( String actionType, int movieNo, String name, double price, int quantity, String r_date, int duration) { //constructor
        super(name, price, quantity, r_date, duration);
        this.actionType= actionType;
        this.movieNo = movieNo;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public int getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(int movieNo) {
        this.movieNo = movieNo;
    }
    
}
