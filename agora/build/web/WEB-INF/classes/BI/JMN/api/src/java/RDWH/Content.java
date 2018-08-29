package RDWH;

import java.util.HashMap;
import java.util.Map;

public class Content {

private String identificador;
private String nome;
private String emailLead;
private String telefone;
private String empresa;
private String cargo;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getIdentificador() {
return identificador;
}

public void setIdentificador(String identificador) {
this.identificador = identificador;
}

public String getNome() {
return nome;
}

public void setNome(String nome) {
this.nome = nome;
}

public String getEmailLead() {
return emailLead;
}

public void setEmailLead(String emailLead) {
this.emailLead = emailLead;
}

public String getTelefone() {
return telefone;
}

public void setTelefone(String telefone) {
this.telefone = telefone;
}

public String getEmpresa() {
return empresa;
}

public void setEmpresa(String empresa) {
this.empresa = empresa;
}

public String getCargo() {
return cargo;
}

public void setCargo(String cargo) {
this.cargo = cargo;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}