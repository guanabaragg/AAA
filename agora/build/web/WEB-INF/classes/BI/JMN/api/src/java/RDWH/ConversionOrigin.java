package RDWH;

import java.util.HashMap;
import java.util.Map;

public class ConversionOrigin {

private String source;
private String medium;
private String value;
private String campaign;
private String channel;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getSource() {
return source;
}

public void setSource(String source) {
this.source = source;
}

public String getMedium() {
return medium;
}

public void setMedium(String medium) {
this.medium = medium;
}

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

public String getCampaign() {
return campaign;
}

public void setCampaign(String campaign) {
this.campaign = campaign;
}

public String getChannel() {
return channel;
}

public void setChannel(String channel) {
this.channel = channel;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}