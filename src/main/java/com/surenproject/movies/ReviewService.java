package com.surenproject.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService
{
    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;    //for custom queries without using repo
    public Review createReview(String reviewBody, String imdbId)
    {
        Review review = new Review(reviewBody);

        review = reviewRepo.insert(review);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds", review))
                .first();   //to ensure we get only movie and are updating that

        return review;
    }
}
