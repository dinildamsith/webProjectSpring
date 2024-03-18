package lk.ijse.d_zone_backend.conversion;

import lk.ijse.d_zone_backend.dto.CustomerDTO;
import lk.ijse.d_zone_backend.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

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


    public List<CustomerDTO> customerEntityListConvertCustomerDtoList(List<CustomerEntity> customerEntityList){
        return modelMapper.map(customerEntityList, List.class);
    }

}
