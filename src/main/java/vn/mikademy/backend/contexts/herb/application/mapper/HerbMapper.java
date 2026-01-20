package vn.mikademy.backend.contexts.herb.application.mapper;

import vn.mikademy.backend.contexts.herb.domain.model.Herb;
import vn.mikademy.backend.contexts.herb.domain.valueobject.*;
import vn.mikademy.backend.contexts.herb.infrastructure.persistence.entity.HerbEntity;

public final class HerbMapper {

    private HerbMapper() {
        // utility class
    }

    // =====================
    // Domain -> Persistence
    // =====================
    public static HerbEntity fromDomain(Herb herb) {
        HerbEntity entity = new HerbEntity();

        // chỉ set id khi update
        if (herb.getId() != null) {
            entity.setId(herb.getId().getValue());
        }

        entity.setName(herb.getName().getValue());

        entity.setScientificName(
                herb.getScientificName() != null
                        ? herb.getScientificName().getValue()
                        : null
        );

        entity.setSlug(herb.getSlug().getValue());
        entity.setStatus(herb.getStatus().name());

        entity.setCreatedAt(herb.getCreatedAt());
        entity.setUpdatedAt(herb.getUpdatedAt());

        return entity;
    }

    // =====================
    // Persistence -> Domain
    // =====================
    public static Herb toDomain(HerbEntity entity) {
        return new Herb(
                new HerbId(entity.getId()),
                new HerbName(entity.getName()),
                new HerbScientificName(entity.getScientificName()),
                new Slug(entity.getSlug()),
                HerbStatus.valueOf(entity.getStatus()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}