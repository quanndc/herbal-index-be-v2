package vn.mikademy.backend.contexts.herb.infrastructure.persistence.repository;

import vn.mikademy.backend.contexts.herb.application.mapper.HerbMapper;
import vn.mikademy.backend.contexts.herb.domain.model.Herb;
import vn.mikademy.backend.contexts.herb.domain.repository.HerbRepository;
import vn.mikademy.backend.contexts.herb.domain.valueobject.HerbId;
import vn.mikademy.backend.contexts.herb.domain.valueobject.Slug;
import vn.mikademy.backend.contexts.herb.infrastructure.persistence.entity.HerbEntity;

import java.util.Optional;

public class HerbRepositoryImpl implements HerbRepository {

    private final JpaHerbRepository jpaHerbRepository;

    public HerbRepositoryImpl(JpaHerbRepository jpaHerbRepository) {
        this.jpaHerbRepository = jpaHerbRepository;
    }

    // =====================
    // Save (Create / Update)
    // =====================

    @Override
    public Herb save(Herb herb) {
        HerbEntity entity = HerbMapper.fromDomain(herb);

        HerbEntity savedEntity = jpaHerbRepository.save(entity);

        return HerbMapper.toDomain(savedEntity);
    }

    // =====================
    // Find by ID
    // =====================

    @Override
    public Optional<Herb> findById(HerbId id) {
        return jpaHerbRepository
                .findById(id.getValue())
                .map(HerbMapper::toDomain);
    }

    // =====================
    // Find by Slug
    // =====================

    @Override
    public Optional<Herb> findBySlug(Slug slug) {
        return jpaHerbRepository
                .findBySlug(slug.getValue())
                .map(HerbMapper::toDomain);
    }

    // =====================
    // Exists by Slug
    // =====================

    @Override
    public boolean existsBySlug(Slug slug) {
        return jpaHerbRepository.existsBySlug(slug.getValue());
    }
}