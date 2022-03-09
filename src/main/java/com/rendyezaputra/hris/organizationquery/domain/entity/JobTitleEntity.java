package com.rendyezaputra.hris.organizationquery.domain.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
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
@Entity(name = "JobTitle")
@Table(name = "job_title", schema = "organization")
public class JobTitleEntity {

    @NotNull
    @Id
    @Column(nullable = false)
    private UUID id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "job_function_id", nullable = false)
    private JobFunctionEntity jobFunctionEntity;

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
        JobTitleEntity that = (JobTitleEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
