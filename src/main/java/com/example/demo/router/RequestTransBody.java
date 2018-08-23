package com.example.demo.router;

import com.example.demo.dto.page.Page;

public class RequestTransBody {

    private Page page;
    private Object reqModel;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Object getReqModel() {
        return reqModel;
    }

    public void setReqModel(Object reqModel) {
        this.reqModel = reqModel;
    }
}
