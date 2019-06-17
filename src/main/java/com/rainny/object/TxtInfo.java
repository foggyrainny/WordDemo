package com.rainny.object;

/**
 * Created by rainny on 2019/6/14.
 */
public class TxtInfo {

    //txt文档名称
    private  String txtName;
    //存入数据库时间
    private String   readTime;
    //合计金额
    private String totalMoney;
    //合计税额
    private String totalTax;
    //价税合计
    private String  totalTM;
    //销货方名称
    private String sellerName;
    //开票时间
    private String  billTime;

    public String getBillTime() {
        return billTime;
    }

    public void setBillTime(String billTime) {
        this.billTime = billTime;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getTotalTM() {
        return totalTM;
    }

    public void setTotalTM(String totalTM) {
        this.totalTM = totalTM;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "TxtInfo{" +
                "txtName='" + txtName + '\'' +
                ", readTime='" + readTime + '\'' +
                ", totalMoney=" + totalMoney +
                ", totalTax=" + totalTax +
                ", totalTM=" + totalTM +
                ", sellerName='" + sellerName + '\'' +
                ", billTime='" + billTime + '\'' +
                '}';
    }
}
