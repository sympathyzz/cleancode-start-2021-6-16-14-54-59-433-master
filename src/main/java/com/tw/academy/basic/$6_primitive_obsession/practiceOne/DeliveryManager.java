package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    Address from;
    Address to;

    public DeliveryManager(Address from, Address to) {
        this.from = from;
        this.to = to;
    }

    public DeliverCenter allocate(){
        boolean isLocal=to.getProvince().equals(from.getProvince()) && to.getCity().equals(from.getCity());
        boolean isProvince=to.getProvince().equals(from.getProvince());
        if (isLocal){
            return DeliverCenter.LOCAL;
        }
        if (isProvince) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }


}
