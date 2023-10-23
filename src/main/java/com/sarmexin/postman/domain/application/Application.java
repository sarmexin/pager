package com.sarmexin.postman.domain.application;

import com.sarmexin.postman.domain.user.User;
import com.sarmexin.postman.enums.ApplicationStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Sergey Gavrilov
 */
@Entity
@Data
@Table(name = "application")
@NoArgsConstructor
public class Application {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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
