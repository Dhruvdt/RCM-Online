package com.dhruvdt.rsmonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WireModel {

@SerializedName("name")
@Expose
private String name;
@SerializedName("code")
@Expose
private String code;
@SerializedName("netRate")
@Expose
private String netRate;
@SerializedName("netRateWithGst")
@Expose
private String netRateWithGst;
@SerializedName("quantity")
@Expose
private String quantity;
@SerializedName("amount")
@Expose
private String amount;
@SerializedName("packing")
@Expose
private String packing;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

public String getNetRate() {
return netRate;
}

public void setNetRate(String netRate) {
this.netRate = netRate;
}

public String getNetRateWithGst() {
return netRateWithGst;
}

public void setNetRateWithGst(String netRateWithGst) {
this.netRateWithGst = netRateWithGst;
}

public String getQuantity() {
return quantity;
}

public void setQuantity(String quantity) {
this.quantity = quantity;
}

public String getAmount() {
return amount;
}

public void setAmount(String amount) {
this.amount = amount;
}

public String getPacking() {
return packing;
}

public void setPacking(String packing) {
this.packing = packing;
}

}