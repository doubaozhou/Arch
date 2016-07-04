package com.arch.servlet;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Picture;
import com.arch.entity.Result;
import com.arch.entity.Video;
import com.arch.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * Created by I331314 on 2016/6/13.
 *
 * @author zhou
 */
@WebServlet(name = "VideoInfoSaveServlet")
public class VideoInfoSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("video_name");
        String date = request.getParameter("video_date");
        String owner = request.getParameter("video_owner");
        String kword = request.getParameter("video_keyword");
        String video_desc = request.getParameter("video_desc");

        Video video = new Video(name, date, owner, kword, video_desc);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        Result rst = new Result();

        Dao userDao = new DaoImpl();
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            userDao.updateVideoInfo(conn, id, video);
            rst.success();
            out.append(rst.toJson().toString());
        } catch (Exception e) {
            e.printStackTrace();
            rst.error();
            out.append(rst.toJson().toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
