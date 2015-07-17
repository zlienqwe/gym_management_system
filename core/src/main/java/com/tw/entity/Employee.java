package com.tw.entity;


import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "employeeName")
    private String employeeName;

    @Column(name = "role")
    private String role;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "employee")
//    private User u


    public Employee() {

    }

    public Employee(String employeeName, String role) {
        this.employeeName = employeeName;

        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}