package ie.gmit.sw.breaker;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class VigenereClient{
   public static void main(String args[]){
		CORBAVigenereBreaker vigenereImpl = null;
		try{
			ORB orb = ORB.init(args, null); //Connect to the ORB using args

			//Get a handle on the CORBA Naming Service
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

			//Use NamingContextExt instead of NamingContext. This is part of the Interoperable naming Service.
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			//Resolve the Object Reference in Naming
			String name = "vigenere-service";
			vigenereImpl = CORBAVigenereBreakerHelper.narrow(ncRef.resolve_str(name));  //We also downcast the Naming.lookup in RMI

			System.out.println("Obtained a handle on server object: " + vigenereImpl);
			System.out.println(vigenereImpl.decrypt("String cypherText with some othere stuff added", 4)); //Make the remote method invocation
		}catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
   }
}
