package lk.ijse.d_zone_backend.service;

import lk.ijse.d_zone_backend.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    String deleteCustomer(String deleteId);
    CustomerDTO searchCustomer(String searchId);
}
