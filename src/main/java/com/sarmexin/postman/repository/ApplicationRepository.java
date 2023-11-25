package com.sarmexin.postman.repository;

import com.sarmexin.postman.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergey Gavrilov
 */
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
