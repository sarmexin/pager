//package com.sarmexin.postman.object.entity;
//
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private long id;
//
//    @OneToMany(mappedBy = "user")
//    @ToString.Exclude
//    private List<Mail> mails;
//
//    @Column(name = "city")
//    private String city;
//
//    @Column(name = "street")
//    private String street;
//
//    @Column(name = "house")
//    private String house;
//
//    @Column(name = "entrance")
//    private int entrance;
//
//    @Column(name = "flat")
//    private int flat;
//
//}
