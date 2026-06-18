package com.example.demoDataMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collation = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String id;

    @Field
    private String title;

    @Field
    private String author;

    @Field
    private Double price;
}
