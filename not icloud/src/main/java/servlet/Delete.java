package servlet;

import item.FileItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Delete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        PrintWriter out = resp.getWriter();
        FileItem folder = new FileItem();
        //String name="adil.jpg";
        String name = req.getParameter("name");

        try {
            File f = new File(folder.getPath() + name);           //file to be delete
            if (f.delete())                      //returns Boolean value
            {
                out.print("<script>\n" +
                        "            alert(\"" + f.getName() + " \" deleted\");\n" +
                        "        }\n" +
                        "</script>");
            } else {
                out.print("<script>\n" +
                        "            alert(failed);\n" +
                        "        }\n" +
                        "</script>");
            }
            req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }

        out.print("<script>\n" +
                "                function myFunction() {\n" +
                "            alert(\"do you really want to delete the filet?\");\n" +
                "        }\n" +
                "</script>");


    }
}