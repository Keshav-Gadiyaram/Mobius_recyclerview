package com.keshav.mobius.model;

import java.util.ArrayList;
import java.util.List;

public class VoucherList {
    ArrayList<Voucher> voucherList;

    public VoucherList(ArrayList<Voucher> voucherList) {
        this.voucherList = voucherList;
    }

    public ArrayList<Voucher> getVoucherList() {
        return voucherList;
    }

    public void setVoucherList(ArrayList<Voucher> voucherList) {
        this.voucherList = voucherList;
    }
}
