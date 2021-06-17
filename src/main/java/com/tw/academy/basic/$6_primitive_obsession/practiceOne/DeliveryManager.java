package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    Address from;
    Address to;

    public DeliveryManager(Address from, Address to) {
        this.from = from;
        this.to = to;
    }

    public DeliverCenter allocate(){
        if (getProvince(to.getAddress()).equals(getProvince(from.getAddress())) && getCity(to.getAddress()).equals(getCity(from.getAddress()))){
            return DeliverCenter.LOCAL;
        }
        if (getProvince(to.getAddress()).equals(getProvince(from.getAddress()))) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

    private String getCity(String address) {
        return address.substring(address.indexOf("省") + 1, address.indexOf("市"));
    }

    private String getProvince(String address) {
        return address.substring(0, address.indexOf("省"));
    }
}
