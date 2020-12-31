package com.orange.talent.account.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Account")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_bank")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;

    @Column (name = "id_bank", insertable = false, updatable = false)
    private Long bankID;

    @Column
    private Integer account;

    @Column
    private Integer agency;

    @Column
    private Integer accountDigit;
}
