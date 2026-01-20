package vn.mikademy.backend.contexts.herb.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.mikademy.backend.contexts.herb.domain.valueobject.Slug;
import vn.mikademy.backend.contexts.herb.infrastructure.persistence.entity.HerbEntity;

import java.util.Optional;

public interface JpaHerbRepository extends JpaRepository<HerbEntity, Long> {

    Optional<HerbEntity> findBySlug(String slug);
    boolean existsBySlug(String slug);
}
