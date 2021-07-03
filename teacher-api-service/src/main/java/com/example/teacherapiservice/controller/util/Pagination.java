package com.example.teacherapiservice.controller.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pagination {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("total_pages")
    private Long totalPages;
    @JsonProperty("total_counts")
    private Long totalCounts;

    public Pagination() {
        this(1, 15, 0L, 0L);
    }

    public Pagination(Integer page, Integer size, Long totalPages, Long totalCounts) {
        this.page = page;
        this.size = size;
        this.totalPages = totalPages;
        this.totalCounts = totalCounts;
    }

    public Long getTotalPages() {
        return (long) Math.ceil((double) this.totalCounts / size);
    }

    public Integer getOffSet(){
        return  this.page*this.size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Long totalCounts) {
        this.totalCounts = totalCounts;
    }


}
