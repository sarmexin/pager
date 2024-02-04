package com.sarmexin.postman.object.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@RequiredArgsConstructor
@Table(name = "mail")
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "timeCreation")
    private String timeCreation;

    @NotBlank
    @Column(name = "text")
    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Mail mail = (Mail) o;
        return id != null && Objects.equals(id, mail.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
