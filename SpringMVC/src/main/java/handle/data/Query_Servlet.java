package handle.data;
import save.data.Record_Bean;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * @author linshengqian
 */
public class Query_Servlet extends HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        try {  Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception ignored){}
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        String dataBase= request.getParameter("dataBase");
        String tableName= request.getParameter("tableName");
        String user= request.getParameter("user");
        String password= request.getParameter("password");
        boolean boo =( dataBase==null||dataBase.length()==0);
        boo = boo||( tableName==null||tableName.length()==0);
        boo = boo||( user==null||user.length()==0);
        if(boo) {
            response.sendRedirect("example8_8_input.jsp");
            return;
        }
        HttpSession session=request.getSession(true);
        Connection con=null;
        Record_Bean recordBean=null;
        try{
            recordBean=(Record_Bean)session.getAttribute("recordBean");
            if(recordBean==null){
                recordBean=new Record_Bean();
                session.setAttribute("recordBean",recordBean);
            }
        }
        catch(Exception ignored){}
        String url = "jdbc:mysql://121.43.177.234:3636/"+dataBase+"?"+
                "useSSL=true" +
                "&characterEnconding=utf-8" +
                "&serverTimezone=Asia/Shanghai";
        try{
            con=DriverManager.getConnection(url,user,password);
            Statement sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,                                                                                            ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=sql.executeQuery("SELECT * FROM "+tableName);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            String []columnName = new String[columnCount];
            for(int i=0;i<columnName.length;i++) {
                columnName[i] = metaData.getColumnName(i+1);
            }
            recordBean.setColumnName(columnName);
            rs.last();
            int rows=rs.getRow();
            String [][] tableRecord=recordBean.getTableRecord();
            tableRecord = new String[rows][columnCount];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                for(int k=0;k<columnCount;k++) {
                    tableRecord[i][k] = rs.getString(k+1);
                }
                i++;
            }
            recordBean.setTableRecord(tableRecord);
            con.close();
            response.sendRedirect("example8_8_show.jsp");
        }
        catch(SQLException e){
            response.getWriter().print("<h2>"+e);
            System.out.println(e);
        }
    }
}
