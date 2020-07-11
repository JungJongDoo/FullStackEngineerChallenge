package com.paypay.manager.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    private String email;
    private String name;
    private String mobileNo;
    private String memberType;
    private String sex;

    @OneToMany(mappedBy = "employeeNo")
    private List<Review> reviews;

    public int getReviewCount() {
        if (reviews == null) {
            return 0;
        }
        return reviews.size();
    }
}
