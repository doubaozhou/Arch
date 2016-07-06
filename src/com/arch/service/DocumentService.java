package com.arch.service;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Document;
import com.arch.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 2016/7/7.
 * @author zhou 
 */
public class DocumentService {
    private Dao userDao = new DaoImpl();

    public List<Document> QueryDocumentList() {
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            ResultSet resultSet = userDao.getAllDocument(conn);

            List<Document> list = new ArrayList<>();
            while (resultSet.next()) {
                Document document = new Document();
                document.setId(resultSet.getString(1) != null ? resultSet.getString(1) : "");
                document.setBuilding_id(resultSet.getString(2) != null ? resultSet.getString(2) : "");
                document.setName(resultSet.getString(3) != null ? resultSet.getString(3) : "");
                document.setD_abstract(resultSet.getString(4) != null ? resultSet.getString(4) : "");
                document.setAuthor(resultSet.getString(5) != null ? resultSet.getString(5) : "");
                document.setKey_word(resultSet.getString(6) != null ? resultSet.getString(6) : "");
                document.setDate(resultSet.getString(7) != null ? resultSet.getString(7) : "");
                document.setSerial_number(resultSet.getString(8) != null ? resultSet.getString(8) : "");
                document.setCreate_time(resultSet.getString(9) != null ? resultSet.getString(9) : "");
                document.setSize(resultSet.getString(10) != null ? resultSet.getString(10) : "");
                list.add(document);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Document QueryDocument(String id) {
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            ResultSet resultSet = userDao.getDocument(conn, id);
            Document document = new Document();
            if (resultSet.next()) {
                document.setId(resultSet.getString(1) != null ? resultSet.getString(1) : "");
                document.setBuilding_id(resultSet.getString(2) != null ? resultSet.getString(2) : "");
                document.setName(resultSet.getString(3) != null ? resultSet.getString(3) : "");
                document.setD_abstract(resultSet.getString(4) != null ? resultSet.getString(4) : "");
                document.setAuthor(resultSet.getString(5) != null ? resultSet.getString(5) : "");
                document.setKey_word(resultSet.getString(6) != null ? resultSet.getString(6) : "");
                document.setDate(resultSet.getString(7) != null ? resultSet.getString(7) : "");
                document.setSerial_number(resultSet.getString(8) != null ? resultSet.getString(8) : "");
                document.setCreate_time(resultSet.getString(9) != null ? resultSet.getString(9) : "");
                document.setSize(resultSet.getString(10) != null ? resultSet.getString(10) : "");
            }

            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
