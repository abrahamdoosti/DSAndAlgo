
public class Company {
	private String parentCompanyId;
	private String id;
	public Company(String parentCompanyId, String id) {
		super();
		this.parentCompanyId = parentCompanyId;
		this.id = id;
	}
	public String getParentCompanyId() {
		return parentCompanyId;
	}
	public void setParentCompanyId(String parentCompanyId) {
		this.parentCompanyId = parentCompanyId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}



}
