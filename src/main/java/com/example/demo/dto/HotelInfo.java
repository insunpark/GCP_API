package com.example.demo.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelInfo {
    private int hotelNo;
    private String hotelName;
    private String hotelPhoto;
    private String hotelLocation;
    private String hotelGrade;
    private String hotelBreakfast;
}
