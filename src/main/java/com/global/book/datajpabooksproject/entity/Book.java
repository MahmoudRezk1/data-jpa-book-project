package com.global.book.datajpabooksproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.global.book.datajpabooksproject.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "books")
@NamedEntityGraph(name = "loadAuthor",attributeNodes = @NamedAttributeNode("author"))
public class Book extends BaseEntity<Long> {
    @NotNull
    private String name;
    @Min(value = 5)
    @Max(value = 500)
    private Double price;
    @Transient
    private Double discount;

    @Formula("(select count(*) from books)")
    private Long countBook;
    @NotNull
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    @PostLoad
    public void calcDiscount(){
        this.setDiscount(price*0.25);
    }

    public Long getCountBook() {
        return countBook;
    }

    public void setCountBook(Long countBook) {
        this.countBook = countBook;
    }


}
