package positronic.satisfiability.naturalnumbertable;

import java.util.ArrayList;

import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class NaturalNumberTable2 implements INaturalNumberTable2
{
	/**
   * A static integer which records the number of <tt>NaturalNumberTable</tt>'s 
   * created without specifying a name.
   */
  private static int nNT2Count;
	private ArrayList<INaturalNumber> abscissa;
	private ArrayList<INaturalNumber> entry;
	private String name;
	private ArrayList<INaturalNumber> ordinate;
	
	public NaturalNumberTable2(int entries) throws Exception
	{
		this("NaturalNumberTable2$"+ nNT2Count++,entries);
	}
	
	public NaturalNumberTable2(String name, int entries) throws Exception
	{
		this.name=name;
		this.abscissa=new ArrayList<INaturalNumber>(entries);
		this.ordinate=new ArrayList<INaturalNumber>(entries);
		this.entry=new ArrayList<INaturalNumber>(entries);
		for(int i=0;i<entries;i++)
		{	
			this.abscissa.add(null);
			this.setRow(i,new NaturalNumber(name+"_abscissa$"+i));
			this.ordinate.add(null);
			this.setColumn(i,new NaturalNumber(name+"_ordinate$"+i));
			this.entry.add(null);
			this.setEntry(i,new NaturalNumber(name+"_entry$"+i));
		}
	}
	
	@Override
	public INaturalNumber getColumn(int i)
	{
		return this.abscissa.get(i);
	}

	public INaturalNumber[] getAbscissaArray()
	{
		return this.abscissa.toArray(new INaturalNumber[0]);
	}

	@Override
	public INaturalNumber getEntry(int i)
	{
		return this.entry.get(i);
	}

	public INaturalNumber[] getEntryArray()
	{
		return this.entry.toArray(new INaturalNumber[0]);
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public INaturalNumber getRow(int i)
	{
		return this.ordinate.get(i);
	}

	public INaturalNumber[] getOrdinateArray()
	{
		return this.ordinate.toArray(new INaturalNumber[0]);
	}

	@Override
	public void setRow(int i, INaturalNumber in)
	{
		this.abscissa.set(i,in);
	}
	
	@Override
	public void setEntry(int i, INaturalNumber in)
	{
		this.entry.set(i,in);
		
	}

	@Override
	public void setName(String name)
	{
		this.name=name;
	}
	
	@Override
	public void setColumn(int i, INaturalNumber in)
	{
		this.ordinate.set(i,in);
	}
	
	@Override
	public int size()
	{
		return this.abscissa.size();
	}
	
	@Override
	public String toString()
  {
    String ret=this.getName()+"\n";
    for(int i=0;i<this.abscissa.size();i++)
    	ret+=this.getRow(i)+","+this.getColumn(i)+","+this.getEntry(i)+"\n";
	  
    return ret;
  }
}
