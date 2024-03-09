package lk.ijse.d_zone_backend.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO implements SuperDTO {
    private String cust_Id;
    private String cust_Name;
    private String cust_Mail;
    private String cust_Address;
}
