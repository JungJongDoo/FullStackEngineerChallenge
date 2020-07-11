package com.paypay.manager.service;

import com.paypay.manager.entity.Review;
import com.paypay.manager.model.ReviewRequest;
import com.paypay.manager.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReview(Long employeeNo) {
        return this.reviewRepository.findByEmployeeNoOrderByRegisterYmdtDesc(employeeNo);
    }

    public Review registerReview(ReviewRequest reviewRequest) throws Exception {
        Review review = new Review();
        review.setEmployeeNo(reviewRequest.getEmployeeNo());
        review.setContents(reviewRequest.getContents());

        return this.reviewRepository.save(review);
    }

    public void deleteReview(Long no) throws Exception {
        this.reviewRepository.deleteById(no);
    }
}
