package com.arch.servlet;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Building;
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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhou on 2016/5/21.
 *
 * @author zhou
 */
@WebServlet(name = "BaseInfoSaveServlet")
public class BaseInfoSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("b_name");
        String designer = request.getParameter("b_designer");
        String city = request.getParameter("b_city");
        String date = request.getParameter("b_date");
        String address = request.getParameter("b_address");
        String company = request.getParameter("b_company");
        String type = request.getParameter("b_type");
        String structure = request.getParameter("b_structure");
        String style = request.getParameter("b_style");
        String postcode = request.getParameter("b_postcode");
        String desc = request.getParameter("b_desc");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String c_date = format.format(new Date());

        Building building = new Building(name, city, address, designer, date, company, desc, type, style, structure, postcode, c_date);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        Result rst = new Result();

        Dao userDao = new DaoImpl();
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            userDao.setBuildingBaseInfo(conn, building);
            rst.setCode("0");
            rst.setMsg("录入成功！");
            rst.setResult("");
            out.append(rst.toJson().toString());
        } catch (Exception e) {
            e.printStackTrace();
            rst.setCode("-1");
            rst.setMsg("录入失败！");
            rst.setResult("");
            out.append(rst.toJson().toString());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
