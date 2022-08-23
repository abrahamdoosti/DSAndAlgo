import java.util.ArrayList;
import java.util.List;

public class TreePrintTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Company> companies=new ArrayList<Company>();
		companies.add(new Company("ROOT", "1"));
		companies.add(new Company("1", "2"));
		companies.add(new Company("1", "3"));
		companies.add(new Company("1", "4"));
		companies.add(new Company("2", "25"));
		companies.add(new Company("2", "28"));
		companies.add(new Company("2", "27"));
		companies.add(new Company("4", "41"));
		companies.add(new Company("4", "43"));
		companies.add(new Company("4", "42"));
		companies.add(new Company("3", "13"));
		TreePrinter tp = new TreePrinter();
		tp.printTree(companies);
       
	}

}
