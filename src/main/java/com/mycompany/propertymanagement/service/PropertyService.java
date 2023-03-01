package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
    public List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO,Long propertyId);
    PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId);
    PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId);
    void deleteProperty(Long propertyId);

}
