package mongo;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by chenzhao on 14-5-11.
 */
@Service
public class ReadFile {
    @Autowired
    MongoTemplate mongoTemplate;
    public GridFSDBFile getFile(String filename){
        DB db = this.mongoTemplate.getDb();
        GridFS myFS = new GridFS(db);
        GridFSDBFile file = myFS.findOne(filename);
        return file;
    }
}
