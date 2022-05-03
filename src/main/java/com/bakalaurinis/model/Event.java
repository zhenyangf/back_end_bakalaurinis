package com.bakalaurinis.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ElementCollection
    private List<InsuranceCategory> damageType;

    private String description;

    private String payoutRange;

    private EventStatus status;

    @Lob
    @Nullable
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="insurance_id")
    private Insurance insurance;
}
