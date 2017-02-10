package positronic.satisfiability.naturalnumbertable;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.naturalnumber.NaturalNumberXorer;

public class NaturalNumberTableXorer extends MetaProblem implements IProblem
{
  private static final long serialVersionUID = -8058265651886336402L;

	public NaturalNumberTableXorer(INaturalNumberTable X, INaturalNumberTable Y, INaturalNumberTable Z) throws Exception
  {
    if(!X.isSameSizeAs(Y) || !X.isSameSizeAs(Z))
      this.setClauses(MetaProblem.unsolvableProblem().getClauses());
    else
    {
      IProblem[] p=new IProblem[X.getNumberOfRows()*X.getNumberOfColumns()];
      int count=0;
      for(int i=0;i<X.getNumberOfRows();i++)
        for(int j=0;j<X.getNumberOfColumns();j++)
          p[count++]=new NaturalNumberXorer(X.getNaturalNumber(i,i),Y.getNaturalNumber(i,j),Z.getNaturalNumber(i,j));
      this.setClauses(new Conjunction(p).getClauses());
    }
  }
}
