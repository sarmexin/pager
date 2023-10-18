package com.sarmexin.postman.domain.application;

import com.sarmexin.postman.enums.ApplicationStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Sergey Gavrilov
 */
@Entity
@Table
@Data
public class ApplicationData {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private ApplicationStatus applicationStatus;

    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime completionTime;

    @Column
    private String text;

    @Column
    private long authorId;

    @Column
    private long recipientId;

    @PrePersist
    void onCreate() {
        this.setCreatedTime(LocalDateTime.now());
    }

}
