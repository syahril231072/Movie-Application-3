package com.example.android.movieadapter2.utils;

import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.Data.source.remote.response.TVShow;

import java.util.ArrayList;

public class FakeDataDummy1 {
    public static ArrayList<Movie> generateDummyCourses() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies = new ArrayList<>();
        movies.add(new Movie(82856, "The Mandalorian",
                "2019-11-12",
                "Set after the fall of the Empire and before the emergence of the First Order, we follow the travails of a lone gunfighter in the outer reaches of the galaxy far from the authority of the New Republic.",
                "/qdfARIhgpgZOBh3vfNhWS4hmSo3.jpg"));
        movies.add(new Movie(398978, "The Irishman",
                "2019-11-01",
                "Pennsylvania, 1956. Frank Sheeran, a war veteran of Irish origin who works as a truck driver, accidentally meets mobster Russell Bufalino. Once Frank becomes his trusted man, Bufalino sends him to Chicago with the task of helping Jimmy Hoffa, a powerful union leader related to organized crime, with whom Frank will maintain a close friendship for nearly twenty years.",
                "/mbm8k3GFhXS0ROd9AD1gqYbIFbM.jpg"));
        movies.add(new Movie(4743503, "The Mule",
                "December 14, 2018",
                "Earl Stone, a man in his 80s, is broke, alone, and facing foreclosure of his business when he is offered a job that simply requires him to drive. Easy enough, but, unbeknownst to Earl, he’s just signed on as a drug courier for a Mexican cartel. He does so well that his cargo increases exponentially, and Earl hit the radar of hard-charging DEA agent Colin Bates",
                "/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg"));




    return movies;
    }
    public static ArrayList<TVShow> generateRemoteDummyCourses() {

        ArrayList<TVShow> movies = new ArrayList<>();

        movies = new ArrayList<>();
        movies.add(new TVShow(82856, "The Mandalorian",
                "2019-11-12",
                "\"Set after the fall of the Empire and before the emergence of the First Order, we follow the travails of a lone gunfighter in the outer reaches of the galaxy far from the authority of the New Republic.",
                "/qdfARIhgpgZOBh3vfNhWS4hmSo3.jpg"));
        movies.add(new TVShow(398978, "The Irishman",
                "2019-11-01",
                "Pennsylvania, 1956. Frank Sheeran, a war veteran of Irish origin who works as a truck driver, accidentally meets mobster Russell Bufalino. Once Frank becomes his trusted man, Bufalino sends him to Chicago with the task of helping Jimmy Hoffa, a powerful union leader related to organized crime, with whom Frank will maintain a close friendship for nearly twenty years.",
                "/mbm8k3GFhXS0ROd9AD1gqYbIFbM.jpg"));
        movies.add(new TVShow(4743503, "The Mule",
                "December 14, 2018",
                "Earl Stone, a man in his 80s, is broke, alone, and facing foreclosure of his business when he is offered a job that simply requires him to drive. Easy enough, but, unbeknownst to Earl, he’s just signed on as a drug courier for a Mexican cartel. He does so well that his cargo increases exponentially, and Earl hit the radar of hard-charging DEA agent Colin Bates",
                "/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg"));
        return movies;
    }


}
