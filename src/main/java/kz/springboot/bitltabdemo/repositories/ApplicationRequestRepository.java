package kz.springboot.bitltabdemo.repositories;

import kz.springboot.bitltabdemo.entities.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest,Long> {

    List<ApplicationRequest> findApplicationRequestsByHandledIsTrue();
    List<ApplicationRequest> findApplicationRequestsByHandledIsFalse();
}
