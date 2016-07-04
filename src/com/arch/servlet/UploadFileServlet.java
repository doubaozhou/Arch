package com.arch.servlet;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Result;
import com.arch.util.ConnectionFactory;
import com.arch.util.TimeUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by zhou on 2015/11/25.
 *
 * @author zhou
 */
@WebServlet(name = "UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String bId = request.getParameter("bId");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        Result rst = new Result();

        Dao userDao = new DaoImpl();
        Connection conn;
        String size = "";
        String name = "";

        //判断提交过来的表单是否为文件上传菜单
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart && id != null) {
            //构造一个文件上传处理对象
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            Iterator items;
            try {
                //解析表单中提交的所有文件内容
                items = upload.parseRequest(request).iterator();
                while (items.hasNext()) {
                    FileItem item = (FileItem) items.next();
                    if (!item.isFormField()) {
                        //取出上传文件的文件全称
                        name = item.getName();
                        //文件大小
                        size = String.valueOf(item.getSize()) + "B";
                        //取得上传文件以后的存储路径
                        String filename = name.substring(name.lastIndexOf("\\") + 1, name.length());
                        //上传文件以后的存储路径
                        String realPath = ConnectionFactory.uploadPath + File.separatorChar + id;
                        File f = new File(realPath);
                        if (!f.exists() && !f.isDirectory()) {
                            f.mkdir();
                        }

                        String path = realPath + File.separatorChar + filename;

                        //上传文件
                        File uploadFile = new File(path);
                        item.write(uploadFile);
                    }
                }

                rst.setCode("0");
                rst.setMsg("保存成功！");
                rst.setResult("success");

                //insert item into DB
                conn = ConnectionFactory.getConnection();
                if (type.equalsIgnoreCase("picFile")) {
                    userDao.insertPictureInfo(conn, id, bId, name, TimeUtils.getTime(), size);
                } else if (type.equalsIgnoreCase("videoFile")) {
                    userDao.insertVideoInfo(conn, id, bId , name, TimeUtils.getTime(), size);
                } else if (type.equalsIgnoreCase("documentFile")) {

                } else if (type.equalsIgnoreCase("drawingFile")) {

                }

                out.append(rst.toJson().toString());
            } catch (Exception e) {
                e.printStackTrace();
                rst.setCode("-1");
                rst.setMsg("保存失败！");
                rst.setResult("");
                out.append(rst.toJson().toString());

            }
        } else {
            rst.setCode("-1");
            rst.setMsg("保存失败！");
            rst.setResult("");
            out.append(rst.toJson().toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
