package com.example.demo.util.two.log;

public interface RespCodeable {

    void setSysCode(RespCode syscode);

    void setLogicCode(RespCode logicCode);

    RespCode getSysCode();

    RespCode getLogicCode();

    void setSync(boolean sync);

    boolean isSync();

    String respString();

}
