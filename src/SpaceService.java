import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpaceService {
    private final List<Space> spaces = new ArrayList<>();

    public SpaceService() {
        spaces.add(new Space(101, "Executive Office",
                SpaceType.PRIVATE_OFFICE, 6));

        spaces.add(new Space(102, "Conference Office",
                SpaceType.PRIVATE_OFFICE, 12));

        spaces.add(new Space(103, "Business Office",
                SpaceType.PRIVATE_OFFICE, 4));

        spaces.add(new Space(201, "Cozy Lounge",
                SpaceType.OPEN_SPACE, 10));

        spaces.add(new Space(202, "Creative Zone",
                SpaceType.OPEN_SPACE, 20));

        spaces.add(new Space(203, "Relax Hub",
                SpaceType.OPEN_SPACE, 8));
    }

    public List<Space> getAllSpaces() {
        return Collections.unmodifiableList(spaces);
    }

    public Space findSpaceById(int id) {
        for (Space space : spaces) {
            if (space.getId() == id) {
                return space;
            }
        }
        return null;
    }
}
