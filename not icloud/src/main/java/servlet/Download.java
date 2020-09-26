package servlet;

import item.FileItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Download extends HttpServlet {
    private final FileItem folder = new FileItem();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String filename = request.getParameter("name");
        String filepath = folder.getPath();

        response.setContentType("APPLICATION/OCTET-STREAM");
        //APPLICATION/OCTET-STREAM обозначает двоичные данные.
        // Это может быть более точным, указав фактический тип файла.
        // Для изображений это могло быть image/png. Если браузеру известен
        // точный тип файла, он может показать файл напрямую.
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
//Это говорит: «Даже не пытайтесь показать файл, просто сохраните файл». Также предлагается имя файла.

        //use inline if you want to view the content in browser, helpful for pdf file
        //response.setHeader("Content-Disposition","inline; filename=\"" + filename + "\"");
        FileInputStream fileInputStream = new FileInputStream(filepath + filename);

        int i;
        while ((i = fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }

}
