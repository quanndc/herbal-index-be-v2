package vn.mikademy.backend.contexts.herb.application.usecase;

import vn.mikademy.backend.common.exception.BusinessException;
import vn.mikademy.backend.common.exception.ErrorCode;
import vn.mikademy.backend.contexts.herb.domain.model.Herb;
import vn.mikademy.backend.contexts.herb.domain.repository.HerbRepository;
import vn.mikademy.backend.contexts.herb.domain.valueobject.HerbName;
import vn.mikademy.backend.contexts.herb.domain.valueobject.HerbScientificName;
import vn.mikademy.backend.contexts.herb.domain.valueobject.Slug;

public class CreateHerbUseCase {

    private final HerbRepository herbRepository;

    public CreateHerbUseCase(HerbRepository herbRepository){
        this.herbRepository = herbRepository;
    }

    public Herb execute(String name, String scientificName){
        HerbName herbName = new HerbName(name);
        HerbScientificName sciName = new HerbScientificName(scientificName);

        Slug slub = new Slug(herbName.getValue());
        if(herbRepository.existsBySlug(slub.getValue())){
            throw new BusinessException(ErrorCode.HERB_ALREADY_EXISTS,
                    "Herb with slug " + slub.getValue() + " already exists");
        }

        Herb herb = Herb.createNew(herbName, sciName);

        return herbRepository.save(herb);
    };


}
