package resources;

public enum APIResources {
	
	Logon("/logOn"),
	Parameter("/parameter-download"),
	BalanceEnq("/bal-enq"),
	onlineSale("/online-sale"),
	topup("/top-up"),
	Operatorkey("/operator-keys"),
	keyinjection("/rmki");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
