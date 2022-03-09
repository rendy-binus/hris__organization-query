package com.rendyezaputra.hris.organizationquery.domain.entity;

import com.rendyezaputra.hris.hriswebresources.entity.BaseEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Team")
@Table(name = "team", schema = "organization")
public class TeamEntity extends BaseEntity {

    @NotNull
    @Id
    @Column(nullable = false)
    private UUID id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 6)
    private String color;

    @NotBlank
    @Column(nullable = false, updatable = false, length = 25)
    private String createdBy;
    @NotNull
    @Column(nullable = false, updatable = false, columnDefinition = "timestamptz")
    private LocalDateTime createdDate;
    @NotBlank
    @Column(nullable = false, length = 25)
    private String updatedBy;
    @NotNull
    @Column(nullable = false, columnDefinition = "timestamptz")
    private LocalDateTime updatedDate;

    private boolean active;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TeamEntity that = (TeamEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
