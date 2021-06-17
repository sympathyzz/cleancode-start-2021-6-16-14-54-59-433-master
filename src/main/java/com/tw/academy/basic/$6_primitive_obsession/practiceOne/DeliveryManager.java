package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    Address from;
    Address to;

    public DeliveryManager(Address from, Address to) {
        this.from = from;
        this.to = to;
    }

    public DeliverCenter allocate(){
        if (to.getProvince().equals(from.getProvince()) && to.getCity().equals(from.getCity())){
            return DeliverCenter.LOCAL;
        }
        if (to.getProvince().equals(from.getProvince())) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }


}
