package com.controllers;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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
import java.util.List;

@WebServlet("/UploadController")
public class UploadController extends HttpServlet {
    //    定义上传目录
    static final String UPLOAD_DIRECTORY = "upload";
    //    单次上传文件的最大限制
    static final int MEMORY_THRESHOLD = 1024 * 1024 * 40;//40M
    static final int MAX_FILE_SIZE = 1024 * 1024 * 40;//单个文件最大40m
    static final int MAX_REQUEST_SIZE = 1024 * 1024 * 80;//单次请求能够上传最大的文件大小

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      监测请求类型
        if (!ServletFileUpload.isMultipartContent(req)) {
            PrintWriter out = resp.getWriter();
            out.println("表单的类型必须是  enctype=multipart/form-data");
            out.flush();
            return;
        }

//        配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
//        设置内存临界值，超过该值将产生临时文件并存于临时目录
        factory.setSizeThreshold(MEMORY_THRESHOLD);
//        设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
//        创建上传文件的对象
        ServletFileUpload upload = new ServletFileUpload(factory);
//        设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
//        设置最大请求值（表单数据和文件本身）
        upload.setSizeMax(MAX_REQUEST_SIZE);
//        设置编码
        upload.setHeaderEncoding("UTF-8");
//        上传的文件会在站点的根目录下
        String uploadPath = req.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
//        文件不存在就创建该目录
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            List<FileItem> formItems = upload.parseRequest(req);
//            请求中包含了文件
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
//                    处理非文件上传字段
                    if (!item.isFormField()) {
//                        文件名称
                        String fileName = new File(item.getName()).getName();
//                        构造完整的文件路径
                        String filePath = uploadPath + File.separator + fileName;
//                        输出文件路径
                        System.out.println(filePath);
//                        创建文件对象
                        File storeFile = new File(filePath);
//                        文件写道该文件中
                        item.write(storeFile);
                        req.setAttribute("msg", "文件上传成功");
                    }

                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getServletContext().getRequestDispatcher("/pages/msg.jsp").forward(req, resp);

    }
}
