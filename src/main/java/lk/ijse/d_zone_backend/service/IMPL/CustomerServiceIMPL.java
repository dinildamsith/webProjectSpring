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

       CustomerEntity existCustomerId = customerRepository.findById(customerDTO.getCust_Id()).orElse(null);
        System.out.println(existCustomerId);
       if (existCustomerId != null) {
           existCustomerId.setCustomer_Name(customerDTO.getCust_Name());
           existCustomerId.setCustomer_Mail(customerDTO.getCust_Mail());
           existCustomerId.setCustomer_Address(customerDTO.getCust_Address());

           customerRepository.save(existCustomerId);
       }else {
           System.out.println("No customer This id have");
       }


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
