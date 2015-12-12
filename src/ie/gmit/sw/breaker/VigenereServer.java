package ie.gmit.sw.breaker;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class VigenereServer{
   public static void main(String args[]) {
    	try{
			ORB orb = ORB.init(args, null); //Connect to the ORB using args

			//Get a reference to RootPOA & activate the POAManager
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			//Create a remote object and register it with the ORB
			CORBAVigenerBreakerImpl vigenereImpl = new CORBAVigenerBreakerImpl();
			vigenereImpl.setORB(orb);

			//Get the object reference for the remote object
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(vigenereImpl);
			CORBAVigenereBreaker href = CORBAVigenereBreakerHelper.narrow(ref);

			//Get a handle on the CORBA Naming Service (same idea as the RMIRegistry)
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			// Use NamingContextExt which is part of the Interoperable Naming Service (INS) specification.
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			//Bindthe Object Reference to the Naming Service
			String name = "vigenere-service";
			NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, href);

			System.out.println("VigenereService ready and waiting ...");

			//Wait for invocations from clients
			orb.run();
		}catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
   }
}
