package positronic.satisfiability.naturalnumbertable;

import positronic.satisfiability.naturalnumber.INaturalNumber;

public interface INaturalNumberTable2
{
	INaturalNumber getColumn(int i);
	INaturalNumber getEntry(int i);
	String getName();
	INaturalNumber getRow(int i);
	void setRow(int i,INaturalNumber in);
	void setEntry(int i,INaturalNumber in);
	void setName(String name);
	void setColumn(int i,INaturalNumber in);
	int size();
	@Override
	String toString();
}
