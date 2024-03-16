package lk.ijse.d_zone_backend.service.IMPL;

import lk.ijse.d_zone_backend.conversion.ConversionDATA;
import lk.ijse.d_zone_backend.dto.CustomerDTO;
import lk.ijse.d_zone_backend.entity.CustomerEntity;
import lk.ijse.d_zone_backend.repository.CustomerRepository;
import lk.ijse.d_zone_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
        return null;
    }

    @Override
    public String updateCustomer(String updateCustomerId , CustomerDTO customerDTO) {

        Optional<CustomerEntity> updatedCustomerEntity =  customerRepository.findById(updateCustomerId);
        if (!updatedCustomerEntity.isPresent()) return "This Id does not";
        updatedCustomerEntity.get().setCustomer_Name(customerDTO.getCust_Name());
        updatedCustomerEntity.get().setCustomer_Mail(customerDTO.getCust_Mail());
        updatedCustomerEntity.get().setCustomer_Address(customerDTO.getCust_Address());

//       CustomerEntity existCustomerId = customerRepository.findById(customerDTO.getCust_Id()).orElse(null);
//        System.out.println(existCustomerId);
//       if (existCustomerId != null) {
//           existCustomerId.setCustomer_Name(customerDTO.getCust_Name());
//           existCustomerId.setCustomer_Mail(customerDTO.getCust_Mail());
//           existCustomerId.setCustomer_Address(customerDTO.getCust_Address());
//
//           customerRepository.save(existCustomerId);
//       }else {
//           System.out.println("No customer This id have");
//       }
        return null;
    }

    @Override
        public String deleteCustomer(String deleteCustomerId) {

        boolean checkIdHaveCustomer = customerRepository.existsById(deleteCustomerId);
        if (!checkIdHaveCustomer) return "This Id have customer";
        customerRepository.deleteById(deleteCustomerId);
//        CustomerEntity customerEntity = customerRepository.findById(deleteCustomerId).orElse(null);
//        if (customerEntity != null){
//            customerRepository.delete(customerEntity);
//            return "Delete Success";
//        }else {
//            return "This Id No Have";
//        }   c
        return null;
    }

    @Override
    public CustomerDTO searchCustomer(String searchId) {
        CustomerEntity customerEntity = customerRepository.findById(searchId).orElse(null);

        if (customerEntity != null) {
            CustomerDTO customerDTO = conversionDATA.customerEntityConvertCustomerDTO(customerEntity);

            customerDTO.setCust_Id(customerEntity.getCustomer_Id());
            customerDTO.setCust_Name(customerEntity.getCustomer_Name());
            customerDTO.setCust_Mail(customerEntity.getCustomer_Mail());
            customerDTO.setCust_Address(customerEntity.getCustomer_Address());

            return customerDTO;
        } else {
            System.out.println("This Id Has No Customers");
            return null;
        }
    }
}
