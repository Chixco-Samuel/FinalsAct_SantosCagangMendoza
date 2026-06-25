package com.barangay.models;

public class BarangayService {
     private String serviceId;
    private String serviceName;
    private String description;

    public BarangayService(String serviceId, String serviceName, String description) {
        setServiceId(serviceId);
        setServiceName(serviceName);
        setDescription(description);
    }

    public void setServiceId(String serviceId) {
        if (serviceId == null || serviceId.trim().isEmpty()) {
            throw new IllegalArgumentException("Service ID cannot be null or empty.");
        }
        this.serviceId = serviceId;
    }

     public String getServiceId() {
        return serviceId;
    }

    public void setServiceName(String serviceName) {
        if (serviceName == null || serviceName.trim().isEmpty()) {
            throw new IllegalArgumentException("Service name cannot be null or empty.");
        }
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        this.description = description;
    }

    public String getDescription() {
        return description;
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
    






