package RDWH;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeadWH {

    private List<Lead> leads = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
