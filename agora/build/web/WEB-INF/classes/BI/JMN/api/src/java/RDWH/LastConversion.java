package RDWH;

import java.util.HashMap;
import java.util.Map;

public class LastConversion {

private Content_ content;
private String createdAt;
private String cumulativeSum;
private String source;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Content_ getContent() {
return content;
}

public void setContent(Content_ content) {
this.content = content;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public String getCumulativeSum() {
return cumulativeSum;
}

public void setCumulativeSum(String cumulativeSum) {
this.cumulativeSum = cumulativeSum;
}

public String getSource() {
return source;
}

public void setSource(String source) {
this.source = source;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}