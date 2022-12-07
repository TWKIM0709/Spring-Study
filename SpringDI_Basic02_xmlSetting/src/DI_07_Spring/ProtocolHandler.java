package DI_07_Spring;

import java.util.List;

public class ProtocolHandler {
	private List<MyFilter> filters;
	
	public List<MyFilter> getFilters(){
		return filters;
	}
	public void setFilters(List<MyFilter> filters) {
		this.filters = filters;
	}
	public int filter_length() {
		return this.filters.size();
	}
}
