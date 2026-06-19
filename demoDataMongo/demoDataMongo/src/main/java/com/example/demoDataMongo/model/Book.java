package com.example.demoDataMongo.model;

import com.example.demoDataMongo.validations.ValidTitle;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String id;


    @ValidTitle(message = "Title can not be blank or empty or null. And it must be between 10 and 20 characters")
    @Field
    private String title;

    @Field
    private String author;

    @Min(value = 20, message = "Book price can not be less than $20")
    @Max(value = 100, message = "Book price can not be over $100" )
    @Field
    private Double price;
}
