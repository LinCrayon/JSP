package handle.data;


import save.data.ExpressWish;
import save.data.ExpressWish_Bean;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
/**
 * @author linshengqian
 */
public class ExpressWish_Servlet extends HttpServlet{
   int index;
   @Override
   public void init(ServletConfig config) throws ServletException{
       super.init(config);
   }
   synchronized long getIndex() {  //synchronized���εķ���
       index = index+1;
       return index;
   }
   @Override
   public void service(HttpServletRequest request, HttpServletResponse response)
                       throws ServletException,IOException{
       request.setCharacterEncoding("utf-8");
       ExpressWish_Bean wishWallBean = null; //wishWallBean��ű���ǽ���ݡ�
       ServletContext application = getServletContext();
       wishWallBean = (ExpressWish_Bean)application.getAttribute("wishWallBean");
       if(wishWallBean == null ){//wishWallBean�����ھʹ���wishWallBean��
           wishWallBean = new ExpressWish_Bean();
           application.setAttribute("wishWallBean",wishWallBean);//appication bean��
       }
       String peopleName = request.getParameter("peopleName");//�����ߡ�
       String title = request.getParameter("title"); //���⡣
       String content = request.getParameter("contents");//�������ݡ�
       ExpressWish wish = new ExpressWish();
       if(peopleName.length()==0||title.length()==0||content.length()==0){
            response.sendRedirect("example7_2.jsp");
            return;
       }
       wish.setPeopleName(peopleName);
       wish.setTitle(title);
       wish.setContent(content);                      
       LocalDateTime dateTime = LocalDateTime.now();  
       String str = dateTime.toString();
       String time =str.substring(0,str.lastIndexOf("."));//��Ҫ���롣
       wish.setDateTime(time);
       long number = getIndex();
       wish.setId(""+number);
       wishWallBean.addExpressWish(""+number,wish);//����һ�����ס�
       response.sendRedirect("example7_2_show.jsp"); //��ʾ����ǽ��
   }
} 