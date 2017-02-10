package positronic.satisfiability.naturalnumbertable;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.NaturalNumberTable2FixerException;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class NaturalNumberTable2Fixer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 1L;

	public NaturalNumberTable2Fixer(INaturalNumberTable2 A, 
			long[] rows
				,long[] columns
					,long[] entries) throws Exception
	{
		if(A==null)
			throw new NaturalNumberTable2FixerException("Null INaturalNumberTable2 passed to a constructor.");
		if(columns==null || rows==null || entries==null)
			throw new NaturalNumberTable2FixerException("Null long[] passed to a constructor.");
		IProblem result=null;
		for(int i=0;i<columns.length;i++)
		{
			result=new Conjunction(result,new NaturalNumberFixer(A.getColumn(i),columns[i]));
			result=new Conjunction(result,new NaturalNumberFixer(A.getRow(i),rows[i]));
			result=new Conjunction(result,new NaturalNumberFixer(A.getEntry(i),entries[i]));
		}
			
		this.setClauses(result.getClauses());
	}
}
