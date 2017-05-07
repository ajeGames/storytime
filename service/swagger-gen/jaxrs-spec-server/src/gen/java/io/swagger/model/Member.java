package io.swagger.model;

import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class Member   {
  
  private String screenName = null;
  private String id = null;
  private String identityProvider = null;
  private String email = null;
  private javax.xml.datatype.XMLGregorianCalendar joinedAt = null;
  private Boolean communicationOkay = null;

  /**
   **/
  public Member screenName(String screenName) {
    this.screenName = screenName;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getScreenName() {
    return screenName;
  }
  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  /**
   **/
  public Member id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   **/
  public Member identityProvider(String identityProvider) {
    this.identityProvider = identityProvider;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getIdentityProvider() {
    return identityProvider;
  }
  public void setIdentityProvider(String identityProvider) {
    this.identityProvider = identityProvider;
  }

  /**
   **/
  public Member email(String email) {
    this.email = email;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   **/
  public Member joinedAt(javax.xml.datatype.XMLGregorianCalendar joinedAt) {
    this.joinedAt = joinedAt;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public javax.xml.datatype.XMLGregorianCalendar getJoinedAt() {
    return joinedAt;
  }
  public void setJoinedAt(javax.xml.datatype.XMLGregorianCalendar joinedAt) {
    this.joinedAt = joinedAt;
  }

  /**
   **/
  public Member communicationOkay(Boolean communicationOkay) {
    this.communicationOkay = communicationOkay;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public Boolean getCommunicationOkay() {
    return communicationOkay;
  }
  public void setCommunicationOkay(Boolean communicationOkay) {
    this.communicationOkay = communicationOkay;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Member member = (Member) o;
    return Objects.equals(screenName, member.screenName) &&
        Objects.equals(id, member.id) &&
        Objects.equals(identityProvider, member.identityProvider) &&
        Objects.equals(email, member.email) &&
        Objects.equals(joinedAt, member.joinedAt) &&
        Objects.equals(communicationOkay, member.communicationOkay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(screenName, id, identityProvider, email, joinedAt, communicationOkay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Member {\n");
    
    sb.append("    screenName: ").append(toIndentedString(screenName)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    identityProvider: ").append(toIndentedString(identityProvider)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    joinedAt: ").append(toIndentedString(joinedAt)).append("\n");
    sb.append("    communicationOkay: ").append(toIndentedString(communicationOkay)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
