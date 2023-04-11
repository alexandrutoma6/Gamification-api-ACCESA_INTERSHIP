package com.alex.repository;
import com.alex.model.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest,Integer> {
}
