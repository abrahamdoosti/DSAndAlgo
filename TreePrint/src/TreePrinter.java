import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TreePrinter {
	 Map<String ,List<Company>> map;
	 List<Company> companyList;	
	
	   public TreePrinter() {
		super();
		this.map = new HashMap<String, List<Company>>();
	}

	void addToMap(List<Company> companies) throws Exception {
		boolean isRootFound=false;
		for(Company company:companies) {
			if(company.getParentCompanyId().equals("ROOT")){
				companyList=new ArrayList<Company>();
				companyList.add(company);
				map.put("root",companyList);
				isRootFound=true;
			}
			else {
				companyList=map.get(company.getParentCompanyId())!=null?map.get(company.getParentCompanyId()):new ArrayList<Company>();
				companyList.add(company);
				map.put(company.getParentCompanyId(), companyList);
				
			}
		}
		if(!isRootFound)
		{
			throw new Exception("No root element found");
		}
		
	}

	void printTree(List<Company> companies) {
		
		try {
			addToMap(companies);

			List<Company> parentCompanies = new ArrayList<Company>();

			parentCompanies.add(map.get("root").get(0));
			// get Root node and print it

			System.out.println(parentCompanies.get(0).getId());

			while (parentCompanies != null && parentCompanies.size() > 0) {
				List<Company> sameLevelCompanies = new ArrayList<Company>();
				for (String id : parentCompanies.stream().map(x -> x.getId()).collect(Collectors.toList())) {
					if (map.get(id) != null && map.get(id).size() > 0) {
						for (Company c : map.get(id)) {
							sameLevelCompanies.add(c);
							System.out.print(c.getId() + " ");
						}
					}

				}
				System.out.println();
				parentCompanies = sameLevelCompanies;
				sameLevelCompanies = null;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
