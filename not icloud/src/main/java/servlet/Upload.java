package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,//2mb
        maxFileSize = 1024 * 1024 * 10,//10mb
        maxRequestSize = 1024 * 1024 * 50//50 mb
)
public class Upload extends HttpServlet {
    private  final item.FileItem fileItem=new item.FileItem();
    private final String UPLOAD_DIRECTORY = fileItem.getPath();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
                //File uploaded successfully
                request.setAttribute("message", "");
                out.println("alert(File Uploaded Successfully)");

            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        }else{
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }

        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);

    }

}
