package handle.data;

import save.data.EnglishBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class ReadFile_Servlet extends HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws                                               ServletException,IOException{
        EnglishBean fileBean=new EnglishBean();  //创建bean对象。
        request.setAttribute("english",fileBean);
        String fileContent="";
        request.setCharacterEncoding("utf-8");
        String filePath=request.getParameter("filePath");
        String fileName=request.getParameter("fileName");
        if(filePath==null||fileName==null) {
            return;
        }
        if(fileName.length() == 0) {
            return;
        }
        fileBean.setFileName(fileName);
        String audioFileName =
                fileName.substring(0,fileName.lastIndexOf("."))+".mp3";
        fileBean.setFileAudio(audioFileName);
        try{  File f=new File(filePath,fileName);
            RandomAccessFile randomAccess = new RandomAccessFile(f,"r");
            String s=null;
            StringBuilder stringbuffer=new StringBuilder();
            while ((s=randomAccess.readLine())!=null){
                byte[] b = s.getBytes(StandardCharsets.ISO_8859_1);
                stringbuffer.append("\n").append(new String(b));
            }
            fileContent=new String(stringbuffer);
            fileBean.setFileContent(fileContent);
        }
        catch(Exception exp){
            fileContent ="读取失败"+exp.toString();
        }
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("studyEnglish.jsp");
        dispatcher.forward(request, response);
    }
}
