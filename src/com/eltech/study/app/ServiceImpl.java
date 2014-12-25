package com.eltech.study.app;

import com.eltech.study.service.ServicePOA;
import org.omg.CORBA.ORB;

/**
 * Created by Семён on 26.12.2014.
 */
public class ServiceImpl extends ServicePOA {

    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }

    @Override
    public String doTheThing(String inParam) {
        if (inParam.equals("SEPPA")) {
            return "ASDF";
        } else if (inParam.equals("PEPPA")) {
            return "4pda";
        }
        return "";
    }

    @Override
    public void shutdown() {
        orb.shutdown(true);
    }

}
