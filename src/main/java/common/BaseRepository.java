package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class BaseRepository<Entity extends BaseEntity> implements Repository<Entity> {
    protected abstract String getPath();

    @Override
    public Entity add(Entity entity) {
        List<Entity> entities = readFile();
        entities.add(entity);
        writeFile(entities);
        return entity;
    }

    @Override
    public void delete(UUID id) {
        List<Entity> entities = readFile();
        entities.removeIf(entity -> entity.getId().equals(id));
    }

    @Override
    public Entity get(UUID id) {
        List<Entity> entities = readFile();
        for (Entity entity : entities) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<Entity> getAll() {
        return readFile();
    }

    private void writeFile(List<Entity> entity) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(getPath()))) {
            objectOutputStream.writeObject(entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Entity> readFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(getPath()));) {
            return (List<Entity>) objectInputStream.readObject();
        } catch (Exception e) {
            return new ArrayList<Entity>();
        }
    }

}
