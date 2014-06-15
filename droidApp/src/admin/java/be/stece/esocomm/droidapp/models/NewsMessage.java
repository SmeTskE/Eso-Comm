package be.stece.esocomm.droidapp.models;

/**
 * Created by Stece on 15/06/2014.
 */
public class NewsMessage  {

    private long id;
    private String title;
    private String body;

    public NewsMessage(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public NewsMessage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
