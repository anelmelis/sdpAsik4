public class Space {
    private final int id;
    private final String name;
    private final SpaceType type;
    private final int capacity;

    public Space(int id, String name, SpaceType type, int capacity) {
        if (id <= 0 || name == null || name.isBlank()
                || type == null || capacity <= 0) {
            throw new IllegalArgumentException("Invalid space details");
        }

        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SpaceType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Space ID: " + id
                + " | Name: " + name
                + " | Type: " + type
                + " | Capacity: " + capacity;
    }
}

