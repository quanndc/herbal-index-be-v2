package vn.mikademy.backend.contexts.herb.domain.model;

import lombok.Getter;
import vn.mikademy.backend.contexts.herb.domain.valueobject.*;

import java.time.Instant;

@Getter
public class Herb {

    private final HerbId id;
    private HerbName name;
    private HerbScientificName scientificName;
    private Slug slug;
    private HerbStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public Herb(HerbId id,
                HerbName name,
                HerbScientificName scientificName,
                Slug slug,
                HerbStatus status,
                Instant createdAt,
                Instant updatedAt)
    {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
        this.status = status;
        this.slug = slug;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }

    public static Herb createNew(HerbName name, HerbScientificName scientificName){
        Instant now = Instant.now();

        return new Herb(
                null,
                name, scientificName,
                new Slug(name.getValue()),
                HerbStatus.DRAFT,
                now,
                now
        );
    }

    public void activate(){
        this.status = HerbStatus.ACTIVE;
        this.updatedAt = Instant.now();
    }

    public void deactivate(){
        this.status = HerbStatus.INACTIVE;
        this.updatedAt = Instant.now();
    }

    public void changeName(HerbName name){
        this.name = name;
        this.slug = new Slug(name.getValue());
        this.updatedAt = Instant.now();
    }

    public void changeScientificName(HerbScientificName scientificName){
        this.scientificName = scientificName;
        this.updatedAt = Instant.now();
    }
}
