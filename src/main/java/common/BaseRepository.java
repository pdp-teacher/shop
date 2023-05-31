package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<ENTITY extends BaseEntity<ID>, ID> implements Repository<ENTITY, ID> {

    protected abstract String getFilePath();

    @Override
    public ENTITY save(ENTITY entity) {
        List<ENTITY> entities = reading();
        entities.add(entity);
        writnig(entities);
        return entity;

    }

    @Override
    public void delete(ID id) {

        List<ENTITY> entitiesList = reading();
        for (ENTITY entity : reading()) {
            if (entity.getId().equals(id)) {
                entitiesList.remove(entity);
                writnig(entitiesList);
            }
        }
    }

    @Override
    public ENTITY findByID(ID id) {
        for (ENTITY entity : reading()) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<ENTITY> getAll() {
      return reading();
    }


    protected void writnig(List<ENTITY> entities) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(getFilePath()))) {
            objectOutputStream.writeObject(entities);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    protected List<ENTITY> reading() {

        try {
            FileInputStream read = new FileInputStream(getFilePath());
            int read1 = read.read();

            if (read1 == -1) {
                return new ArrayList<>();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(getFilePath()))) {

            return (List<ENTITY>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
