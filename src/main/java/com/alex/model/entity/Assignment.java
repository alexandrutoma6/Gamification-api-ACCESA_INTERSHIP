package com.alex.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Assignment {
    @Id
    @SequenceGenerator(
            name = "assignment_id_sequence",
            sequenceName = "assignment_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "assignment_id_sequence"
    )

    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private AccountUser user;
    @OneToOne
    @JoinColumn(name = "quest_id")
    private Quest quest;
    private String status;

    public Assignment() {
    }
    public Assignment(Integer id, AccountUser user, Quest quest, String status) {
        this.id = id;
        this.user = user;
        this.quest = quest;
        this.status = status;
    }
    public Assignment(AccountUser user,Quest quest, String status){
        this.user = user;
        this.quest = quest;
        this.status = status;
    }

    public Integer getId(){return  id;}
    public AccountUser getUser() {
        return user;
    }
    public Quest getQuest() {
        return quest;
    }
    public String getStatus() {
        return status;
    }
    public void setId(Integer id){this.id=id;}
    public void setUser(AccountUser user) {
        this.user = user;
    }
    public void setQuest(Quest quest) {
        this.quest = quest;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(quest, that.quest) && Objects.equals(status, that.status);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, user, quest, status);
    }
    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", user=" + user +
                ", quest=" + quest +
                ", status='" + status + '\'' +
                '}';
    }
}
