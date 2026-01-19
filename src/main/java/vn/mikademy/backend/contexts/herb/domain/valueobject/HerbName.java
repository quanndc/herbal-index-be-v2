package vn.mikademy.backend.contexts.herb.domain.valueobject;
import vn.mikademy.backend.common.valueobject.AbstractStringValueObject;
import vn.mikademy.backend.contexts.herb.domain.constants.HerbConstants;

public final class HerbName extends AbstractStringValueObject {
    public HerbName(String value) {
        super(value, false, HerbConstants.MAX_NAME_LENGTH, "Herbal Name");
    }
}
