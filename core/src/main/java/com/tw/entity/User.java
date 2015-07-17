package com.tw.entity;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String userName;
    private String password;
    private Employee employee;

    public User(String userName, String password, Employee employee) {
        this.userName = userName;
        this.password = password;
        this.employee = employee;
    }

    public User(int id, String userName, String password, Employee employee) {

        this.id = id;
        this.userName = userName;
        this.password = password;
        this.employee = employee;
    }

    public User() {

    }

    @OneToOne
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "password")
//    private String password;
//
//    private Employee employee;
//
//    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @PrimaryKeyJoinColumn
//    public Employee getEmployee() {
//
//        return this.employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    public User() {
//
//    }
////
////    public User(String name, String password, Employee employee) {
////        this.name = name;
////        this.password = password;
////        this.employee = employee;
////    }
//
//    public User(String name, String password) {
//        this.name = name;
//        this.password = password;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getId(){
//        return this.id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
}