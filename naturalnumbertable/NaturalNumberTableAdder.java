/*
 * NaturalNumberTableAdder.java	1.0 05/04/15
 *
 * Copyright 2004-2005 Positronic Software.
 *
 *
 */

package positronic.satisfiability.naturalnumbertable;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.NaturalNumberTableAdderException;
import positronic.satisfiability.naturalnumber.NaturalNumberAdder;

public class NaturalNumberTableAdder extends MetaProblem implements IProblem
{
  private static final long serialVersionUID = 1L;

	public NaturalNumberTableAdder(INaturalNumberTable X, INaturalNumberTable Y, INaturalNumberTable Z) throws Exception
  {
    if(!X.isSameSizeAs(Y) || !X.isSameSizeAs(Z))
      throw new NaturalNumberTableAdderException("INaturalNumberTables of differing sizes were passed to a constructor.");
    else
    {
      IProblem[] p=new IProblem[X.getNumberOfRows()*X.getNumberOfColumns()];
      int count=0;
      for(int i=0;i<X.getNumberOfRows();i++)
      	for(int j=0;j<X.getNumberOfColumns();j++)
      		p[count++]=new NaturalNumberAdder(X.getNaturalNumber(i,j),Y.getNaturalNumber(i,j),Z.getNaturalNumber(i,j));
      this.setClauses(new Conjunction(p).getClauses());
    }
  }
}