package pl.luxoft.qaupskilling.cucumber.reqres.dto;

import pl.luxoft.qaupskilling.cucumber.reqres.model.Support;
import pl.luxoft.qaupskilling.cucumber.reqres.model.User;

import java.util.List;

public class FetchUsersDTO {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data;

    private Support support;

    public FetchUsersDTO() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
