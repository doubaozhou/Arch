package com.arch.servlet;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Document;
import com.arch.entity.Drawing;
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
 * Created by I331314 on 2016/6/13.
 *
 * @author zhou
 */
@WebServlet(name = "DocumentInfoSaveServlet")
public class DocumentInfoSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("doc_name");
        String author = request.getParameter("doc_author");
        String kword = request.getParameter("doc_kword");
        String abs = request.getParameter("doc_abs");
        String date = request.getParameter("doc_date");
        String number = request.getParameter("doc_no");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        Result rst = new Result();

        Document document = new Document(name, author, kword, abs, date, number);

        Dao userDao = new DaoImpl();
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            userDao.updateDocumentInfo(conn, id, document);
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
