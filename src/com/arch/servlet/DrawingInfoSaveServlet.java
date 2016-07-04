package com.arch.servlet;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Drawing;
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
@WebServlet(name = "DrawingInfoSaveServlet")
public class DrawingInfoSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("dr_name");
        String owner = request.getParameter("dr_owner");
        String desc = request.getParameter("dr_desc");


        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        Result rst = new Result();

        Drawing drawing = new Drawing(name, desc, owner);

        Dao userDao = new DaoImpl();
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            userDao.updateDrawingInfo(conn, id, drawing);
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
