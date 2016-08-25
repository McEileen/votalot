package com.votalot.entities;

import com.votalot.enums.Gender;
import com.votalot.enums.Race;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "voters")
public class Voter {
    private int id;
    private String name;
    private Race race;
    private Gender gender;
    private Date createdAt;
    private Date updatedAt;

    public Voter() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Column(nullable = false)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('BLACK', 'WHITE', 'LATINO', 'ASIAN', 'INDIGENOUS', 'OTHER', 'MULTIRACIAL')")
    public Race getRace() {return race;}
    public void setRace(Race race) {this.race = race;}

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('M', 'F', 'NONBINARY', 'GENDERQUEER', 'OTHER')")
    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {this.gender = gender;}

    @Column(name = "created_at", nullable = false, updatable = false)
    public Date getCreatedAt() {return createdAt;}
    public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}

    @Column(name = "updated_at", nullable = false)
    public Date getUpdatedAt() {return updatedAt;}
    public void setUpdatedAt(Date updatedAt) {this.updatedAt = updatedAt;}

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
