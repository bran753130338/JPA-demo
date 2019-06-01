package com.bran.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "book_type")
public class BookType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "type_name")
    private String typrName;

    @Column(name = "type_desc")
    private String typeDesc;

    //一对多，采用集合形式
    @OneToMany(mappedBy = "bookType") //关联对象定义的变量
    private Set<BookInfo> bookInfos = new HashSet<>();

}
