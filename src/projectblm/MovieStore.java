/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private Movie[] rentedMovies;
    private Person[] customersList = new Person[200];

    public MovieStore(String name, Person owner, int rentLimit) {
        this.storeName = name;
        this.owner = owner;
        this.rentLimit = rentLimit;
        this.rentedMovies = new Movie[this.rentLimit];
    }

    public boolean rentMovieToPerson(Person person, String movieName) {

        boolean isRent = false;
        boolean isFind = false;

        for (int i = 0; i < filmCount; i++) {

            if (movieList[i].getMovieName().equals(movieName)) {
                isFind = true;
                if (movieList[i].getQuantity() > 0) {

                    if (person.getBalance() >= movieList[i].getPrice()) {

                        int personMovieCount = 0;
                        for (int j = 0; j < person.getCurrentMovies().length; j++) {
                            if (person.getCurrentMovies()[j] != null) {
                                personMovieCount++;
                            }
                        }

                        if (personMovieCount < person.getRentLimit()) {

                            int rentedMovieCount = 0;
                            for (int k = 0; k < rentedMovies.length; k++) {
                                if (rentedMovies[k] != null) {
                                    rentedMovieCount++;
                                }
                            }

                            if (rentedMovieCount < rentLimit) {
                                Movie[] pm = person.getCurrentMovies();

                                pm[0] = movieList[i];
                                person.setCurrentMovies(pm);

                                int customerCount = 0;
                                boolean isSameCustomer = false;
                                for (int m = 0; m < customersList.length; m++) {
                                    if (customersList[m] != null) {

                                        if (customersList[m].getFirstName().equals(person.getFirstName())) {
                                            customersList[m] = person;
                                            isSameCustomer = true;
                                            break;

                                        }
                                        customerCount++;
                                    }
                                }

                                if (!isSameCustomer) {
                                    customersList[customerCount] = person;
                                }

                                movieList[i].setQuantity(movieList[i].getQuantity() - 1);

                                rentedMovies[rentedMovieCount] = movieList[i];
                                person.setBalance(person.getBalance() - movieList[i].getPrice());
                                income += movieList[i].getPrice();
                                isRent = true;
                                System.out.println("Film başarı ile kiralanmıştır!");

                                break;

                            } else {
                                System.out.println("Mağazanın film kiralama limiti dolmuştur!");
                                isRent = false;
                                break;
                            }

                        } else {
                            System.out.println("Film kiralama limitiniz dolmuştur!");
                            isRent = false;
                            break;
                        }

                    } else {
                        System.out.println("Bu film için bakiyeniz yeterli değil!");
                        isRent = false;
                        break;
                    }
                } else {
                    System.out.println("Film mağazada var ama başka müşterilere kiralanmış durumda!");
                    isRent = false;
                    break;
                }
            }
        }

        if (!isFind) {
            System.out.println("Film mağazada yok!");
            isRent = false;
        }
        return isRent;
    }

    public boolean returnMovieToStore(Person person, String movieName) {

        boolean state = false;
        for (int i = 0; i < rentLimit; i++) {
            if (rentedMovies[i] != null && movieName.equals(rentedMovies[i].getMovieName())) {

                int historyCount = 0;
                for (int j = 0; j < person.getRentHistory().length; j++) {
                    if (person.getRentHistory()[j] != null) {
                        historyCount++;
                    }
                }

                Movie[] pm = person.getRentHistory();
                pm[historyCount] = rentedMovies[i];
                person.setRentHistory(pm);
                person.getRentHistory()[historyCount] = rentedMovies[i];

                int movieIndex = Arrays.asList(movieList).indexOf(rentedMovies[i]);
                movieList[movieIndex].setQuantity(movieList[movieIndex].getQuantity() + 1);

                List<Movie> tempList = new ArrayList<>(Arrays.asList(rentedMovies));

                List<Movie> tempListPerson = new ArrayList<>(Arrays.asList(person.getCurrentMovies()));
                tempListPerson.remove(rentedMovies[i]);
                tempList.remove(i);
                rentedMovies = tempList.toArray(rentedMovies);
                person.setCurrentMovies(tempListPerson.toArray(person.getCurrentMovies()));

                state = true;
                break;
            }
        }

        if (state) {
            System.out.println("Film iadesi başarılı bir şekilde gerçekleşti!");
            return true;

        } else {
            System.out.println("Film mağazada yok, yanlış mağaza!");
            return false;
        }

    }

    public double calculateStoreTotalBalance() {
        return income;
    }

    public void printCurrentRentedMovies() {
        System.out.println("Güncel kiralanan filmler :");
        for (int i = 0; i < rentLimit; i++) {
            if (rentedMovies[i] != null) {
                System.out.println(rentedMovies[i].toString());
            }
        }
    }

    public void printCurrentRentedMovies(String firstName, String lastName) {
        for (int i = 0; i < customersList.length; i++) {

            if (customersList[i] != null && customersList[i].getFirstName().equals(firstName) && customersList[i].getLastName().equals(lastName)) {
                System.out.println(firstName + " " + lastName + " isimli kullanıcının filmleri :");
                for (int j = 0; j < customersList[i].getCurrentMovies().length; j++) {
                    if (customersList[i].getCurrentMovies()[i] != null) {
                        System.out.println(customersList[i].getCurrentMovies()[i].toString());
                    }

                }
                break;
            }
        }
    }

    public void printStoreMovies() {

        System.out.println("Mağazadaki bütün filmler :");
        for (int i = 0; i < filmCount; i++) {
            if (movieList[i] != null) {
                System.out.println(movieList[i].toString());
            }

        }
    }

    public void printMovie(String movieName) {

        boolean isFind = false;
        for (int i = 0; i < filmCount; i++) {
            if (movieList[i] != null && movieList[i].getMovieName().equals(movieName)) {
                System.out.println(movieName + " filmi özellikleri :");
                System.out.println(movieList[i].toString());
                isFind = true;
                break;
            }
        }
        if (!isFind) {
            System.out.println(movieName + " isimli bir film bulunamadı!");
        }
    }

    public boolean addNewMovie(Movie movie) {

        if (filmCount == 100) {
            System.out.println("Bu mağazaya daha fazla film eklenemez!");
            return false;
        } else {
            for (int i = 0; i < filmCount; i++) {
                if (movieList[i] != null) {
                    if (movieList[i].getMovieName().equals(movie.getMovieName())) {
                        movieList[i].setQuantity(movieList[i].getQuantity() + movie.getQuantity());
                        System.out.println("Film adedi güncellendi!");
                        return true;
                    }
                }
            }
            movieList[filmCount] = movie;
            filmCount++;
            System.out.println("İstenilen film mağazaya eklendi!");
            return true;
        }
    }

    public boolean updateMovie(String movieName, double newPrice, int newQuantity) {
        boolean state = false;
        for (int i = 0; i < filmCount; i++) {
            if (movieList[i] != null && movieList[i].getMovieName().equals(movieName)) {
                movieList[i].setPrice(newPrice);
                movieList[i].setQuantity(newQuantity);
                System.out.println("Film özellikleri başarıyla güncellendi!");
                state = true;
                break;
            }
        }

        if (state == false) {
            System.out.println("Güncellenmek istenen film ismi mağazada bulunamadı!");
        }
        return state;
    }

    public void deleteMovie(String movieName) {

        boolean isRent = false;
        boolean isFind = false;
        for (int i = 0; i < customersList.length; i++) {
            if (customersList[i] != null) {
                for (int j = 0; j < customersList[i].getCurrentMovies().length; j++) {
                    if (customersList[i].getCurrentMovies()[i] != null) {
                        if (customersList[i].getCurrentMovies()[j]!=null && customersList[i].getCurrentMovies()[j].getMovieName().equals(movieName)) {
                            System.out.println("Silinmek istenen film müşteri tarafından kiralanmış durumda!");
                            isRent = true;
                            break;
                        }
                    }
                }
            }
            if (isRent) {
                break;
            }
        }
        if (!isRent) {
            for (int i = 0; i < filmCount; i++) {
                if (movieList[i] != null && movieList[i].getMovieName().equals(movieName)) {
                    List<Movie> tempList = new ArrayList<>(Arrays.asList(movieList));
                    tempList.remove(i);
                    movieList = tempList.toArray(movieList);
                    filmCount--;
                    System.out.println("Film başarıyla silindi.");
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                System.out.println("Silinmek istenen film ismi mağazada bulunamadı!");
            }
        }

    }

}
