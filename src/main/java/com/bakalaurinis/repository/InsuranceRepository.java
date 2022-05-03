package com.bakalaurinis.repository;



import com.bakalaurinis.model.Insurance;
import com.bakalaurinis.model.InsuranceDtoWithEvents;
import com.bakalaurinis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
    List<Insurance> findAllByUser(User user);
//    List<InsuranceDtoWithEvents> findAllByUser(User user);

}
