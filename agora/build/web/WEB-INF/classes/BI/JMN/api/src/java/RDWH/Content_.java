package RDWH;

import java.util.HashMap;
import java.util.Map;

public class Content_ {

private String identificador;
private String emailLead;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getIdentificador() {
return identificador;
}

public void setIdentificador(String identificador) {
this.identificador = identificador;
}

public String getEmailLead() {
return emailLead;
}

public void setEmailLead(String emailLead) {
this.emailLead = emailLead;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}