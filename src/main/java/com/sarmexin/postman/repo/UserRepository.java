package com.sarmexin.postman.repo;

import com.sarmexin.postman.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergey Gavrilov
 */
@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
}
