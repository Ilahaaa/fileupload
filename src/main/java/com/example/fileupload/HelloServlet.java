package com.example.fileupload;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/fileuploadservlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,            // file diskde saxlanilacagi byte size
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class HelloServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();                                         // clientden file adi get
        if (fileName == null || fileName.equals("")) {
            response.getWriter().print("Choose file");

        } else {
            for (Part part : request.getParts()) {
                part.write("C:\\test\\" + fileName);                                                      // diske yuklemek
            }
            response.getWriter().print("Successfully downloaded");

        }


    }

}