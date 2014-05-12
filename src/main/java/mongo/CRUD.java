package mongo;

import com.mongodb.DB;
import com.mongodb.WriteResult;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import dao.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * Created by dell on 2014/5/7.
 */
@Service
public class CRUD implements Repository<User> {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<User> getAllObjects() {
        return this.mongoTemplate.findAll(User.class);
    }

    @Override
    public void saveObject(User user) {
        this.mongoTemplate.insert(user);
    }

    @Override
    public WriteResult updateObject(String id, String name) {
        return null;
    }

    @Override
    public void deleteObject(String id) {

    }

    @Override
    public void createCollection() {

    }

    @Override
    public User login(String name, String pwd) {
        Criteria criteria = Criteria.where("name").is(name)
                .andOperator(Criteria.where("pwd").is(pwd));
        return this.mongoTemplate.findOne(Query.query(criteria),User.class);
    }

    @Override
    public boolean changePwd(String name, String pwd, String newPwd) {
        WriteResult rs = this.mongoTemplate.updateFirst(new Query(Criteria.where("name").is(name)
                        .andOperator(Criteria.where("pwd").is(pwd))),
                Update.update("pwd",newPwd),User.class
        );
        return true;
    }

    @Override
    public User findPwd(String name) {
        return null;
    }

    @Override
    public void uploadFile(String fileName,String type,InputStream file) {
        DB db = this.mongoTemplate.getDb();
        GridFS myFS = new GridFS(db);
        GridFSInputFile gfsInput = myFS.createFile(file);
        gfsInput.setFilename(fileName);
        gfsInput.setContentType(type);
        gfsInput.save();
    }
}
