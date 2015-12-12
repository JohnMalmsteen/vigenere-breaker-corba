package ie.gmit.sw.breaker;

import org.omg.CORBA.ORB;

public class CORBAVigenerBreakerImpl extends CORBAVigenereBreakerPOA {
	private ORB orb;
	private KeyEnumerator breaker;

	public CORBAVigenerBreakerImpl() throws Exception{
		breaker = new KeyEnumerator();
	}

	public void setORB(ORB orb_val){
		orb = orb_val;
	}
	@Override
	public String decrypt(String cypherText, int maxKeylength) {
		return breaker.crackCypher(cypherText, maxKeylength);
	}

}
