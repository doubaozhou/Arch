package com.arch.dao;

import com.mongodb.*;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Archer on 16/6/17.
 *
 */
public class MongoGF {

    private static Mongo mongo = null;
    private static DB db = null;

    /*
    测试
     */
    public static void main(String args[]) throws Exception {
        startMongoDBConn();
        //saveFile("/Users/Archer/Desktop/IMG_0485.jpg", "1");
        //readFile("/Users/Archer/Desktop/", "001.jpg", "1");
        deleteFile("1");
        //reviseFile("/Users/Archer/Desktop/IMG_0486.jpg","1");
    }

    /*
    获取mongodb数据库连接
     */
    public static void startMongoDBConn(){
        try{
            //Mongo(p1,p2):p1=>IP地址    p2=>端口
            mongo = new Mongo("127.0.0.1",27017);
            //根据Mongodb数据库名称获得Mongodb对象
            db = mongo.getDB("ArchPic");
        } catch (MongoException e){
            e.printStackTrace();
        }
    }


    /*
    上传文件
     */

    public static void saveFile(String directPath, String pictureNumber) throws Exception {
        //directPath=>文件绝对路径    pictureNumber=>图片唯一编号
        //文件操作是在DB的基础上实现的，与表和文档没有关系
        GridFS gridFS = new GridFS(db);

        File readFile = new File(directPath);

        GridFSInputFile mongofile=gridFS.createFile(readFile);
    //可以再添加属性
        mongofile.put("path", directPath);
        mongofile.put("picturenumber", pictureNumber);
    //保存
        mongofile.save();
    }

    /*
    下载文件
     */
    public static void readFile(String directory, String fileName, String pictureNumber) throws IOException {
        //directory=>文件所在目录    fileName=>自定义文件名字 pictureNumber=>图片唯一编号
        GridFS gridFS = new GridFS(db);

        DBObject query = new BasicDBObject("picturenumber", pictureNumber);//查找条件
        List<GridFSDBFile> listfiles = gridFS.find(query);
        GridFSDBFile gridFSDBFile = listfiles.get(0);

        String name = (String) gridFSDBFile.get("filename");
        if (fileName.equals("") || fileName == null){
            fileName = name;
        }
        String directPath = directory + fileName;
        File writeFile = new File(directPath);
        if (!writeFile.exists()){
            writeFile.createNewFile();
        }

        //写文件
        gridFSDBFile.writeTo(writeFile);
    }

    /*
    删除文件
     */
    public static void deleteFile(String pictureNumber){
        GridFS gridFS = new GridFS(db);
        DBObject query = new BasicDBObject("picturenumber", pictureNumber);
        gridFS.remove(query);
    }

    /*
    修改文件
     */
    public static void reviseFile(String directPath, String pictureNumber) throws Exception {
        deleteFile(pictureNumber);
        saveFile(directPath, pictureNumber);
    }
}
