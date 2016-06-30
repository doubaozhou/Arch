package com.arch.servlet;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Picture;
import com.arch.entity.Result;
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
 * Created by I331314 on 2016/6/10.
 *
 * @author zhou
 */
@WebServlet(name = "PicInfoSaveServlet")
public class PicInfoSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("pic_name");
        String type = request.getParameter("pic_type");
        String origin = request.getParameter("pic_origin");
        String date = request.getParameter("pic_date");
        String pic_relative_designer = request.getParameter("pic_relative_designer");
        String pic_relative_com = request.getParameter("pic_relative_com");
        String pic_desc = request.getParameter("pic_desc");

        Picture picture = new Picture(name, type, origin, pic_desc, date, pic_relative_designer, pic_relative_com);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        Result rst = new Result();

        Dao userDao = new DaoImpl();
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            userDao.updatePictureInfo(conn, id, picture);
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
