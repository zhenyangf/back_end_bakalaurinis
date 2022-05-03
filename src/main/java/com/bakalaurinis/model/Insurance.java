package com.bakalaurinis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private InsuranceStatus status;
    private String category;
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    User user;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "insurance")
    private List<Event> events;

    public Insurance(String title, InsuranceStatus status,  String category, List<InsuranceCategory> selectedDamage,  String address) {
        this.title = title;
        this.status = status;
        this.category = category;
        this.address = address;
    }
}
