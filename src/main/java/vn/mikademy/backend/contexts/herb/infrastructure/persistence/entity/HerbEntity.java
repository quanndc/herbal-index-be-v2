package vn.mikademy.backend.contexts.herb.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Entity
@Table(
        name = "herbs",
        indexes = {
                @Index(name = "idx_herb_slug", columnList = "slug", unique = true)
        }
)
public class HerbEntity {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, length = 255)
    private String name;

    @Setter
    @Column(name = "scientific_name", length = 255)
    private String scientificName;

    @Setter
    @Column(nullable = false, length = 255, unique = true)
    private String slug;

    @Setter
    @Column(nullable = false, length = 50)
    private String status;

    @Setter
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Setter
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    // =====================
    // JPA lifecycle hooks
    // =====================

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }

    // =====================
    // Getters & setters
    // =====================

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getSlug() {
        return slug;
    }

    public String getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}