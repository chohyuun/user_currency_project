package com.sparta.currency_user.entity;

import com.sparta.currency_user.enums.ExchangeStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Entity
public class UserCurrency extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Setter
    @ManyToOne
    @JoinColumn(name="currency_id")
    private Currency currency;

    private int amountInKwr;

    @Setter
    private BigDecimal amountAfterExchange;

    @Enumerated(value = EnumType.STRING)
    private ExchangeStatus status;

    public UserCurrency(int amountInKwr, ExchangeStatus status) {
        this.amountInKwr = amountInKwr;
        this.status = status;
    }

    public UserCurrency() {}

    public void update(ExchangeStatus status) {
        this.status = status;
    }

}
