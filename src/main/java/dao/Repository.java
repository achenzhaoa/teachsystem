package dao;

import mongo.User;

import java.io.InputStream;
import java.util.List;

/**
 * Created by dell on 2014/5/7.
 */
public interface Repository<T> {

    public List<T> getAllObjects();

    public void saveObject(T object);

    public void deleteUser(String id);

    public void setActiveUser(String id,boolean active);

    public User login(String user,String pwd);

    public boolean changePwd(String name,String pwd,String newPwd);

    public void insertUser(User user);

    public User findPwd(String name);

    public void uploadFile(String fileName,String type,InputStream file);
}
