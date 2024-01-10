package dk.almbrand.demo.partner.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class Profitability {
    //@Id
    private String cvr;
    private double revenue;
    private double expenses;
    private double netprofit;
}
