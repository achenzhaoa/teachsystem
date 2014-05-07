package mongo;

import com.mongodb.WriteResult;
import dao.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * Created by dell on 2014/5/7.
 */
public class CRUD implements Repository<User> {

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
}
