package persons;

public enum PersonType {
    GUEST("Guest"),
    FULLTIME_WORKER("Full timer"),
    PARTTIME_WORKER("Part timer"),
    MANAGER("Manager");

    private final String prettyName;

    PersonType(String prettyName) {
        this.prettyName = prettyName;
    }

    public String getPrettyName() {
        return prettyName;
    }

}
