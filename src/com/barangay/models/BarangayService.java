package com.barangay.models;

public class BarangayService {
     private String serviceId;
    private String serviceName;
    private String description;

    public BarangayService(String serviceId, String serviceName, String description) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
 
    }

     public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BarangayService{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
    






