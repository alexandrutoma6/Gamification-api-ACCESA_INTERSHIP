package com.alex.model.entity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Quest {

    @Id
    @SequenceGenerator(
            name = "quest_id_sequence",
            sequenceName = "quest_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quest_id_sequence"
    )
    private Integer id;
    private String requirement;
    private Integer reward;

    public Quest() {
    }
    public Quest(Integer id, String requirement, Integer reward) {
        this.id = id;
        this.requirement = requirement;
        this.reward = reward;
    }
    public Quest(String requirement,Integer reward){
        this(null,requirement,reward);
    }

    public Integer getId() {
        return id;
    }
    public String getRequirement() {
        return requirement;
    }
    public Integer getReward() {
        return reward;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
    public void setReward(Integer reward) {
        this.reward = reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quest quest = (Quest) o;
        return Objects.equals(id, quest.id) && Objects.equals(requirement, quest.requirement) && Objects.equals(reward, quest.reward);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, requirement, reward);
    }
    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", requirement='" + requirement + '\'' +
                ", reward=" + reward +
                '}';
    }
}
