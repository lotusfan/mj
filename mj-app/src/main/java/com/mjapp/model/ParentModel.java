package com.mjapp.model;

import java.util.List;

public class ParentModel {
    private Integer skipNum;
    private Integer pageNum;
    private Integer pages;
    private String sequence1;
    private String sequence1Type;
    private String sequence2;
    private String sequence2Type;
    private String maxParameter;
    private String maxValue;
    private String minParameter;
    private String minValue;
    private List<Integer> ids;

    public Integer getSkipNum() {
        return skipNum;
    }

    public void setSkipNum(Integer skipNum) {
        this.skipNum = skipNum;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }


    public String getSequence1() {
        return sequence1;
    }

    public void setSequence1(String sequence1) {
        this.sequence1 = sequence1;
    }

    public String getSequence2() {
        return sequence2;
    }

    public void setSequence2(String sequence2) {
        this.sequence2 = sequence2;
    }

    public String getMaxParameter() {
        return maxParameter;
    }

    public void setMaxParameter(String maxParameter) {
        this.maxParameter = maxParameter;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getMinParameter() {
        return minParameter;
    }

    public void setMinParameter(String minParameter) {
        this.minParameter = minParameter;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getSequence1Type() {
        return sequence1Type;
    }

    public void setSequence1Type(String sequence1Type) {
        this.sequence1Type = sequence1Type;
    }

    public String getSequence2Type() {
        return sequence2Type;
    }

    public void setSequence2Type(String sequence2Type) {
        this.sequence2Type = sequence2Type;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "ParentModel{" +
                "skipNum=" + skipNum +
                ", pageNum=" + pageNum +
                ", sequence1='" + sequence1 + '\'' +
                ", sequence1Type='" + sequence1Type + '\'' +
                ", sequence2='" + sequence2 + '\'' +
                ", sequence2Type='" + sequence2Type + '\'' +
                ", maxParameter='" + maxParameter + '\'' +
                ", maxValue='" + maxValue + '\'' +
                ", minParameter='" + minParameter + '\'' +
                ", minValue='" + minValue + '\'' +
                '}';
    }
}
