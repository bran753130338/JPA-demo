package com.bran.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book_info")
public class BookInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_price")
    private Double bookPrice;

    @Column(name = "book_date")
    private Long bookDate;

    @Column(name = "book_publish")
    private String bookPublish;

    @Column(name = "book_desc")
    private String bookDesc;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BookType bookType; //多对一的关联，一定不要定义单个的type_id字段
}
