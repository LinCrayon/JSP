package save.data;
public class Series_Bean{
    double firstItem;
    double var;
    int number;
    double sum;
    String name="等差/等比";
    public void setFirstItem(double a){
        firstItem=a;
    }
    public double getFirstItem(){
        return firstItem;
    }
    public void setVar(double b){
        var=b;
    }
    public double getVar(){
        return var;
    }
    public void setNumber(int n){
        number=n;
    }
    public double getNumber(){
        return number;
    }
    public void setSum(double s){
        sum=s;
    }
    public double getSum(){
        return sum;
    }
    public void setName(String na){
        name=na;
    }
    public String getName(){
        return name;
    }
}
