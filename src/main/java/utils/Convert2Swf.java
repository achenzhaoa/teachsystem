package utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by chenzhao on 14-5-11.
 */
public class Convert2Swf {
    Properties props;
    String swfPath;
    public Convert2Swf(){
        Resource resource = new ClassPathResource("swfconfig.properties");
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
            swfPath = props.getProperty("convertCommand");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int start(File inFile,String filename,String format,String basePath) {
        ProcessBuilder pb = new ProcessBuilder();
        List<String> commandArray = new ArrayList<String>();
        commandArray.add(swfPath);
        commandArray.add(inFile.getPath());

        commandArray.add("-o");
        commandArray.add(basePath+filename+".swf");
        Process pro = null;
        try {
            System.out.println("正在转换......");

            pro = pb.command(commandArray).start();
            int result = 0;
            try {
                result = pro.waitFor();
                long waitTime = inFile.length()/50;
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pro.destroy();
            System.out.println("转换完毕");
            //return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }


}
