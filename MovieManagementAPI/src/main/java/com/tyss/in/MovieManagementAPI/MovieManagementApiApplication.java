package com.tyss.in.MovieManagementAPI;

import com.tyss.in.MovieManagementAPI.DAO.MovieDao;
import com.tyss.in.MovieManagementAPI.Entity.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MovieManagementApiApplication {
    @Bean
    public CommandLineRunner commandLineRunner(MovieDao theMovieDao)
    {
        return runner-> {
            for (; ; ) {
                System.out.println("*** The Movie Api ***");
                System.out.println("1.To Add Movie");
                System.out.println("2.To Fetch Movie By Id");
                System.out.println("3.To FetchAll Movie");
                System.out.println("4.To Update Movie");
                System.out.println("5.To Remove Movie By Id");
                System.out.println("6.To Exit");
                System.out.println();

                try {
                System.out.println("Enter the option :-");
                Scanner sc=new Scanner(System.in);
                int op=sc.nextInt();
                switch (op)
                {
                    case 1:
                        System.out.println("Enter the no of Movie to Add :- ");
                        int n=sc.nextInt();
                        sc.nextLine();
                        for (int i=0;i<n;i++)
                        {

                               System.out.println("Enter The Movie Title :-");
                               String title=sc.nextLine();

                               System.out.println("Enter The Movie Director :-");
                               String director = sc.nextLine();

                               System.out.println("Enter The Movie ReleaseYear :-");
                               int releaseyear= sc.nextInt();
                               sc.nextLine();

                               System.out.println("Enter The Movie Genre :-");
                               String genre=sc.next();

                               System.out.println("Enter The Movie Rating :-");
                               double rating=sc.nextDouble();
                               theMovieDao.add(new Movie(title,director,releaseyear,genre,rating));
                               System.out.println("Movie Added Successfully!");




                        }
                        break;
                    case 2:
                        System.out.println("Enter the Id To fetch :- ");
                        Movie m = theMovieDao.fetchById(sc.nextInt());
                        System.out.println(m);
                        break;
                    case 3:
                        System.out.println("*** Movie List ***");
                        List<Movie>all= theMovieDao.fetchAll();
                        for (Movie movie :all)
                            System.out.println(all);
                        break;
                    case 4:
                        System.out.println("Enter the Id To Update :- ");
                        theMovieDao.updateById(sc.nextInt());
                        break;
                    case 5:
                        System.out.println("Enter the Id To Remove :- ");
                        theMovieDao.removeById(sc.nextInt());
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("You have Entered the Wrong Input !");


                }
                } catch (Exception e) {
                    System.out.println("Please Enter Valid input!");
                }
            }
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(MovieManagementApiApplication.class, args);
	}

}
