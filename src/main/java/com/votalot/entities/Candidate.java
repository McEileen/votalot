package com.votalot.entities;


import com.votalot.enums.Party;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "candidates")
public class Candidate {
    private int id;
    private String name;
    private Party party;
    private Contest contest;
    private Date createdAt;
    private Date updatedAt;

    public Candidate() {
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
    @Column(columnDefinition = "ENUM('D', 'R', 'I', 'L', 'G')")
    public Party getParty() {return party;}
    public void setParty(Party party) {this.party = party;}

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "contest_id")
    public Contest getContest() {return contest;}
    public void setContest(Contest contest) {this.contest = contest;}

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
