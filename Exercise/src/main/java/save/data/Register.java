package save.data;
public class Register{
    String  logname="",
            backNews="请输入注册信息";
    public void setLogname(String logname){
        this.logname=logname;
    }
    public String getLogname(){
        return logname;
    }
    public void setBackNews(String backNews){
        this.backNews=backNews;
    }
    public String getBackNews(){
        return backNews;
    }
}
