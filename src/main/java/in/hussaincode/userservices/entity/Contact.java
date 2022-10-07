package in.hussaincode.userservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private Long cId;
    private String email;
    private String contactName;
    private Long userId;

}
