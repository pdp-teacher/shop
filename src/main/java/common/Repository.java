package common;

import java.util.List;
import java.util.UUID;

public interface Repository <Entity extends BaseEntity>{
    Entity add(Entity entity);
    void delete(UUID id);
    Entity get(UUID id);
    List<Entity> getAll();
}
