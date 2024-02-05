package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private long portfolioId;

    @Column(nullable = false)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> security;

    public Portfolio(Date creationDate, List<Security> security) {
        this.creationDate = creationDate;
        this.security = security;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Security> getSecurity() {
        return security;
    }

    public void setSecurity(List<Security> security) {
        this.security = security;
    }
}
