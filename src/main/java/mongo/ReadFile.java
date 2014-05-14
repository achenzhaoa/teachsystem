package mongo;

import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import utils.Convert2Swf;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenzhao on 14-5-11.
 */
@Service
public class ReadFile {
    @Autowired
    MongoTemplate mongoTemplate;
    Convert2Swf swf = new Convert2Swf();

    public GridFSDBFile getFile(String filename){
        DB db = this.mongoTemplate.getDb();
        GridFS myFS = new GridFS(db);
        GridFSDBFile file = myFS.findOne(filename);
        return file;
    }

    public void convertSwf(File file,String fileName,String format,String basePath){
        swf.start(file,fileName,format,basePath);
    }

    public LinkedList<GridFSDBFile> listFiles(){
        DB db = this.mongoTemplate.getDb();
        GridFS myFS = new GridFS(db);
        DBCursor files = myFS.getFileList();
        LinkedList<GridFSDBFile>lists = new LinkedList<GridFSDBFile>();
        while (files.hasNext()){
            GridFSDBFile item = (GridFSDBFile)files.next();
            lists.add(item);
        }
        return lists;
    }
}
