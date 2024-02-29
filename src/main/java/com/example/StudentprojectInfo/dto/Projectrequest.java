package com.example.StudentprojectInfo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projectrequest {
    @Pattern(regexp = "^\\d{2}[A-Z]\\d{2}[A-Z]\\d{4}$")
    public String rollno;
    @NotNull(message="Name cannot be a null")
    public String name;
    @NotNull(message="batch cannot be a null")
    public String batch;
    @Email(message = "Email should be valid", regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    @NotNull(message="email cannot be a null")
    public String email;
    @NotNull(message="phone cannot be a null")
    @Pattern(regexp="^\\d{10}$")
    public String phone;
    @NotNull(message="department cannot be a null")
    @NotBlank(message = "Description cannot be blank")
    public String department;
    @NotNull(message = "Semester cannot be null")
    @Pattern(regexp = "^\\d{2}$")
    public String semester;
    @NotNull(message = "Project name cannot be null")
    public String projectname;
    @NotBlank(message = "Description cannot be blank")
    @NotNull(message = "Description cannot be null")
    public String description;
    @NotNull(message = "Status cannot be null")
    @Pattern(regexp = "^(Accepted|Rejected|Pending)$") // Accepted, Rejected, Pending
    public String status;
    @NotNull(message = "Supervisor cannot be null")
    @Pattern(regexp = "^[a-zA-Z ]+$") // Only letters and spaces allowed in supervisor name field.
    public String supervisor;
    @NotNull(message = "Hod name cannot be null")
    @Pattern(regexp = "^[a-zA-Z ]+$") // Only letters and spaces allowed for hod name.
    public String hodname;
    @NotNull(message = "Date cannot be null")
    public Date date;
    @NotNull(message = "Topic cannot be null")
    @Pattern(regexp = "^[a-zA-Z ]+$") // Only letters and spaces allowed for topic name.
    public String topic;
    @NotNull(message = "Github link cannot be null")
    @Pattern(regexp = "^(https?://)?(www.)?github.com/[a-zA-Z0-9-]+/[a-zA-Z0-9-]+$") // Github link validation.
    public String githublink;
    @NotNull(message = "Project link cannot be null")
    @Pattern(regexp = "^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:/[^\s]*)?$")
    public String projectlink;
}
