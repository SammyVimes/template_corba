package com.eltech.study.app;

import com.eltech.study.service.Service;
import com.eltech.study.service.ServiceHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 * Created by Семён on 26.12.2014.
 */
public class ServiceAccessor {

    private Service serviceImpl;

    public void start(final String[] args) {

        try{
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "Service";
            serviceImpl = ServiceHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtained a handle on server object");
        } catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
    }

    public Promise<String> access(final String inParam) {
        return Promise.<String>run(new Promise.PromiseRunnable<String>() {
            @Override
            public void run(Promise<String>.Resolver resolver) {
                String response = serviceImpl.doTheThing(inParam);
                resolver.resolve(response);
            }
        }, true);
    }

    public String accessWithoutVipendregh(final String inParam) {
        return serviceImpl.doTheThing(inParam);
    }

}
