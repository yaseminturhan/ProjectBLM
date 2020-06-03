/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblm;

import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        System.out.println("Film dükkanına hoşgeldiniz!");
        System.out.println("---------------------------\n\n");
        
        Person owner = new Person("Company", "Owner", 999, 100);
        MovieStore movieStore = new MovieStore("MovieStore", owner, 10);

        HorrorMovie horrorMovie = new HorrorMovie(18, "horrorr", 15, 6, "5 rate", 120);
        DramaMovie dramaMovie = new DramaMovie("drama type", "dramaa", 10, 3, "4 rate", 100);
        ActionMovie actionMovie = new ActionMovie("action type", 1, "actionn", 20, 4, "7 rate", 120);
        
        movieStore.addNewMovie(horrorMovie);
        movieStore.addNewMovie(dramaMovie);
        movieStore.addNewMovie(actionMovie);

        YoungPerson customer1 = new YoungPerson("Fahri", "Gündüz", 120, 3);
        YoungPerson customer2 = new YoungPerson("Mert", "Koyun", 110, 10);
        YoungPerson customer3 = new YoungPerson("Pınar", "Şahin", 200, 5);
        OldPerson customer4 = new OldPerson("Himmet", "Akpınar", 300, 4);
        OldPerson customer5 = new OldPerson("Sanem", "Necati", 220, 6);
        OldPerson customer6 = new OldPerson("Gül", "Tutucu", 100, 2);

        movieStore.rentMovieToPerson(customer6, "horrorr");
        movieStore.rentMovieToPerson(customer6, "dramaa");
        movieStore.rentMovieToPerson(customer6, "actionn");
        movieStore.rentMovieToPerson(customer6, "horrorr");
        movieStore.rentMovieToPerson(customer6, "dramaa");

        customer6.displayRentHistory();
  
        movieStore.returnMovieToStore(customer6, "actionn");
        movieStore.returnMovieToStore(customer6, "horrorr");
        movieStore.returnMovieToStore(customer6, "horrorrs");
        
        customer6.displayRentHistory();
        customer6.displayRentHistory("Action");
        customer6.displayRentHistory("Drama");
        
        movieStore.rentMovieToPerson(customer6, "actionn");
        movieStore.rentMovieToPerson(customer6, "horrorr");
        movieStore.rentMovieToPerson(customer6, "dramaas");

        Scanner scanner = new Scanner(System.in);        

        while (true) {
            System.out.println("\f");
            menu();
            int choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Film türünü seçiniz");
                    System.out.println("1- Action");
                    System.out.println("2- Horror");
                    System.out.println("3- Drama");
                    String filmName = "";
                    double filmPrice = 0;
                    int filmQuantity = 0;
                    String rDate = "";
                    int filmDuration = 0;
                    int movieType = scanner.nextInt();
                    switch (movieType) {
                        case 1:
                            System.out.println("Aksiyon Türü");
                            String actionType = scanner.next();
                            System.out.println("Seri Sayısı");
                            int serialNo = scanner.nextInt();
                            System.out.println("Film Adı");
                            filmName = scanner.next();
                            System.out.println("Film Fiyatı");
                            filmPrice = scanner.nextDouble();
                            System.out.println("Film Adedi");
                            filmQuantity = scanner.nextInt();
                            System.out.println("Film Puanı");
                            rDate = scanner.next();
                            System.out.println("Film Süresi");
                            filmDuration = scanner.nextInt();
                            ActionMovie actionMov = new ActionMovie(actionType, serialNo, filmName, filmPrice, filmQuantity, rDate, filmDuration);
                            movieStore.addNewMovie(actionMov);
                            break;

                        case 2:
                            System.out.println("Yaş sınırı");
                            int ageLimit = scanner.nextInt();
                            System.out.println("Film Adı");
                            filmName = scanner.next();
                            System.out.println("Film Fiyatı");
                            filmPrice = scanner.nextDouble();
                            System.out.println("Film Adedi");
                            filmQuantity = scanner.nextInt();
                            System.out.println("Film Puanı");
                            rDate = scanner.next();
                            System.out.println("Film Süresi");
                            filmDuration = scanner.nextInt();
                            HorrorMovie horrorMov = new HorrorMovie(ageLimit, filmName, filmPrice, filmQuantity, rDate, filmDuration);
                            movieStore.addNewMovie(horrorMov);
                            break;
                        case 3:
                            System.out.println("Drama Türü");
                            String dramaType = scanner.next();
                            System.out.println("Film Adı");
                            filmName = scanner.next();
                            System.out.println("Film Fiyatı");
                            filmPrice = scanner.nextDouble();
                            System.out.println("Film Adedi");
                            filmQuantity = scanner.nextInt();
                            System.out.println("Film Puanı");
                            rDate = scanner.next();
                            System.out.println("Film Süresi");
                            filmDuration = scanner.nextInt();
                            DramaMovie dramaMov = new DramaMovie(dramaType, filmName, filmPrice, filmQuantity, rDate, filmDuration);
                            movieStore.addNewMovie(dramaMov);
                            break;
                    }

                    break;

                case 2:
                    System.out.println("Düzenlenecek filmin adı");
                    String updateMovieName = scanner.next();
                    System.out.println("Yeni fiyat");
                    double newPrice = scanner.nextDouble();
                    System.out.println("Yeni adet");
                    int newQuantity = scanner.nextInt();
                    movieStore.updateMovie(updateMovieName, newPrice, newQuantity);
                    break;
                case 3:
                    System.out.println("Silinecek filmin adı");
                    String deleteMovieName = scanner.next();
                    movieStore.deleteMovie(deleteMovieName);
                    break;
                case 4:
                    System.out.println("Toplam kazanç : " + movieStore.calculateStoreTotalBalance());
                    break;
                case 5:
                    movieStore.printCurrentRentedMovies();
                    break;
                case 6:
                    System.out.println("Müşteri adı");
                    String custName = scanner.next();
                    System.out.println("Müşteri soyadı");
                    String custLastame = scanner.next();
                    movieStore.printCurrentRentedMovies(custName, custLastame);
                    break;
                case 7:
                    movieStore.printStoreMovies();
                    break;
                case 8:
                    System.out.println("Film Adı");
                    filmName = scanner.next();
                    movieStore.printMovie(filmName);
                    break;
                case 0:
                    return;

            }

        }
    }

    public static void menu() {
        System.out.println("Lütfen yapmak istediğiniz işlemi aşağıdan belirtiniz.\n");
        System.out.println("-----------------------------------------\n");
        System.out.println("1- Film Ekle");
        System.out.println("2- Film Düzenle");
        System.out.println("3- Film Sil");
        System.out.println("4- Kazancı Hesapla");
        System.out.println("5- Kiralanan Filmleri Göster");
        System.out.println("6- Müşterinin Kiraladığı Filmleri Göster");
        System.out.println("7- Mağazadaki Filmleri Göster");
        System.out.println("8- Film Göster");
        System.out.println("0- Çıkış");
    }

}
