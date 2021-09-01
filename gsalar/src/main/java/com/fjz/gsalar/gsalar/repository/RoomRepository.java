package com.fjz.gsalar.gsalar.repository;


import com.fjz.gsalar.gsalar.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
