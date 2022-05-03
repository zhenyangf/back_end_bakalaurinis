package com.bakalaurinis.repository;



import ch.qos.logback.core.net.server.Client;
import com.bakalaurinis.model.Event;
import com.bakalaurinis.model.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findAllByInsurance(Insurance insurance);


}
