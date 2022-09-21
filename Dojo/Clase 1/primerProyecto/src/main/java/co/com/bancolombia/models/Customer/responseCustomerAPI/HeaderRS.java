package co.com.bancolombia.models.Customer.responseCustomerAPI;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeaderRS {
    public String StatusCode;
    public String StatusDesc;
    public int userID;
}
