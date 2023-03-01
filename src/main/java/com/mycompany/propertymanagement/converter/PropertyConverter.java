package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
    PropertyEntity pe=new PropertyEntity();
    pe.setTitle(propertyDTO.getTitle());
    pe.setAddress(propertyDTO.getAddress());
    pe.setOwnerEmail(propertyDTO.getOwnerEmail());
    pe.setDescription(propertyDTO.getDescription());
    pe.setOwnerName(propertyDTO.getOwnerName());
    pe.setPrice(propertyDTO.getPrice());
return pe;
}

public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity){
     PropertyDTO propertyDTO=new PropertyDTO();
     propertyDTO.setId(propertyEntity.getId());
    propertyDTO.setTitle(propertyEntity.getTitle());
    propertyDTO.setAddress(propertyEntity.getAddress());
    propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
    propertyDTO.setDescription(propertyEntity.getDescription());
    propertyDTO.setOwnerName(propertyEntity.getOwnerName());
    propertyDTO.setPrice(propertyEntity.getPrice());

    return propertyDTO;

}

}
