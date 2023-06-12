package common;

import java.io.*;
import java.util.List;

public abstract class BaseRepository <ENTITY extends BaseEntity<ID>, ID> implements Repository<ENTITY,ID> {

    protected abstract List<ENTITY> getList();
    protected abstract String getFilePath();
    @Override
    public ENTITY save(ENTITY entity) {
        getList().add(entity);
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(getFilePath()))){
            stream.writeObject(getList());
        } catch (IOException e){
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public ENTITY findById(ID id) {
        for (ENTITY entity : getList()) {
            if (entity.getId().equals(id)){
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<ENTITY> getAll() {
        return getList();
    }

    @Override
    public void deleteById(ID id) {
        for (ENTITY entity : getList()) {
            if (entity.getId().equals(id)){
                getList().remove(entity);
            }
        }
    }

    protected static <REPOSITORY extends BaseRepository<THIS_ENTITY, THIS_ID>, THIS_ENTITY extends
            BaseEntity<THIS_ID>, THIS_ID>
    void readFromFile(REPOSITORY repository, String path) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path))){
            repository.getList().addAll((List<THIS_ENTITY>) stream.readObject());
        } catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

}
