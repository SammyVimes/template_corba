package com.eltech.study.service;


/**
* MyApp/ServicePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/����/IdeaProjects/tcorba/src/com/eltech/study/app.idl
* 26 ������� 2014 �. 0:52:51 MSK
*/

public abstract class ServicePOA extends org.omg.PortableServer.Servant
 implements ServiceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("doTheThing", new java.lang.Integer (0));
    _methods.put ("shutdown", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // MyApp/Service/doTheThing
       {
         String inParam = in.read_string ();
         String $result = null;
         $result = this.doTheThing (inParam);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // MyApp/Service/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:MyApp/Service:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Service _this() 
  {
    return ServiceHelper.narrow(
    super._this_object());
  }

  public Service _this(org.omg.CORBA.ORB orb) 
  {
    return ServiceHelper.narrow(
    super._this_object(orb));
  }


} // class ServicePOA
