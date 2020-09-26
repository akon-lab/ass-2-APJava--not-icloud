package servlet;

import item.FileItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search extends HttpServlet {
    private final FileItem folder = new FileItem();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);


        List<String> Input1 = new ArrayList();
        for (File file : folder.getFolder().listFiles()) {
            String i=file.getName();
            Input1.add(i);
        }
        System.out.println(Input1);


        String REGEX = req.getParameter("textToFind");
        String INPUT= Input1.toString();
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);

        req.setAttribute("result",matcher.find());
        req.getRequestDispatcher("/jsp/result.jsp").forward(req,resp);
    }
}
