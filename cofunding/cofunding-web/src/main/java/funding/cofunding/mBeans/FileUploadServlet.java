package funding.cofunding.mBeans;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.cofunding.services.ProjectServicesLocal;


@WebServlet("FileServlet")
public class FileUploadServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private final int ARBITARY_SIZE = 1048;

private ProjectServicesLocal projectServicesLocal;

protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
  throws ServletException, IOException {
 

    int id =Integer.parseInt(req.getParameter("id"));

    byte[] fich = projectServicesLocal.loadFile(id);
    resp.setContentType("text/pdf");
    ServletOutputStream outputStream = resp.getOutputStream();
    outputStream.write(fich);
    outputStream.close();
	
//    resp.setContentType("text/plain");
//    resp.setHeader("Content-disposition", "attachment; filename=sample.txt");
//
//    try(InputStream in = req.getServletContext().getResourceAsStream("/WEB-INF/sample.txt");
//      OutputStream out = resp.getOutputStream()) {
//
//    	
//     
//        int numBytesRead;
//        while ((numBytesRead = in.read(fich)) > 0) {
//            out.write(fich, 0, numBytesRead);
//        }
//    }
}
}
