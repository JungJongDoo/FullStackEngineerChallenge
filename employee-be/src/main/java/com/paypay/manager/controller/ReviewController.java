package com.paypay.manager.controller;

import com.paypay.manager.entity.Review;
import com.paypay.manager.model.ReviewRequest;
import com.paypay.manager.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{no}")
    @ApiOperation(value = "従業員レビュー照会", notes = "従業員のレビューを照会する。")
    public List<Review> list(@PathVariable(value = "no") Long employeeNo) {
        return reviewService.getAllReview(employeeNo);
    }

    @PostMapping
    @ApiOperation(value = "従業員レビュー登録", notes = "従業員のレビューを登録する。")
    public ResponseEntity<Review> create(@Validated @RequestBody ReviewRequest reviewRequest) throws Exception {
        return ResponseEntity.ok(reviewService.registerReview(reviewRequest));
    }

    @DeleteMapping("/{no}")
    @ApiOperation(value = "従業員レビュー削除", notes = "従業員レビューを削除する。")
    public ResponseEntity<?> delete(@PathVariable(value = "no") Long no) throws Exception {
        reviewService.deleteReview(no);
        return ResponseEntity.noContent().build();
    }

}
