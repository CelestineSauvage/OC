//package brick;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class OrdSolutions implements Solutions {
//
//	public List<Solution> solutions;
//	private Iterator<Solution> it;
//
//	public OrdSolutions(){
//		this.solutions = new ArrayList<Solution>();
//		this.it = null;
//	}
//
//	public OrdSolutions(List<Solution> solutions){
//		this.solutions = solutions;
//		this.it = this.solutions.iterator();
//	}
//
//	@Override
//	public Solution next() {
//		if( (this.it).hasNext()){
//			return it.next();
//		}
//		return null;
//	}
//
//}
