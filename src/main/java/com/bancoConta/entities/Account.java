package com.bancoConta.entities;


import com.bancoConta.dto.AccountRequest;
import com.bancoConta.dto.clients.UserInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "account")
@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "agency")
    private Integer agency;

    @Column(name = "create_date")
    @CreatedDate
    private LocalDateTime createDate;

    @Column(name = "update_date")
    @LastModifiedDate
    private LocalDateTime updateDate;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING) //para utilizar enums
    private AccountType accountType;

    @Column(name = "user_id")
    private Integer userId;


    public Account(AccountRequest accountRequest, UserInfo userInfo) {
        this.number = accountRequest.getNumber();
        this.agency = accountRequest.getAgency();
        this.balance = accountRequest.getBalance();
        this.accountType = accountRequest.getAccountType();
        this.userId = userInfo.getId();
    }
}
