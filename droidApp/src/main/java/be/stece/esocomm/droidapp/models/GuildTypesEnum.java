package be.stece.esocomm.droidapp.models;

/**
 * Created by Stece on 9/06/2014.
 */
public enum GuildTypesEnum{
    CRAFTING("Crafting"),
    TRADING("Trading"),
    PVP("PVP"),
    PVE("PVE"),
    DUNGEONS("Dungeons"),
    ROLEPLAYING("Role-Playing"),
    REGIONAL("Region"); // TODO: how to handle regions, for example guild for Belgian players?

    private final String value;

    private GuildTypesEnum(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
