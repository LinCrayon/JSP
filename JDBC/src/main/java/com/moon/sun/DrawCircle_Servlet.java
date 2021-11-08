package com.moon.sun;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.geom.*;
import javax.imageio.ImageIO;
public class DrawCircle_Servlet extends HttpServlet{
    HttpServletRequest request;
    HttpServletResponse response;
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
    @Override
    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        String center = request.getParameter("center");
        String radius = request.getParameter("radius");
        if(center == null||center.length()==0){
            response.sendRedirect("inputCircle.jsp");
            return;
        }
        String []str =center.split("[,，]+");
        double x=0,y=0,r=0;
        try{ x = Double.parseDouble(str[0]);
            y = Double.parseDouble(str[1]);
            r = Double.parseDouble(radius);
        }
        catch(NumberFormatException exp){
            response.sendRedirect("inputCircle.jsp");
            return;
        }
        response.setContentType("image/jpeg");
        Ellipse2D ellipse= new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        BufferedImage image = getImage(ellipse);
        OutputStream outClient= response.getOutputStream();

        boolean boo =ImageIO.write(image,"jpeg",outClient);
    }
    BufferedImage getImage(Shape shape){
        int width=1000, height=800;
        BufferedImage image =
                new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, width, height);
        Graphics2D g_2d=(Graphics2D)g;
        g_2d.setColor(Color.blue);
        g_2d.draw(shape);
        return image;
    }
}