package ie.gmit.sw.breaker;

/**
* ie/gmit/sw/breaker/CORBAVigenereBreakerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from VigenereBreaker.idl
* Saturday, December 12, 2015 5:03:44 PM GMT
*/

public final class CORBAVigenereBreakerHolder implements org.omg.CORBA.portable.Streamable
{
  public ie.gmit.sw.breaker.CORBAVigenereBreaker value = null;

  public CORBAVigenereBreakerHolder ()
  {
  }

  public CORBAVigenereBreakerHolder (ie.gmit.sw.breaker.CORBAVigenereBreaker initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ie.gmit.sw.breaker.CORBAVigenereBreakerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ie.gmit.sw.breaker.CORBAVigenereBreakerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ie.gmit.sw.breaker.CORBAVigenereBreakerHelper.type ();
  }

}
