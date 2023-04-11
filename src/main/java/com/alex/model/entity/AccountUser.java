package com.alex.model.entity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class AccountUser {

    @Id
    @SequenceGenerator(
            name = "accountUser_id_sequence",
            sequenceName = "accountUser_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accountUser_id_sequence"
    )
    private Integer id;
    private String name;
    private Integer tokens;

    public AccountUser(String name, Integer tokens) {
        this(null,name,tokens);
    }
    public AccountUser(Integer id, String name, Integer tokens) {
        this.id = id;
        this.name = name;
        this.tokens = tokens;
    }
    public AccountUser() {}

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getTokens() {
        return tokens;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTokens(Integer tokens) {
        this.tokens = tokens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountUser that = (AccountUser) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(tokens, that.tokens);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, tokens);
    }
    @Override
    public String toString() {
        return "AccountUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}
