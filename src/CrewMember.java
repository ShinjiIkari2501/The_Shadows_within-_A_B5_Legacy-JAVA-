public class CrewMember {
    private String name;
    private String roleClass;
    private boolean isAlive;

    public CrewMember(String name, String roleClass) {
        this.name = name;
        this.roleClass = roleClass;
        this.isAlive = true;
    }

    public String getName() { return name; }
    public String getRoleClass() { return roleClass; }
    public boolean isAlive() { return isAlive; }
    public void setAlive(boolean alive) { this.isAlive = alive; }
}