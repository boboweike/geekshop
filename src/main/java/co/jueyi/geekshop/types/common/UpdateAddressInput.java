package co.jueyi.geekshop.types.common;

import co.jueyi.geekshop.custom.validator.PhoneNumber;
import lombok.Data;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Data
public class UpdateAddressInput {
    private Long id;
    private String fullName;
    private String streetLine1;
    private String streetLine2;
    private String city;
    private String province;
    private String postalCode;
    @PhoneNumber
    private String phoneNumber;
    private Boolean defaultShippingAddress;
    private Boolean defaultBillingAddress;
}
