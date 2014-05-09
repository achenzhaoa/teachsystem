package dao;

import com.mongodb.WriteResult;
import mongo.User;

import java.util.List;

/**
 * Created by dell on 2014/5/7.
 */
public interface Repository<T> {

    public List<T> getAllObjects();

    public void saveObject(T object);

    public WriteResult updateObject(String id,String name);

    public void deleteObject(String id);

    public void createCollection();

    public User login(String user,String pwd);
}
