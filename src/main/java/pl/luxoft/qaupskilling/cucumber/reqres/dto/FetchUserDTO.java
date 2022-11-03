package pl.luxoft.qaupskilling.cucumber.reqres.dto;

import pl.luxoft.qaupskilling.cucumber.reqres.model.Support;
import pl.luxoft.qaupskilling.cucumber.reqres.model.User;

public class FetchUserDTO {

    private User data;
    private Support support;

    public FetchUserDTO() {
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
