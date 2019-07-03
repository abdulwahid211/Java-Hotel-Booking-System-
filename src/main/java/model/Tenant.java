package model;

import javax.persistence.*;

/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */




@Entity
// table name
@Table(name = "Tennants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Title")
    private String title; // customers initial title

    @Column(name = "FirstName")
    private String firstName; // customers firstname

    @Column(name = "LastName")
    private String lastName; // lastname

    @Column(name = "NoAdultVisitors")
    private String noAdultVisitors; //  No of Adult Visitors

    @Column(name = "NoMiniorsVisitors")
    private String noMiniorsVisitors; // No of Minor Visitors


    public Tenant() {
    };

    // constructor to pass in values
    public Tenant(String title, String firstN, String lastN, String adults,
                  String minors) {

        this.title = title;
        this.firstName = firstN;
        this.lastName = lastN;
        this.noAdultVisitors = adults;
        this.noMiniorsVisitors = minors;
    }


    public int getId() {
        return id;
    }

    // getter method for title
    public String getTitle() {
        return this.title;
    }

    // getter method for firstname
    public String getFirstName() {
        return this.firstName;
    }

    // getter method for lastname
    public String getLastName() {
        return this.lastName;
    }

    // getter method for
    public String getNoAdultVisitors() {
        return this.noAdultVisitors;
    }

    // getter method for No of Minor Visitors
    public String getNoMinorsVisitors() {
        return this.noMiniorsVisitors;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNoAdultVisitors(String noAdultVisitors) {
        this.noAdultVisitors = noAdultVisitors;
    }

    public void setNoMiniorsVisitors(String noMiniorsVisitors) {
        this.noMiniorsVisitors = noMiniorsVisitors;
    }

    /// string method so its prints the object content
    public String toString() {
        return "> Title:" + this.title + " Name:" + this.firstName + " " +
                this.lastName;
    }


}