package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("posts")
public class Post {
    @Id
    private String postId;
    private String post;
    private String postedBy;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private boolean isActive;
}
