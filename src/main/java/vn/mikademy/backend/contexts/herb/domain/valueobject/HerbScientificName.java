package vn.mikademy.backend.contexts.herb.domain.valueobject;

import vn.mikademy.backend.common.valueobject.AbstractStringValueObject;
import vn.mikademy.backend.contexts.herb.domain.constants.HerbConstants;

public final class HerbScientificName extends AbstractStringValueObject {
    public HerbScientificName(String value) {
        super(value, false, HerbConstants.MAX_SCIENTIFIC_NAME_LENGTH, "Herb Scientific Name");
    }
}
