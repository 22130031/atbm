package com.banthatlung.services;

import com.banthatlung.Dao.ReviewDao;
import com.banthatlung.Dao.model.Review;

import java.sql.SQLException;
import java.util.List;

public class ReviewService {
    static ReviewDao reviewDao = new ReviewDao();
    // Add a review
    public void addReview(Review review) {
        reviewDao.addReview(review);
    }

    // Get reviews for a specific product
    public List<Review> getReviewsByProductId(String productId) {
        return reviewDao.getReviewsByProductId(productId);
    }
    public List<Review> getReviewsByRating(String pid,String rating) {
        return reviewDao.getReviewsByRating(pid,rating);
    }
    public List<Review> getReviewsByImg(String pid) {
        return reviewDao.getReviewsByImg(pid);
    }
    public List<Review> getReviewsByComment(String pid) {
        return reviewDao.getReviewsByComment(pid);
    }
}
