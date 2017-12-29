package suplex.theblacklist.objects;

/**
 * Created by Morgan on 29/12/2017.
 */

public class Arrest {
    private long id;
    private String date;
    private String time;
    private String type;
    private int complacency;
    private long userId;
    private long locationId;

    public long getId() {
        return id;
    }

    public void setId(long arrestID) {
        this.id = arrestID;
    }

    public int getComplacency() {
        return complacency;
    }

    public void setComplacency(int complacency) {
        this.complacency = complacency;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}