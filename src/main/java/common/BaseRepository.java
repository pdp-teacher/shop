package common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class BaseRepository<ENTITY extends BaseEntity<ID>,ID> implements Repository<ENTITY,ID> {


    protected abstract String getFilePath();


    @Override
    public ENTITY save(ENTITY entity) {

        List<ENTITY> entities = readFromFile();
        for (ENTITY checker : entities) {
            if (checker.getAllID().equals(entity.getAllID())){
                System.out.println("Bunday entity mavjud");
                return null;
            }
        }
        entities.add(entity);
        writeToFile(entities);

        return entity;
    }

    @Override
    public void delete(ID id) {
        for (ENTITY read : readFromFile()) {
            if (read.getAllID().equals(id)){
                readFromFile().remove(read);
            }
        }
    }

    @Override
    public List<ENTITY> getAll() {
        return readFromFile();
    }


    public List<ENTITY> readFromFile(){

        List<ENTITY> savedFile = new ArrayList<>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(getFilePath()))){
            savedFile = (List<ENTITY>) objectInputStream.readObject();


        }catch(Exception e){
            e.printStackTrace();
        }
        return savedFile;

    }


    public void  writeToFile(List<ENTITY> entity){

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(getFilePath()))){
            objectOutputStream.writeObject(entity);

        }catch(Exception e){
            e.printStackTrace();
        }

    }



}
