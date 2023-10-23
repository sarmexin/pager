package com.sarmexin.postman.repository;

import com.sarmexin.postman.domain.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergey Gavrilov
 */
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
