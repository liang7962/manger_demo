package com.example.demo.router;

import com.example.demo.dto.page.Page;

import java.util.List;

public class ResponseTransBody {

    private Page page;
    private List<Object> resModel;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Object> getResModel() {
        return resModel;
    }

    public void setResModel(List<Object> resModel) {
        this.resModel = resModel;
    }
}
