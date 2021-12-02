package save.data;
/**
 * @author linshengqian
 */
public class Record_Bean{
    String []columnName ;
    String [][] tableRecord=null;
    int pageSize=4;
    int totalPages=1;
    int currentPage =1   ;
    int totalRecords ;
    public void setTableRecord(String [][] s){
        tableRecord=s;
    }
    public String [][] getTableRecord(){
        return tableRecord;
    }
    public void setColumnName(String [] s) {
        columnName = s;
    }
    public String [] getColumnName() {
        return columnName;
    }
    public void setPageSize(int size){
        pageSize=size;
    }
    public int getPageSize(){
        return pageSize;
    }
    public int getTotalPages(){
        return totalPages;
    }
    public void setTotalPages(int n){
        totalPages=n;
    }
    public void setCurrentPage(int n){
        currentPage =n;
    }
    public int getCurrentPage(){
        return currentPage ;
    }
    public int getTotalRecords(){
        totalRecords = tableRecord.length;
        return totalRecords ;
    }
}
