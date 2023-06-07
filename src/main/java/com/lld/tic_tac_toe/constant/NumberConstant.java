package com.lld.tic_tac_toe.constant;

public enum NumberConstant {
    THREE(3);

    private int name;

    private NumberConstant(int name)
    {
        this.name = name;
    }

    public int getName()
    {
        return name;
    }



}
