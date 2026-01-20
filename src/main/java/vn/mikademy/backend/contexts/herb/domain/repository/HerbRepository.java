package vn.mikademy.backend.contexts.herb.domain.repository;

import vn.mikademy.backend.contexts.herb.domain.model.Herb;
import vn.mikademy.backend.contexts.herb.domain.valueobject.HerbId;
import vn.mikademy.backend.contexts.herb.domain.valueobject.Slug;

import java.util.Optional;

public interface HerbRepository {

    Herb save(Herb herb);

    Optional<Herb> findById(HerbId id);

    Optional<Herb> findBySlug(Slug slug);

    boolean existsBySlug(Slug slug);

}
