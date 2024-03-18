package lk.ijse.d_zone_backend.service;

import lk.ijse.d_zone_backend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    String updateCustomer(String updateCustomerId , CustomerDTO customerDTO);
    String deleteCustomer(String deleteId);
    CustomerDTO searchCustomer(String searchId);

    List<CustomerDTO> getAllCustomer();
}
