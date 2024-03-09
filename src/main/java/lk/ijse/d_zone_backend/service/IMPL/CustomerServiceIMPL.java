package lk.ijse.d_zone_backend.service.IMPL;

import lk.ijse.d_zone_backend.conversion.ConversionDATA;
import lk.ijse.d_zone_backend.dto.CustomerDTO;
import lk.ijse.d_zone_backend.entity.CustomerEntity;
import lk.ijse.d_zone_backend.repository.CustomerRepository;
import lk.ijse.d_zone_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ConversionDATA conversionDATA;


    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = conversionDATA.customerDTOConvertCustomerEntity(customerDTO);
        customerRepository.save(customerEntity);
        System.out.println("Customer saved successfully");
        return null;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteCustomer(String deleteId) {

    }

    @Override
    public CustomerDTO searchCustomer(String searchId) {
        return null;
    }
}
