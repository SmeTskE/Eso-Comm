package be.stece.esocomm.droidapp.models;

/**
 * Created by Stece on 8/06/2014.
 */
public enum DrawerMenuEnum {
    SEARCH_GUILDS_SCREEN("Search Guild"),
    PUBLISH_GUILD_SCREEN("Publish Guild"),
    SETTINGS_SCREEN("Settings");

    private final String value;

    private DrawerMenuEnum(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
