package RDWH;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lead {

private String id;
private String uuid;
private String email;
private String name;
private String company;
private String jobTitle;
private String bio;
private String publicUrl;
private String createdAt;
private String opportunity;
private String numberConversions;
private String user;
private FirstConversion firstConversion;
private LastConversion lastConversion;
private CustomFields customFields;
private String website;
private String personalPhone;
private String mobilePhone;
private String city;
private String state;
private String leadStage;
private List<String> tags = null;
private String fitScore;
private long interest;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getUuid() {
return uuid;
}

public void setUuid(String uuid) {
this.uuid = uuid;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getCompany() {
return company;
}

public void setCompany(String company) {
this.company = company;
}

public String getJobTitle() {
return jobTitle;
}

public void setJobTitle(String jobTitle) {
this.jobTitle = jobTitle;
}

public String getBio() {
return bio;
}

public void setBio(String bio) {
this.bio = bio;
}

public String getPublicUrl() {
return publicUrl;
}

public void setPublicUrl(String publicUrl) {
this.publicUrl = publicUrl;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public String getOpportunity() {
return opportunity;
}

public void setOpportunity(String opportunity) {
this.opportunity = opportunity;
}

public String getNumberConversions() {
return numberConversions;
}

public void setNumberConversions(String numberConversions) {
this.numberConversions = numberConversions;
}

public String getUser() {
return user;
}

public void setUser(String user) {
this.user = user;
}

public FirstConversion getFirstConversion() {
return firstConversion;
}

public void setFirstConversion(FirstConversion firstConversion) {
this.firstConversion = firstConversion;
}

public LastConversion getLastConversion() {
return lastConversion;
}

public void setLastConversion(LastConversion lastConversion) {
this.lastConversion = lastConversion;
}

public CustomFields getCustomFields() {
return customFields;
}

public void setCustomFields(CustomFields customFields) {
this.customFields = customFields;
}

public String getWebsite() {
return website;
}

public void setWebsite(String website) {
this.website = website;
}

public String getPersonalPhone() {
return personalPhone;
}

public void setPersonalPhone(String personalPhone) {
this.personalPhone = personalPhone;
}

public String getMobilePhone() {
return mobilePhone;
}

public void setMobilePhone(String mobilePhone) {
this.mobilePhone = mobilePhone;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

public String getLeadStage() {
return leadStage;
}

public void setLeadStage(String leadStage) {
this.leadStage = leadStage;
}

public List<String> getTags() {
return tags;
}

public void setTags(List<String> tags) {
this.tags = tags;
}

public String getFitScore() {
return fitScore;
}

public void setFitScore(String fitScore) {
this.fitScore = fitScore;
}

public long getInterest() {
return interest;
}

public void setInterest(long interest) {
this.interest = interest;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}