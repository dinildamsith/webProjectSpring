package lk.ijse.d_zone_backend.conversion;

import lk.ijse.d_zone_backend.dto.CustomerDTO;
import lk.ijse.d_zone_backend.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConversionDATA {

    final private ModelMapper modelMapper;

    public ConversionDATA(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CustomerDTO customerEntityConvertCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public CustomerEntity customerDTOConvertCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }
}
