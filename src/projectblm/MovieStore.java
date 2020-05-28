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
    private int filmCount = 0;
    private Person owner;
    private int rentLimit;
    private double income = 0.0;
    private Movie[] movieList = new Movie[100];
    private Movie[] rentedMovies = new Movie[rentLimit];
    private Person[] customersList = new Person[200];

    public MovieStore(String name, Person owner, int rentLimit) {
        this.storeName = name;
        this.owner = owner;
        this.rentLimit = rentLimit;
    }
    
    public boolean rentMovieToPerson(Person person, String movieName){
        
        boolean isRent = false; 
        
        for(int i=0; i<movieList.length; i++){
            
            if(movieList[i].getMovieName().equals(movieName)){
                
                if(movieList[i].getQuantity()>0){
                    
                    if(person.getBalance()>=movieList[i].getPrice()){
                        
                        if(person.getCurrentMovies().length < person.getRentLimit()){
                            
                            if(rentedMovies.length < rentLimit){
                                person.getCurrentMovies()[person.getCurrentMovies().length-1] = movieList[i];
                                movieList[i].setQuantity(movieList[i].getQuantity()-1);
                                rentedMovies[rentedMovies.length-1] = movieList[i];
                                isRent = true;
                            }else{
                                System.out.println("Mağazanın film kiralama limiti dolmuştur!");
                                isRent = false;
                            }
                            
                        }else{
                            System.out.println("Film kiralama limitiniz dolmuştur!");
                            isRent = false;
                        }
                        
                    }else{
                        System.out.println("Bu film için bakiyeniz yeterli değil!");
                        isRent = false;
                    }
                }else{
                    System.out.println("Film mağazada var ama başka müşterilere kiralanmış durumda!");
                    isRent = false;
                }            
            }else{
                System.out.println("Film mağazada yok!");
                isRent = false;
            }
        }
        return isRent;
    } 
    
     public boolean returnMovieToStore(Person person, String movieName){
         
         for(int i=0; i<rentedMovies.length; i++){
             
         }
         
       return false;
        
    } 
    
     public double calculateStoreTotalBalance(){
         for(int i=0; i<rentedMovies.length; i++){
             income += rentedMovies[i].getPrice();
         }
          return income;
     }
     
     public void printCurrentRentedMovies(){
         System.out.println("Güncel kiralanan filmler :");
         for(int i=0; i<rentedMovies.length; i++){
             System.out.println(rentedMovies[i].toString());
         }     
     }
     
     public void printCurrentRentedMovies(String firstName, String lastName){
         for(int i=0; i<customersList.length; i++){
             
             if(customersList[i].getFirstName().equals(firstName) && customersList[i].getLastName().equals(lastName)){
                 System.out.println(firstName+" "+lastName+" isimli kullanıcının filmleri :");
                 for(int j=0; j<customersList[i].getCurrentMovies().length; j++){
                     System.out.println(customersList[i].getCurrentMovies()[i].toString());
                 }
                 break;
             }  
         }
     }
     
     public void printStoreMovies(){
         
         System.out.println("Mağazadaki bütün filmler :");
         for(int i=0; i<movieList.length; i++){
             System.out.println(movieList[i].toString());
         }
     }
     
     public void printMovie(String movieName){
         
         for(int i=0; i<movieList.length; i++){  
             if(movieList[i].getMovieName().equals(movieName)){
                 System.out.println(movieName+" filmi özellikleri :");
                 System.out.println(movieList[i].toString());
                 break;
             }
         }
     }
     
     public boolean addnewMovie(Movie movie){
         
         for(int i=0; i<movieList.length; i++){
             if(movieList[i].getMovieName().equals(movie.getMovieName())){
                 movie.setQuantity(movie.getQuantity()+1);
                 filmCount++;
                 System.out.println("Film adedi güncellendi!”");
                 return true;
             }
         }
         
         if(movieList.length<100){
             movieList[movieList.length-1] = movie;
             System.out.println("İstenilen film mağazaya eklendi!");
             return true;
         }else{
             System.out.println("Bu mağazaya daha fazla film eklenemez!");
             return false;
         }
    }
     
    public boolean updateMovie(String movieName, double newPrice, double newQuantity){
        
        return false;
    }
    
    public void deleteMovie(String movieName){
        
        boolean isRent = false;
        boolean isFind = false;
        for(int i=0; i<customersList.length; i++){
            
            for(int j=0; j<customersList[i].getCurrentMovies().length; j++){
                if(customersList[i].getCurrentMovies()[j].getMovieName().equals(movieName)){
                    System.out.println("Silinmek istenen film müşteri tarafından kiralanmış durumda!");
                    isRent = true;
                    break;
                }
            }
            
            if(isRent){
                break;
            }
        }
        
        if(!isRent){
            for(int i=0; i<movieList.length; i++){
                if(movieList[i]!=null &&movieList[i].getMovieName().equals(movieName)){
                    movieList[i]= null;
                    System.out.println("Film başarıyla silindi.");
                    isFind = true;
                    break;
                }
            }
            if(!isFind){
                System.out.println("Silinmek istenen film ismi mağazada bulunamadı!");
            }
        }
    } 
     
}
