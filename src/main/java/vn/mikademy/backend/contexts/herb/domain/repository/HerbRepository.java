package vn.mikademy.backend.contexts.herb.domain.repository;

import vn.mikademy.backend.contexts.herb.domain.model.Herb;

import java.util.Optional;

public interface HerbRepository {

    Herb save(Herb herb);

    Optional<Herb> findById(Herb id);

    Optional<Herb> findBySlug(String slug);

    boolean existsBySlug(String slug);
}
