package com.thamardaw.oner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId")
    private Patient patient;

    @Column(insertable = false,updatable = false)
    private Long patientId;

    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billId")
    private Bill bill;

    @Column(insertable = false,updatable = false)
    private Long billId;

    @Column
    private long amount;

    @Column
    private long createdUserId;

    @Column
    private long updatedUserId;

    @Column
    private Timestamp createdTime;

    @Column
    private Timestamp updatedTime;
}
