package handle.data;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
public class Example9_2_Servlet extends HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        String fileContent="";
        request.setCharacterEncoding("utf-8");
        String filePath=request.getParameter("filePath");
        String fileName=request.getParameter("fileName");
        String isUTF=request.getParameter("R");
        if(filePath==null||fileName==null) {
            return;
        }
        if(fileName.length()==0||fileName.length()==0) {
            return;
        }
        try{  File f=new File(filePath,fileName);
            RandomAccessFile randomAccess = new RandomAccessFile(f,"r");
            String s=null;
            StringBuffer stringbuffer=new StringBuffer();
            while ((s=randomAccess.readLine())!=null){
                byte b[] = s.getBytes("iso-8859-1");
                if(isUTF.contains("yes")) {
                    stringbuffer.append("\n"+new String(b,"utf-8"));
                } else {
                    stringbuffer.append("\n"+new String(b));
                }
            }
            fileContent=new String(stringbuffer);
        }
        catch(Exception exp){
            fileContent ="读取失败"+exp.toString();
        }
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print(fileContent);
    }
}
