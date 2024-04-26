package com.rating.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rating.model.Rating;
import com.rating.service.RatingService;

import java.util.List;

//RatingController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class RatingController {

 private final RatingService ratingService;

 @Autowired
 public RatingController(RatingService ratingService) {
     this.ratingService = ratingService;
 }

 @PostMapping("/ratings")
 public ResponseEntity<String> addRating(@RequestBody Rating rating) {
     ratingService.addRating(rating);
     return ResponseEntity.status(HttpStatus.CREATED).body("Rating added successfully");
 }
 
 @GetMapping("/ratings")
 public ResponseEntity<List<Rating>> getRatings()
 {
     return ResponseEntity.ok(ratingService.getRatings());
 }
}
