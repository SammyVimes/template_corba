package com.eltech.study.app;

import com.eltech.study.service.ServiceHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 * Created by Семён on 26.12.2014.
 */
public class Client {

    public static void main(String args[]) {

        final ServiceAccessor serviceAccessor = new ServiceAccessor();

        serviceAccessor.start(args);
//        serviceAccessor.access("SEPPA").then(new Promise.Action<String, Promise<Void>>() {
//            @Override
//            public Promise<Void> action(String data, boolean success) {
//                System.out.println(data);
//                return serviceAccessor.access("PEPPA").then(new Promise.Action<String, Void>() {
//                    @Override
//                    public Void action(String data, boolean success) {
//                        if (data.equals("4pda")) {
//                            System.out.println("HOORAY");
//                        }
//                        return null;
//                    }
//                });
//            }
//        });

        System.out.println(serviceAccessor.accessWithoutVipendregh("SEPPA"));
        System.out.println(serviceAccessor.accessWithoutVipendregh("PEPPA"));

    }

}
