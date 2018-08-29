package RDWH;

import java.util.HashMap;
import java.util.Map;

public class FirstConversion {

    private Content content;
    private String createdAt;
    private String cumulativeSum;
    private String source;
    private ConversionOrigin conversionOrigin;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
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

    public ConversionOrigin getConversionOrigin() {
        return conversionOrigin;
    }

    public void setConversionOrigin(ConversionOrigin conversionOrigin) {
        this.conversionOrigin = conversionOrigin;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}