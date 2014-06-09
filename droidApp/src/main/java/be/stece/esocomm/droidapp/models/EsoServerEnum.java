package be.stece.esocomm.droidapp.models;

/**
 * Created by Stece on 7/06/2014.
 */
public enum EsoServerEnum {
    NORTH_AMERICAN("North American Server"),
    EUROPEAN("European Server");

    private final String value;

    private EsoServerEnum(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
