public class Location {
    private String id;
    private String displayName;
    private boolean isBlocked;
    private boolean isVisited;

    public Location(String id, String displayName) {
        this.id = id;
        this.displayName = displayName;
        this.isBlocked = false;
        this.isVisited = false;
    }

    public String getId() { return id; }
    public String getDisplayName() { return displayName; }
    public boolean isBlocked() { return isBlocked; }
    public void setBlocked(boolean blocked) { this.isBlocked = blocked; }
    public boolean isVisited() { return isVisited; }
    public void setVisited(boolean visited) { this.isVisited = visited; }
}