package com.surenproject.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data   //takes care of getters and setters
@AllArgsConstructor //lombok provides all args constructor
@NoArgsConstructor  //lombok provides no args constructor
public class Movie
{
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    //manual reference relationship using annotation
    @DocumentReference  //will make only ids of reviews to be stored inside movie collection in db and the reviews will be stored in separate collection
    private List<Review> reviews;

}
