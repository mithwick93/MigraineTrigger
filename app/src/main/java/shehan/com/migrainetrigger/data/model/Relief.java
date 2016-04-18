package shehan.com.migrainetrigger.data.model;

/**
 * Created by Shehan on 4/13/2016.
 */
public class Relief {

    private int reliefId;
    private String reliefName;
    private int priority;
    private boolean effective;

    public Relief(int reliefId, String reliefName, int priority, boolean effective) {
        this.reliefId = reliefId;
        this.reliefName = reliefName;
        this.priority = priority;
        this.effective = effective;
    }

    public int getReliefId() {
        return reliefId;
    }

    public void setReliefId(int reliefId) {
        this.reliefId = reliefId;
    }

    public String getReliefName() {
        return reliefName;
    }

    public void setReliefName(String reliefName) {
        this.reliefName = reliefName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isEffective() {
        return effective;
    }

    public void setEffective(boolean effective) {
        this.effective = effective;
    }
}