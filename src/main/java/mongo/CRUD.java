package mongo;

import com.mongodb.WriteResult;
import dao.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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
}
