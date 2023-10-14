package com.sarmexin.postman.repo;

import com.sarmexin.postman.domain.MessageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergey Gavrilov
 */
@Repository
public interface MessageRepository extends JpaRepository<MessageData, Long> {

}
