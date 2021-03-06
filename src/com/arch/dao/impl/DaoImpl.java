package com.arch.dao.impl;

import com.arch.dao.Dao;
import com.arch.entity.*;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhou on 2016/5/20.
 *
 * @author zhou
 */
public class DaoImpl implements Dao {
    @Override
    public ResultSet getAllBuilding(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_HistoricalBuilding order by ID");
        return ps.executeQuery();
    }

    @Override
    public ResultSet getBuilding(Connection conn, String id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_HistoricalBuilding b WHERE b.ID = ?");
        ps.setString(1, id);

        return ps.executeQuery();
    }

    @Override
    public void insertBuildingBaseInfo(Connection conn, Building building) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HC_HistoricalBuilding(BUILDINGNAME,CITY,ADDRESS,DESIGNER,BUILDINGDATE," +
                "CONSTRUCTIONORG,DESCRIPTION,TYPE,STYLE,STRUCTURE,POSTCODE,CREATETIME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, building.getName());
        ps.setString(2, building.getCity());
        ps.setString(3, building.getAddress());
        ps.setString(4, building.getDesigner());
        ps.setString(5, building.getDate());
        ps.setString(6, building.getConstruct_org());
        ps.setString(7, building.getDesc());
        ps.setString(8, building.getType());
        ps.setString(9, building.getStyle());
        ps.setString(10, building.getStructure());
        ps.setString(11, building.getPost_code());
        ps.setString(12, building.getCreate_time());

        ps.execute();
    }

    @Override
    public void updateBuildingBaseInfo(Connection conn, String id, Building building) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE HC_HistoricalBuilding SET BUILDINGNAME = ?, CITY=?, ADDRESS = ?," +
                "DESIGNER=?, BUILDINGDATE = ?, CONSTRUCTIONORG=?, DESCRIPTION =?, TYPE=?, STYLE=?,STRUCTURE=?,POSTCODE=? WHERE ID = ?");
        ps.setString(1, building.getName());
        ps.setString(2, building.getCity());
        ps.setString(3, building.getAddress());
        ps.setString(4, building.getDesigner());
        ps.setString(5, building.getDate());
        ps.setString(6, building.getConstruct_org());
        ps.setString(7, building.getDesc());
        ps.setString(8, building.getType());
        ps.setString(9, building.getStyle());
        ps.setString(10, building.getStructure());
        ps.setString(11, building.getPost_code());
        ps.setString(12, id);

        ps.execute();
    }

    @Override
    public ResultSet getAllPicture(Connection conn, String bId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_PICTURES WHERE BUILDINGID = ?");
        ps.setString(1, bId);

        return ps.executeQuery();
    }

    @Override
    public ResultSet getPicture(Connection conn, String id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_PICTURES WHERE ID = ?");
        ps.setString(1, id);

        return ps.executeQuery();
    }

    @Override
    public void insertPictureInfo(Connection conn, String id, String bId, String name, String time, String size) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HC_PICTURES(ID, BUILDINGID, PICNAME, CREATETIME, PICSIZE) VALUES (?,?,?,?,?)");
        ps.setString(1, id);
        ps.setString(2, bId);
        ps.setString(3, name);
        ps.setString(4, time);
        ps.setString(5, size);

        ps.execute();
    }

    @Override
    public void updatePictureInfo(Connection conn, String id, Picture picture) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE HC_PICTURES SET PICNAME=?, PICTYPE=?, ORIGIN=?, DESCRIPTION=?," +
                "PICDATE=?, RELATEDDESIGNER=?, RELATEDORG=? WHERE ID = ?");
        ps.setString(1, picture.getName());
        ps.setString(2, picture.getType());
        ps.setString(3, picture.getOrigin());
        ps.setString(4, picture.getDesc());
        ps.setString(5, picture.getDate());
        ps.setString(6, picture.getRelative_designer());
        ps.setString(7, picture.getRelative_org());
        ps.setString(8, id);

        ps.execute();
    }

    @Override
    public ResultSet getAllVideo(Connection conn, String bId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_Videos WHERE BUILDINGID=?");
        ps.setString(1, bId);

        return ps.executeQuery();
    }

    @Override
    public ResultSet getVideo(Connection conn, String id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_Videos WHERE ID =?");
        ps.setString(1, id);

        return ps.executeQuery();
    }

    @Override
    public void insertVideoInfo(Connection conn, String id, String bId, String name, String time, String size) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HC_VIDEOS(ID, BUILDINGID, VIDEONAME, CREATETIME, VIDEOSIZE) VALUES (?,?,?,?,?)");
        ps.setString(1, id);
        ps.setString(2, bId);
        ps.setString(3, name);
        ps.setString(4, time);
        ps.setString(5, size);

        ps.execute();
    }

    @Override
    public void updateVideoInfo(Connection conn, String id, Video video) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE HC_VIDEOS SET VIDEONAME=?, DESCRIPTION=?, VIDEODATE=?, OWNER=?," +
                "KEYWORD=? WHERE ID = ?");
        ps.setString(1, video.getName());
        ps.setString(2, video.getDesc());
        ps.setString(3, video.getDate());
        ps.setString(4, video.getOwner());
        ps.setString(5, video.getKey_word());
        ps.setString(6, id);

        ps.execute();
    }

    @Override
    public ResultSet getAllDrawing(Connection conn, String bId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_DRAWINGS WHERE BUILDINGID=?");
        ps.setString(1, bId);

        return ps.executeQuery();
    }

    @Override
    public ResultSet getDrawing(Connection conn, String id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_DRAWINGS WHERE ID =?");
        ps.setString(1, id);

        return ps.executeQuery();
    }

    @Override
    public void insertDrawingInfo(Connection conn, String id, String bId, String name, String time, String size) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HC_DRAWINGS(ID, BUILDINGID, DRAWINGNAME, CREATETIME, DRAWINGSIZE) VALUES (?,?,?,?,?)");
        ps.setString(1, id);
        ps.setString(2, bId);
        ps.setString(3, name);
        ps.setString(4, time);
        ps.setString(5, size);

        ps.execute();
    }

    @Override
    public void updateDrawingInfo(Connection conn, String id, Drawing drawing) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE HC_DRAWINGS SET DRAWINGNAME=?, DESCRIPTION=?, OWNER=? WHERE ID = ?");
        ps.setString(1, drawing.getName());
        ps.setString(2, drawing.getDesc());
        ps.setString(3, drawing.getOwner());
        ps.setString(4, id);

        ps.execute();
    }

    @Override
    public ResultSet getAllDocument(Connection conn, String bId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_Documents WHERE BUILDINGID=?");
        ps.setString(1, bId);

        return ps.executeQuery();
    }

    @Override
    public ResultSet getDocument(Connection conn, String id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_Documents WHERE id = ?");
        ps.setString(1, id);

        return ps.executeQuery();
    }

    @Override
    public void insertDocumentInfo(Connection conn, String id, String bId, String name, String time, String size) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HC_Documents(ID, BUILDINGID, NAME, CREATETIME, DOCUMENTSIZE) VALUES (?,?,?,?,?)");
        ps.setString(1, id);
        ps.setString(2, bId);
        ps.setString(3, name);
        ps.setString(4, time);
        ps.setString(5, size);

        ps.execute();
    }

    @Override
    public void updateDocumentInfo(Connection conn, String id, Document document) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE HC_Documents SET NAME=?,ABSTRACT=?,AUTHOR=?, KEYWORD=?, " +
                "PUBLISHYEAR=?, SERIALNUMBER=? WHERE ID = ?");
        ps.setString(1, document.getName());
        ps.setString(2, document.getD_abstract());
        ps.setString(3, document.getAuthor());
        ps.setString(4, document.getKey_word());
        ps.setString(5, document.getDate());
        ps.setString(6, document.getSerial_number());
        ps.setString(7, id);

        ps.execute();
    }

    @Override
    public ResultSet test(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM TEST");

        return ps.executeQuery();
    }
}
