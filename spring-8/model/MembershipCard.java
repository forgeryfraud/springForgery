
package com.examly.springapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MembershipCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cardNumber;
    private LocalDate expirationDate;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // Constructors
    public MembershipCard() {}

    public MembershipCard(String cardNumber, LocalDate expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    // Getters and setters
    // Id
    public int getId() {
        return id;
    }

    // CardNumber
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // ExpirationDate
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Member
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}