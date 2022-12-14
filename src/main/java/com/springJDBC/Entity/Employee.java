package com.springJDBC.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Employee {

    private int id;
    private String name;
    private String dept;
    private String email;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date doj;
}
