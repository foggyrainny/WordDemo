package com.rainny.object;

/**
 * Created by rainy on 2019/7/4.
 */
public class Data {

    private  String miRNA_ID;

    private  String read_count;

    private  String miRNA_mapped;

    private  String cross_mapped;

    public String getMiRNA_ID() {
        return miRNA_ID;
    }

    public void setMiRNA_ID(String miRNA_ID) {
        this.miRNA_ID = miRNA_ID;
    }

    public String getRead_count() {
        return read_count;
    }

    public void setRead_count(String read_count) {
        this.read_count = read_count;
    }

    public String getMiRNA_mapped() {
        return miRNA_mapped;
    }

    public void setMiRNA_mapped(String miRNA_mapped) {
        this.miRNA_mapped = miRNA_mapped;
    }

    public String getCross_mapped() {
        return cross_mapped;
    }

    public void setCross_mapped(String cross_mapped) {
        this.cross_mapped = cross_mapped;
    }

    @Override
    public String toString() {
        return "Data{" +
                "miRNA_ID='" + miRNA_ID + '\'' +
                ", read_count='" + read_count + '\'' +
                ", miRNA_mapped='" + miRNA_mapped + '\'' +
                ", cross_mapped='" + cross_mapped + '\'' +
                '}';
    }
}
