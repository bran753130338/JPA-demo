package com.bran.domain;

import lombok.Data;

import javax.persistence.*;

/*
* @Entity   标注用于实体类声明语句之前，指出该Java类为实体类，将映射到指定的数据库表
*
* @Table    映射表格
*   |-常和@Entity配合使用
*   |-name可选，表示表的名称，默认表名和实体名一致
*
* @Id   映射生成主键，通常置于属性声明语句之前，也可置于属性的getter方法之前
*   |-必须，定义了映射到数据库表的主键属性
*
* @GeneratedValue  用于标注主键的生成策略，通过strategy属性指定@GeneratedValue(strategy = GenerationType.AUTO)
*   |-IDENTITY    采用数据库ID自增长的方式来自增主键字段
*   |-SEQUENCE    通过序列产生主键
*   |-AUTO        JPA自动选择合适的策略，是默认选项
*
* @Column   映射表格列（可选）
*   |-常用属性是name，用于设置映射数据库表的列名
*   |-默认列名等于属性名
* */
@Data
@Entity
@Table(name = "jpa_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usr_id")
    private Integer id; //主键策略

    @Column(name = "usr_name")
    private String name;

    @Column(name = "usr_email")
    private String email;

}
